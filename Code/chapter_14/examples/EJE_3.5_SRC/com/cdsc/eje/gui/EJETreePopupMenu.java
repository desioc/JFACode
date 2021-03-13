package com.cdsc.eje.gui;

import javax.swing.ImageIcon;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

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
 * The popup menu on the EJE tree.
 */
public class EJETreePopupMenu extends JPopupMenu {
	/**
	 * The serial version UID for this class.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * The menu item that allow to choose a work directory.
	 */
	private JMenuItem workDirectoryMenuItem;


	/**
	 * Create a new EJETreePopupMenu object.
	 */
	public EJETreePopupMenu() {
		super();
		workDirectoryMenuItem = new JMenuItem(EJE.resources.getString("build.work_directory"), new ImageIcon(
				"resources/images/folder.png"));
		setup();
		registerListeners();
	}

	private void registerListeners() {

	}

	private void setup() {
		add(workDirectoryMenuItem);
	}

	/**
	 * Getter method for refreshMenuItem property.
	 *
	 * @return the refreshMenuItem.
	 */
	public JMenuItem getWorkDirectoryMenuItem() {
		return workDirectoryMenuItem;
	}

	/**
	 * Setter method for refreshMenuItem property.
	 *
	 * @param refreshMenuItem
	 *            the refreshMenuItem to set.
	 */
	public void setWorkDirectoryMenuItem(JMenuItem workDirectoryMenuItem) {
		this.workDirectoryMenuItem = workDirectoryMenuItem;
	}
}