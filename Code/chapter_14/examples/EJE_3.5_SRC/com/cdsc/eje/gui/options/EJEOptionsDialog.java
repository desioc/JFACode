package com.cdsc.eje.gui.options;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.UIManager;

import com.cdsc.eje.gui.EJE;

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

public class EJEOptionsDialog extends JDialog implements Reloadable, Storer {

	private static final long serialVersionUID = 4491199581280683443L;

	private static final String OPTIONS_TITLE = "options.title";

	private static final String OPTIONS_BUTTON_APPLY = "options.button.apply";

	private static final String OPTIONS_BUTTON_CANCEL = "options.button.cancel";

	private static final String OPTIONS_BUTTON_OK = "options.button.ok";

	private static EJEOptionsDialog ejeOptionsDialog = null;

	private JTabbedPane tabbedPane;

	private ProjectOptionsPanel projectOptionsPanel;

	private EditorOptionsPanel editorOptionsPanel;

	private JavaOptionsPanel javaOptionsPanel;

	private EJEOptionsPanel ejeOptionsPanel;

	private JPanel buttonPanel;

	private JButton okButton;

	private JButton cancelButton;

	private JButton applyButton;

	private Vector reloadables;

	private Vector storers;

	private EJEOptionsDialog() {
		super(EJE.getEJE());
		setModal(true);
		setResizable(false);
		okButton = new JButton(EJE.resources.getString(OPTIONS_BUTTON_OK));
		cancelButton = new JButton(EJE.resources.getString(OPTIONS_BUTTON_CANCEL));
		applyButton = new JButton(EJE.resources.getString(OPTIONS_BUTTON_APPLY));
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		projectOptionsPanel = new ProjectOptionsPanel();
		editorOptionsPanel = new EditorOptionsPanel();
		javaOptionsPanel = new JavaOptionsPanel();
		ejeOptionsPanel = new EJEOptionsPanel();
		buttonPanel = new JPanel();
		reloadables = new Vector();
		storers = new Vector();
		registerListeners();
		setup();
	}

	private void registerListeners() {
		cancelButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				reload();
			}
		});
		applyButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				store();
				reload();
			}
		});
		okButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				store();
				setVisible(false);
				reload();
			}
		});
	}

	private void setup() {
		setLayouts();
		reloadables.addElement(projectOptionsPanel);
		reloadables.addElement(editorOptionsPanel);
		reloadables.addElement(javaOptionsPanel);
		reloadables.addElement(ejeOptionsPanel);
		storers.addElement(projectOptionsPanel);
		storers.addElement(editorOptionsPanel);
		storers.addElement(javaOptionsPanel);
		storers.addElement(ejeOptionsPanel);
		setTitle(EJE.resources.getString(OPTIONS_TITLE));
		// TODO
		tabbedPane.addTab("Project", projectOptionsPanel);
		tabbedPane.addTab("Java", javaOptionsPanel);
		tabbedPane.addTab("Editor", editorOptionsPanel);
		tabbedPane.addTab("EJE", ejeOptionsPanel);
		tabbedPane.setOpaque(true);
		buttonPanel.add(okButton);
		buttonPanel.add(cancelButton);
		buttonPanel.add(applyButton);
		getContentPane().add(tabbedPane, BorderLayout.CENTER);
		getContentPane().add(buttonPanel, BorderLayout.SOUTH);
		pack();
	}

	private void setLayouts() {
		getContentPane().setLayout(new BorderLayout());
	}

	public static EJEOptionsDialog getInstance() {
		if (ejeOptionsDialog == null) {
			ejeOptionsDialog = new EJEOptionsDialog();
		}
		return ejeOptionsDialog;
	}

	public UIManager.LookAndFeelInfo[] getLookAndFeelInfo() {
		return ejeOptionsPanel.getLookAndFeelInfo();
	}

	@Override
	public void reload() {
		Iterator iterator = reloadables.iterator();
		while (iterator.hasNext()) {
			Reloadable reloadable = (Reloadable) iterator.next();
			reloadable.reload();
		}
	}

	@Override
	public void store() {
		Iterator iterator = storers.iterator();
		while (iterator.hasNext()) {
			Storer storer = (Storer) iterator.next();
			storer.store();
		}
	}

	public void addReloadable(Reloadable reloadable) {
		reloadables.addElement(reloadable);
	}

	public void removeReloadable(Reloadable reloadable) {
		reloadables.removeElement(reloadable);
	}

	public void addStorer(Storer storer) {
		storers.addElement(storer);
	}

	public void removeStorer(Storer storer) {
		storers.removeElement(storer);
	}

	@Override
	public void setVisible(boolean flag) {
		if (flag) {
			reload();
		}
		super.setVisible(flag);
	}

	public EditorOptionsPanel getEditorOptionsPanel() {
		return editorOptionsPanel;
	}

	public void setEditorOptionsPanel(EditorOptionsPanel editorOptionsPanel) {
		this.editorOptionsPanel = editorOptionsPanel;
	}

	public EJEOptionsPanel getEjeOptionsPanel() {
		return ejeOptionsPanel;
	}

	public void setEjeOptionsPanel(EJEOptionsPanel ejeOptionsPanel) {
		this.ejeOptionsPanel = ejeOptionsPanel;
	}

	public JavaOptionsPanel getJavaOptionsPanel() {
		return javaOptionsPanel;
	}

	public void setJavaOptionsPanel(JavaOptionsPanel javaOptionsPanel) {
		this.javaOptionsPanel = javaOptionsPanel;
	}

}