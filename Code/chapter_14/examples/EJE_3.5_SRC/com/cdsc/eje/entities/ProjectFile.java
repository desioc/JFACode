package com.cdsc.eje.entities;

import java.io.File;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.Vector;

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

public class ProjectFile extends CompilableFile {
	private Vector compilableVector = new java.util.Vector();

	public ProjectFile(File directory, String name) {
		super(directory, name);
	}

	public ProjectFile(String path, String name) {
		super(path, name);
	}

	public ProjectFile(String name) {
		super(name);
	}

	public ProjectFile getComposite() {
		return this;
	}

	public void add(CompilableFile compilableFile) {
		compilableVector.addElement(compilableFile);
	}

	public void remove(CompilableFile compilableFile) {
		compilableVector.removeElement(compilableFile);
	}

	public Enumeration compilables() {
		return compilableVector.elements();
	}

	public String getAbsolutePath() {
		StringBuffer absolutePath = new StringBuffer();
		for (Iterator iterator = compilableVector.iterator(); iterator.hasNext();) {
			File file = (File) iterator.next();
			absolutePath.append(file.getAbsolutePath() + (iterator.hasNext() ? "*" : ""));
		}
		return absolutePath.toString();
	}

	public String getParent() {
		StringBuffer parent = new StringBuffer();
		Set parentSet = new HashSet();
		for (Iterator iterator = compilableVector.iterator(); iterator.hasNext();) {
			File file = (File) iterator.next();
			parentSet.add(file.getParent());
		}
		for (Iterator iter = parentSet.iterator(); iter.hasNext();) {
			String element = (String) iter.next() + (iter.hasNext() ? File.pathSeparator : "");
			parent.append(element);
		}
		System.out.println("parent.toString()" + parent.toString());
		return parent.toString();
	}
}