package com.cdsc.eje.gui;

import java.awt.Event;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.KeyStroke;

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

public class EJEAreaPopupMenu extends JPopupMenu {
	/**
	 * The serial version UID for this class.
	 */
	private static final long serialVersionUID = 2456545409364946536L;

	private JMenuItem saveMenuItem;

	private JMenuItem compileMenuItem;

	private JMenuItem executeMenuItem;

	private JMenuItem formatCodeMenuItem;

	private JMenuItem closeMenuItem;

	private JMenuItem cutMenuItem;

	private JMenuItem copyMenuItem;

	private JMenuItem pasteMenuItem;

	private JMenuItem deleteMenuItem;

	private JMenuItem commentSelectionMenuItem;

	private JMenuItem selectAllMenuItem;

	private JMenuItem toUpperCaseMenuItem;

	private JMenuItem toLowerCaseMenuItem;

	private JMenuItem invertCaseMenuItem;

	private EJE eje;

	public EJEAreaPopupMenu() {
		eje = EJE.getEJE();
		saveMenuItem = new JMenuItem(EJE.resources.getString("file.save"), new ImageIcon(
				"resources/images/save.png"));
		compileMenuItem = new JMenuItem(EJE.resources.getString("build.compile"), new ImageIcon(
				"resources/images/compile.png"));
		executeMenuItem = new JMenuItem(EJE.resources.getString("build.execute"), new ImageIcon(
				"resources/images/execute.png"));
		formatCodeMenuItem = new JMenuItem(EJE.resources.getString("tools.format_code"),
				new ImageIcon("resources/images/format.png"));
		closeMenuItem = new JMenuItem(EJE.resources.getString("file.close_file"), new ImageIcon(
				"resources/images/close.png"));
		cutMenuItem = new JMenuItem(EJE.resources.getString("edit.cut"), new ImageIcon(
				"resources/images/cut.png"));
		copyMenuItem = new JMenuItem(EJE.resources.getString("edit.copy"), new ImageIcon(
				"resources/images/copy.png"));
		pasteMenuItem = new JMenuItem(EJE.resources.getString("edit.paste"), new ImageIcon(
				"resources/images/paste.png"));
		deleteMenuItem = new JMenuItem(EJE.resources.getString("edit.delete"), new ImageIcon(
				"resources/images/delete.png"));
		commentSelectionMenuItem = new JMenuItem(EJE.resources.getString("insert.comment"),
				new ImageIcon("resources/images/comment_selection.png"));
		selectAllMenuItem = new JMenuItem(EJE.resources.getString("edit.select_all"),
				new ImageIcon("resources/images/selectall.png"));
		toUpperCaseMenuItem = new JMenuItem(EJE.resources.getString("edit.to_upper_case"),
				new ImageIcon("resources/images/up.png"));
		toLowerCaseMenuItem = new JMenuItem(EJE.resources.getString("edit.to_lower_case"),
				new ImageIcon("resources/images/down.png"));
		invertCaseMenuItem = new JMenuItem(EJE.resources.getString("edit.invert_case"),
				new ImageIcon("resources/images/refresh.png"));

		registerComponents();
		setup();
		addDetails();
	}

	public void setup() {
		add(saveMenuItem);
		addSeparator();
		add(compileMenuItem);
		add(executeMenuItem);
		addSeparator();
		add(cutMenuItem);
		add(copyMenuItem);
		add(pasteMenuItem);
		add(deleteMenuItem);
		addSeparator();
		add(commentSelectionMenuItem);
		addSeparator();
		add(selectAllMenuItem);
		addSeparator();
		add(toUpperCaseMenuItem);
		add(toLowerCaseMenuItem);
		add(invertCaseMenuItem);
		addSeparator();
		add(formatCodeMenuItem);
		addSeparator();
		add(closeMenuItem);
	}

	public void registerComponents() {
		saveMenuItem.addActionListener(eje.saveAction);
		compileMenuItem.addActionListener(eje.new CompileAction());
		executeMenuItem.addActionListener(eje.new ExecuteAction());
		cutMenuItem.addActionListener(eje.cutAction);
		copyMenuItem.addActionListener(eje.copyAction);
		pasteMenuItem.addActionListener(eje.pasteAction);
		deleteMenuItem.addActionListener(eje.new DeleteAction());
		commentSelectionMenuItem.addActionListener(eje.insertAction);
		selectAllMenuItem.addActionListener(eje.new SelectAllAction());
		toUpperCaseMenuItem.addActionListener(eje.new ToUpperCaseAction());
		toLowerCaseMenuItem.addActionListener(eje.new ToLowerCaseAction());
		invertCaseMenuItem.addActionListener(eje.new InvertCaseAction());
		formatCodeMenuItem.addActionListener(eje.formatCodeAction);
		closeMenuItem.addActionListener(EJE.getEJE().closeAction);
	}

	private void addDetails() {
		saveMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, Event.CTRL_MASK));
		compileMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F7, 0));
		executeMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F9, 0));
		cutMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, Event.CTRL_MASK));
		copyMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, Event.CTRL_MASK));
		pasteMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V, Event.CTRL_MASK));
		deleteMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_H, Event.CTRL_MASK));
		commentSelectionMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F12,
				Event.CTRL_MASK));
		selectAllMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, Event.CTRL_MASK));
		toUpperCaseMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_U, Event.CTRL_MASK));
		toLowerCaseMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L, Event.CTRL_MASK));
		invertCaseMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_J, Event.CTRL_MASK));
		formatCodeMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F, Event.CTRL_MASK
				+ InputEvent.SHIFT_MASK));
		closeMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, Event.CTRL_MASK
				+ InputEvent.SHIFT_MASK));
		this.setOpaque(true);
	}
}