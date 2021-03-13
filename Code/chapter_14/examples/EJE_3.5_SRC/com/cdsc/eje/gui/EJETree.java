package com.cdsc.eje.gui;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.util.Enumeration;

import javax.swing.ImageIcon;
import javax.swing.JTree;
import javax.swing.event.TreeExpansionEvent;
import javax.swing.event.TreeExpansionListener;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.filechooser.FileSystemView;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.MutableTreeNode;
import javax.swing.tree.TreeSelectionModel;

import com.cdsc.eje.entities.JavaFile;
import com.cdsc.eje.gui.utilities.EJEUtils;

/*
 * EJE - version 3.5 - "Everyone's Java Editor"
 *
 * Copyright (C) 2003-2018 Claudio De Sio Cesari
 *
 * Require JDK 1.8
 *
 * This program is free software; you can redistribute it and/or modify it under
 * the terms of the GNU General Public License as published by the Free Software
 * Foundation; either version 2 of the License, or (at your option) any later
 * version.
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU General Public License for more
 * details.
 *
 * You should have received a copy of the GNU General Public License along with
 * this program; if not, write to the Free Software Foundation, Inc., 59 Temple
 * Place, Suite 330, Boston, MA 02111-1307 USA
 *
 *
 * Info, Questions, Suggestions & Bugs Report to eje@claudiodesio.com
 *
 */
/**
 * The tree file view, to explore file with EJE.
 */
public class EJETree extends JTree {

	/**
	 * The serial version UID for this class.
	 */
	private static final long serialVersionUID = 2632784031898146408L;

	private EJETreePopupMenu ejeTreePopupMenu;

	private WorkDirectoryPopupMenu workDirectoryPopupMenu;

	/**
	 * Create a new EJETree object.
	 *
	 * @param root
	 */
	public EJETree(DefaultMutableTreeNode root) {
		super(root);
		ejeTreePopupMenu = new EJETreePopupMenu();
		workDirectoryPopupMenu = new WorkDirectoryPopupMenu();
		setup(root);
		registerComponents();
		addDetails();
	}

	private void setup(DefaultMutableTreeNode root) {
		loadProperties();
		createUserDirNodes(root, "user.work_dir");
		createUserDirNodes(root, "user.home");
		createTopNodes(root);
	}

	private void registerComponents() {
		this.addTreeSelectionListener(treeSelectionListener);
		this.addTreeExpansionListener(treeExpansionListener);
		this.addMouseListener(popupListener);
	}

	private void addDetails() {
		getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
		DefaultTreeCellRenderer renderer = new DefaultTreeCellRenderer();
		renderer.setLeafIcon(new ImageIcon("resources/images/javaicon.png"));
		renderer.setClosedIcon(new ImageIcon("resources/images/folder.png"));
		renderer.setOpenIcon(new ImageIcon("resources/images/openfolder.png"));
		this.setCellRenderer(renderer);
		this.setShowsRootHandles(true);
		this.expandRow(0);
	}

	private void loadProperties() {
		try {
			String workDir = EJE.options.getProperty("user.work_dir");
			System.setProperty("user.work_dir", workDir);
		} catch (Exception exc) {
			System.out.println(exc);
		}
	}

	public void createUserDirNodes(DefaultMutableTreeNode root, String dir) {
		try {
			Enumeration<?> children = root.children();
			String workDirValue = System.getProperty(dir);
			String[] workDirValues = workDirValue.split(";");
			if (workDirValues != null) {
				for (String workDir : workDirValues) {
					if (workDir != null && workDir.length() != 0) {
						File userDir = new File(workDir);
						if (userDir.isDirectory()) {
							EJEMutableTreeNode userDirNode = new EJEMutableTreeNode(userDir);
							boolean found = false;
							while (children.hasMoreElements()) {
								MutableTreeNode mutableTreeNode = (MutableTreeNode) children
										.nextElement();
								if (mutableTreeNode.equals(userDirNode)) {
									found = true;
									break;
								}

							}
							if (!found) {
								root.add(userDirNode);
								userDirNode.createNodes();
							}
						}
					}
				}
			}
		} catch (NullPointerException exc) {
			System.out.println("Work directory not specified");
		} catch (Exception exc) {
			System.out.println("Work directory not valid or not specified");
		}
	}

	private void createTopNodes(DefaultMutableTreeNode root) {
		File[] rootList = File.listRoots();
		FileSystemView view = FileSystemView.getFileSystemView();
		for (int i = 0; i < rootList.length; ++i) {
			if (!view.isFloppyDrive(rootList[i])) {
				if (view.isFileSystemRoot(rootList[i]) && rootList[i].exists()) {
					EJEMutableTreeNode node = new EJEMutableTreeNode(rootList[i]);
					root.add(node);
					// node.createNodes();
				}
			}
		}
	}

	TreeSelectionListener treeSelectionListener = new TreeSelectionListener() {
		@Override
		public synchronized void valueChanged(TreeSelectionEvent ev) {
			try {
				EJEMutableTreeNode node = (EJEMutableTreeNode) EJETree.this
						.getLastSelectedPathComponent();
				if (node == null)
					return;
				File file = node.getFile();
				if (file.isFile()) {
					EJE.getEJE().processOpenAction(new JavaFile(file.getParent(), file.getName()));
				} else {
					//File fileNode = new File(node.toString());
					//Object nodeInfo = node.getUserObject();
					node.createNodes();
				}
			} catch (Exception exc) {
				System.out.println("Tree initialized");
			}
		}
	};

	TreeExpansionListener treeExpansionListener = new TreeExpansionListener() {
		@Override
		public void treeCollapsed(TreeExpansionEvent event) {
		}

		@Override
		public synchronized void treeExpanded(TreeExpansionEvent event) {
			try {
				EJEMutableTreeNode node = (EJEMutableTreeNode) event.getPath()
						.getLastPathComponent();
				node.createNodes();
				DefaultTreeModel model = (DefaultTreeModel) getModel();
				model.nodeStructureChanged(node);
			} catch (Exception exc) {
				System.out.println("Tree initialized");
			}
		}
	};

	MouseListener popupListener = new MouseAdapter() {
		@Override
		public void mousePressed(MouseEvent e) {
			maybeShowPopup(e);
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			maybeShowPopup(e);
		}

		private void maybeShowPopup(MouseEvent e) {
			int selRow = getRowForLocation(e.getX(), e.getY());
			if (selRow != -1) {
				setSelectionRow(selRow);
				getSelectionModel().setSelectionPath(getSelectionPath());
				EJEMutableTreeNode node = (EJEMutableTreeNode) getLastSelectedPathComponent();
				if (node != null
						&& e.getButton() == MouseEvent.BUTTON3
						&& EJEUtils.isWorkDirectory(node.fileNode.getAbsolutePath())) {
					workDirectoryPopupMenu.show(e.getComponent(), e.getX(), e.getY());
				}
			} else if (e.getButton() == MouseEvent.BUTTON3) {
				ejeTreePopupMenu.show(e.getComponent(), e.getX(), e.getY());
			}
		}
	};
	/**
	 * Getter method for ejeTreePopupMenu property.
	 *
	 * @return the ejeTreePopupMenu.
	 */
	public EJETreePopupMenu getEjeTreePopupMenu() {
		return ejeTreePopupMenu;
	}

	/**
	 * Setter method for ejeTreePopupMenu property.
	 *
	 * @param ejeTreePopupMenu
	 *            the ejeTreePopupMenu to set.
	 */
	public void setEjeTreePopupMenu(EJETreePopupMenu ejeTreePopupMenu) {
		this.ejeTreePopupMenu = ejeTreePopupMenu;
	}

	/**
	 * Setter method for workDirectoryPopupMenu property.
	 *
	 * @param workDirectoryPopupMenu
	 *            the workDirectoryPopupMenu to set.
	 */
	public void setWorkDirectoryPopupMenu(WorkDirectoryPopupMenu workDirectoryPopupMenu) {
		this.workDirectoryPopupMenu = workDirectoryPopupMenu;
	}

	/**
	 * Getter method for workDirectoryPopupMenu property.
	 *
	 * @return the workDirectoryPopupMenu.
	 */
	public WorkDirectoryPopupMenu getWorkDirectoryPopupMenu() {
		return workDirectoryPopupMenu;
	}
}