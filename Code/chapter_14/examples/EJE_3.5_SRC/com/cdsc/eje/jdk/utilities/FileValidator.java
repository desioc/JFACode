package com.cdsc.eje.jdk.utilities;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import com.cdsc.eje.entities.ClassFile;
import com.cdsc.eje.entities.ProjectFile;
import com.cdsc.eje.gui.EJE;
import com.cdsc.eje.jdk.exceptions.NotCompilableFileException;
import com.cdsc.eje.jdk.exceptions.NotExecutableFileException;

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

public class FileValidator {
	public static ClassFile getExecutableClass(File file) throws FileNotFoundException,
			NotExecutableFileException, ClassNotFoundException {
		String fileName = getClassFileName(file.getName());
		if (!(new File(file.getParent(), fileName).exists()))
			throw new FileNotFoundException(fileName);
		return new ClassFile(file.getParent(), fileName);
	}

	public static boolean isClassFile(String fileName) {
		boolean flag = false;
		if (fileName.endsWith(".class")) {
			flag = true;
		}
		return flag;
	}

	public static boolean isJarFile(String fileName) {
		boolean flag = false;
		if (fileName.endsWith(".jar")) {
			flag = true;
		}
		return flag;
	}

	public static boolean isCompilableFile(File file) throws FileNotFoundException,
			NotCompilableFileException {
		if (file instanceof ProjectFile)
			return true;
		if (!(file.exists()))
			throw new FileNotFoundException(file.getName());
		if (!isJavaFile(file.getName()))
			throw new NotCompilableFileException(file.getName());
		return true;
	}

	public static boolean isJavaFile(String fileName) {
		boolean flag = false;
		if (fileName.endsWith(".java")) {
			flag = true;
		}
		return flag;
	}

	public static String trunkSuffix(String fileName) {
		try {
			return fileName.substring(0, fileName.lastIndexOf('.'));
		} catch (RuntimeException e) {
			return fileName;
		}
	}

	private static String getClassFileName(String javaFileName) throws FileNotFoundException {
		String classFileName = trunkSuffix(javaFileName) + ".class";
		return classFileName;
	}

	public static boolean isExecutableFile(String className) {
		return containsMain(className);
	}

	private static boolean containsMain(String className) {
		try {
			Class<?> objectClass = Class.forName(className, false, new java.net.URLClassLoader(EJE
					.getEJE().getClassPathForReflection()));
			String[] args = new String[1];
			Class argsArray = args.getClass();
			Class[] parameters = { argsArray };
			Method main = objectClass.getMethod("main", parameters);
			int mainModifiers = main.getModifiers();
			if (Modifier.isStatic(mainModifiers)) {
				return true;
			}
		} catch (UnsupportedClassVersionError e) {
			e.printStackTrace();
			return true;
		} catch (ClassNotFoundException e) {
			System.out.println(className);
			return false;
		} catch (SecurityException e) {
			e.printStackTrace();
			return true;
		} catch (NoSuchMethodException e) {
			return false;
		}
		return true;
	}
}