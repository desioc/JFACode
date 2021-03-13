package com.cdsc.eje.gui;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Hashtable;
import java.util.Vector;

/*
 *   EJE - version 3.5 - "Everyone's Java Editor" 
 *
 *   Copyright (C) 2003-2018  Claudio De Sio Cesari
 *
 *   Require JDK 1.8
 *
 *   This program is free software; you can redistribute it and/or modify
 *   it under the terms of the GNU General Public License as published by
 *   the Free Software Foundation; either version 2 of the License, or
 *   (at your option) any later version.
 *
 *   This program is distributed in the hope that it will be useful,
 *   but WITHOUT ANY WARRANTY; without even the implied warranty of
 *   MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *   GNU General Public License for more details.
 *
 *   You should have received a copy of the GNU General Public License
 *   along with this program; if not, write to the Free Software
 *   Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA
 *
 *
 *   Info, Questions, Suggestions & Bugs Report to eje@claudiodesio.com
 *
 */
/** @deprecated */
public class EJEMap extends Hashtable {
	private Vector packages = new Vector(1, 1);

	public EJEMap() throws Exception {
		importPackage("java.lang");
	}

	public Object get(String alias) {
		Object o = super.get(alias);
		if (o == null) {
			o = alias;
		}
		return o;
	}

	public short importPackage(String packageName) throws FileNotFoundException, IOException {
		if (packages.contains(packageName))
			return 0;
		BufferedReader br = new BufferedReader(new FileReader(new File("resources/" + packageName)));
		String className = null;
		while ((className = br.readLine()) != null) {
			this.put(className, packageName + "." + className);
			// System.out.println(this.get(className));
		}
		packages.addElement(packageName);
		return 1;
	}

	public short importClass(String packageName, String className) throws FileNotFoundException,
			IOException {
		if (this.containsValue(packageName + "." + className))
			return 0;
		BufferedReader br = new BufferedReader(new FileReader(new File("resources/" + packageName)));
		String correctClassName = null;
		while ((correctClassName = br.readLine()) != null) {
			if (className.equals(correctClassName)) {
				this.put(className, packageName + "." + className);
				break;
			}
			// System.out.println(this.get(className));
		}
		return 1;
	}
}