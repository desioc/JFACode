package com.cdsc.eje.gui.utilities;

import java.io.File;

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

public class JavaFilter extends EJEFilter {
	private JavaFilter() {
	}

	private static JavaFilter javaFilter = null;

	public static JavaFilter getJavaFilter() {
		if (javaFilter == null)
			javaFilter = new JavaFilter();
		return javaFilter;
	}

	public boolean accept(File file) {
		if (file.isDirectory()) {
			return true;
		}
		String extension = getExtension(file);
		if (extension != null && extension.equals("java"))
			return true;
		return false;
	}

	public String getDescription() {
		return "Java files (*.java)";
	}
}