package com.cdsc.eje.jdk;

import java.io.File;
import java.util.Enumeration;
import java.util.Vector;

import com.cdsc.eje.gui.EJE;
import com.cdsc.eje.gui.EJEStatusBar;
import com.cdsc.eje.jdk.utilities.ErrorStreamGetter;
import com.cdsc.eje.jdk.utilities.OutputStreamGetter;
import com.cdsc.eje.jdk.utilities.StreamGetter;

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

public abstract class JDKApplication {

	private static final String PROJECT_CLASS_PATH = "project.classpath";

	private static final String PROJECT_OUTPUT_PATH = "project.output.path";

	private static final String PROJECT_JAVADOC_PATH = "project.docs.path";

	protected static final String EJE_JDK_PATH = "eje.jdk.path";

	private File file;

	private String output;

	protected StringBuffer exitProcessMessage;

	protected static Vector processes;

	public JDKApplication() {
		processes = new Vector(2, 1);
		setExitProcessMessage(new StringBuffer(""));// da rivalutare
	}

	public void setFile(File file) {
		this.file = file;
	}

	public File getFile() {
		return file;
	}

	public void resetMessageArea() {
		EJE.getEJE().resetMessageArea();
	}

	public synchronized void setOutput(String output) {
		this.output = output;
	}

	public String getOutput() {
		return output;
	}

	public synchronized void setExitProcessMessage(StringBuffer exitProcessMessage) {
		this.exitProcessMessage = exitProcessMessage;
	}

	public synchronized String getExitProcessMessage() {
		return exitProcessMessage.toString();
	}

	public synchronized void addOutputLine(String line, StreamGetter streamGetter) {
		try {
			if (streamGetter instanceof OutputStreamGetter) {
				setOutput(line );
				this.notifyGui();
			} else if (streamGetter instanceof ErrorStreamGetter) {
				if (line.indexOf("java.lang.NoSuchMethodError: main") != -1) {
					EJE.getEJE().showSetAsMainDialogWarning();
				}
				exitProcessMessage.append(line);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public synchronized void notifyGui() {
		EJE.getEJE().update();
	}

	public synchronized void notifyGuiForErrors(String text) {
		EJE.getEJE().update(text);
	}

	public boolean isProcessing() {
		return (processes.size() > 0);
	}

	public synchronized boolean isBusy() {
		return false;
	}

	public synchronized void stopProcessing() {
		boolean flag = false;
		Enumeration processesEnumeration = processes.elements();
		while (processesEnumeration.hasMoreElements()) {
			Process p = (Process) processesEnumeration.nextElement();
			p.destroy();
			flag = true;
		}
		if (!flag) {
			EJE.getEJE().appendText(EJE.resources.getString("stream.no_process_to_interrupt"));
			return;
		}
		processes.removeAllElements();
		EJE.getEJE().appendText(EJE.resources.getString("stream.process_interrupted"));
		EJEStatusBar.getStatusBar().changeColor("");
	}

	public boolean containsSpace(String str) {
		for (int i = 0; i < str.length(); i++)
			if (str.charAt(i) == ' ')
				return true;
		return false;
	}

	protected String getOuputPath(File file) {
		return getPath(file, PROJECT_OUTPUT_PATH);
	}

	protected String getClasspath() {
		return getPath(file, PROJECT_CLASS_PATH);
	}

	protected String getJavadocOutputPath(File file) {
		return getPath(file, PROJECT_JAVADOC_PATH);
	}

	private String getPath(File file, String projectPath) {
		String path = EJE.options.getProperty(projectPath);
		if (path == null || path.equals("") || path.equals(".")) {
			return file.getParent();
		}
		return path;
	}

	public abstract void execute(File file);

	public abstract void setNoErrorMessage(String text);

	public abstract void setErrorMessage(String text);

	public abstract void setOutputMessage(String text);

	public abstract String getAction();
}