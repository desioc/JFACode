package com.cdsc.eje.gui.utilities;

import javax.swing.tree.TreeModel;

import com.cdsc.eje.gui.EJE;
import com.cdsc.eje.gui.EJEMutableTreeNode;

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
public class EJEUtils {

	/**
	 * Checks if the specified parameter is a path not displayed in the EJE tree.
	 *
	 * @param selectedPath
	 * 			the path to check.
	 * @return
	 * 			true if the selected path is not displayed in the EJE tree, false otherwise.
	 */
	public static boolean isNotVisibleInEJETree(final String selectedPath){
		TreeModel model = EJE.getEJE().getEjeTree().getModel();
		Object root = model.getRoot();
		int childrenCount = model.getChildCount(root);
		for (int i = 0; i < childrenCount; i++) {
			EJEMutableTreeNode child = (EJEMutableTreeNode)model.getChild(root, i);
			if (child.getPathString().equals(selectedPath)) {
				return false;
			}
		}
		return true;
	}

	/**
	 * Checks if the specified parameter is a path of a configured work directory.
	 *
	 * @param selectedPath
	 * 			the path to check.
	 * @return
	 * 			true if the selected path is a work directory, false otherwise.
	 */
	public static boolean isWorkDirectory(final String selectedPath){
		return System.getProperty("user.work_dir").contains(";"+selectedPath+";");
	}

	/**
	 * The isEmpty method returns true if the {@code string} parameter is null
	 * or have a length equals to zero, false otherwise.
	 *
	 * @param string
	 *            the string to test.
	 * @return true if the {@code string} parameter is null or have a length
	 *         equals to zero, false otherwise.
	 */
	public static boolean isEmpty(String string) {
		return (string == null || string.trim().length() == 0);
	}

	/**
	 * The isNotEmpty method returns true if the {@code string} parameter is not
	 * null and have a length greater than zero, false otherwise.
	 *
	 * @param string
	 *            the string to test.
	 * @return true if the {@code string} parameter is not null and have a
	 *         length greater than zero, false otherwise.
	 */
	public static boolean isNotEmpty(String string) {
		return (string != null && string.trim().length() > 0);
	}
}
