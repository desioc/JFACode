package com.cdsc.eje.gui;

import java.io.File;

import javax.swing.tree.DefaultMutableTreeNode;

import com.cdsc.eje.gui.utilities.JavaFilter;

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

public class EJEMutableTreeNode extends DefaultMutableTreeNode {
	File fileNode;

	JavaFilter javaFilter;

	public EJEMutableTreeNode() {
		super();
	}

	public EJEMutableTreeNode(Object fileNode) {
		super(fileNode);
		this.fileNode = (File) fileNode;
	}

	public synchronized void createNodes() {
		try {
			if (!fileNode.isDirectory())
				return;
			this.removeAllChildren();
			File[] directoryList = fileNode.listFiles();
			directoryList = sort(directoryList);

			for (int i = 0; i < directoryList.length; i++)
				if (directoryList[i].isDirectory() && !directoryList[i].isHidden())
					add(new EJEMutableTreeNode(directoryList[i]));

			File[] fileList = fileNode.listFiles(com.cdsc.eje.utilities.JavaFilter.getJavaFilter());
			fileList = sort(fileList);

			for (int i = 0; i < fileList.length; i++)
				if (!fileList[i].isDirectory())
					add(new EJEMutableTreeNode(fileList[i]));
		} catch (Exception exc) {
			exc.printStackTrace();
		}
	}

	public static File[] sort(File[] fileList) {
		for (int i = 0; i < fileList.length; i++) {
			for (int j = i; j < fileList.length; j++) {
				if (fileList[j].getName().compareToIgnoreCase(fileList[i].getName()) < 0) {
					File tmp = fileList[j];
					fileList[j] = fileList[i];
					fileList[i] = tmp;
				}
			}
		}
		return fileList;
	}

	@Override
	public boolean getAllowsChildren() {
		File fileNode = (File) getUserObject();
		return fileNode.isDirectory();
	}

	@Override
	public boolean isLeaf() {
		return !getAllowsChildren();
	}

	public File getFile() {
		return fileNode;
	}

	public String getPathString() {
		File fileNode = (File) getUserObject();
		return fileNode.getPath();
	}

	/**
	 * This is an override.
	 *
	 * @see java.lang.Object#equals(java.lang.Object)
	 *
	 * @param obj
	 * @return
	 */
	@Override
	public boolean equals(Object obj) {
		return this.toString().equals(obj.toString());
	}

	@Override
	public String toString() {
		File fileNode = (File) getUserObject();
		String name = fileNode.getName();
		if (name.length() > 0)
			return name;
		else
			return fileNode.getPath();
	}

}