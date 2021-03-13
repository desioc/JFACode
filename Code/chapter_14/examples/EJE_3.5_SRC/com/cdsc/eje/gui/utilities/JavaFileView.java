package com.cdsc.eje.gui.utilities;

import java.io.File;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.filechooser.FileView;

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

public class JavaFileView extends FileView {
	private ImageIcon javaIcon;

	private ImageIcon dirIcon;

	private static JavaFileView instance;

	private JavaFileView() {
		javaIcon = new ImageIcon("resources/images/javaicon.png");
		dirIcon = new ImageIcon("resources/images/folder.png");
	}

	public static JavaFileView getInstance() {
		if (instance == null) {
			instance = new JavaFileView();
		}
		return instance;
	}

	public String getName(File f) {
		return null;
	}

	public String getDescription(File f) {
		return null;
	}

	public Boolean isTraversable(File f) {
		return null;
	}

	public String getTypeDescription(File f) {
		String extension = getExtension(f);
		String type = null;
		System.out.println(extension);
		if (extension != null) {
			if (extension.equals("java")) {
				type = "Java File";
			}
		}
		return type;
	}

	public Icon getIcon(File f) {
		Icon icon = null;
		if (f.isDirectory()) {
			icon = dirIcon;
		} else {
			String extension = getExtension(f);
			if (extension != null) {
				if (extension.equals("java")) {
					icon = javaIcon;
				}
			}
		}
		return icon;
	}

	private String getExtension(File f) {
		String ext = null;
		String s = f.getName();
		int i = s.lastIndexOf('.');
		if (i > 0 && i < s.length() - 1) {
			ext = s.substring(i + 1).toLowerCase();
		}
		return ext;
	}
}