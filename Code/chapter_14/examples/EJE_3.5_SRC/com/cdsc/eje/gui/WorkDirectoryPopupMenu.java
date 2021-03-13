package com.cdsc.eje.gui;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.tree.DefaultTreeModel;

import com.cdsc.eje.gui.utilities.EJEUtils;

/**
 * FLM - version 2.0 - "Free Lance Memory"
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
 * Info, Questions, Suggestions & Bugs Report to claudio@claudiodesio.com
 *
 * @author Claudio De Sio Cesari
 */
/**
 * The popup menu for the work directory.
 */
public class WorkDirectoryPopupMenu extends JPopupMenu {
	/**
	 * The serial version UID for this class.
	 */
	private static final long serialVersionUID = 1992134665271286210L;

	/**
	 * The menu item that will close a directory.
	 */
	private JMenuItem closeMenuItem;

	/**
	 * Create a new EJETreePopupMenu object.
	 */
	public WorkDirectoryPopupMenu() {
		super();
		closeMenuItem = new JMenuItem(EJE.resources.getString("tree.close"), new ImageIcon(
				"resources/images/close.png"));
		setup();
		registerListeners();
	}

	private void registerListeners() {
		closeMenuItem.addActionListener(new AbstractAction() {
			private static final long serialVersionUID = 8509646652243377332L;

			@Override
			public void actionPerformed(ActionEvent e) {
				EJETree ejeTree = EJE.getEJE().getEjeTree();
				EJEMutableTreeNode node = (EJEMutableTreeNode) ejeTree
						.getLastSelectedPathComponent();
				if (EJEUtils.isWorkDirectory(node.getFile().getAbsolutePath())) {
					DefaultTreeModel model = (DefaultTreeModel) ejeTree.getModel();
					model.removeNodeFromParent(node);
					String value = EJE.options.getProperty("user.work_dir");
					EJE.options.setProperty("user.work_dir", value.replace(node.getFile().getAbsolutePath()+";", ""));
					EJE.saveProperties();
				}
			}
		});
	}

	private void setup() {
		add(closeMenuItem);
	}
	/**
	 * Getter method for closeMenuItem property.
	 *
	 * @return the closeMenuItem.
	 */
	public JMenuItem getCloseMenuItem() {
		return closeMenuItem;
	}

	/**
	 * Setter method for closeMenuItem property.
	 *
	 * @param closeMenuItem
	 *            the closeMenuItem to set.
	 */
	public void setCloseMenuItem(JMenuItem closeMenuItem) {
		this.closeMenuItem = closeMenuItem;
	}
}