package com.cdsc.eje.jdk;

import java.io.File;

import com.cdsc.eje.gui.EJE;
import com.cdsc.eje.gui.EJEStatusBar;
import com.cdsc.eje.gui.options.EJEOptionsDialog;
import com.cdsc.eje.jdk.utilities.ErrorStreamGetter;
import com.cdsc.eje.jdk.utilities.FileValidator;
import com.cdsc.eje.jdk.utilities.OutputStreamGetter;
import com.cdsc.eje.utilities.BugReporter;

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

public class Javadoc extends JDKApplication {

	private static Javadoc javadoc = null;

	private OutputStreamGetter outputStreamGetter;

	private ErrorStreamGetter errorStreamGetter;

	protected Javadoc() {

	}

	public static Javadoc getJavadoc() {
		if (javadoc == null) {
			javadoc = new com.cdsc.eje.jdk.Javadoc();
		}
		return javadoc;
	}

	private String[] formatCommandLine(File file) {
		String sourcepath = getJavadocOutputPath(file);
		String absolutepath = file.getAbsolutePath();
		String cmd[] = { /*System.getProperty("java.home")*/ EJE.options.getProperty(EJE_JDK_PATH) + "/bin/javadoc", "-d",
				sourcepath + "/docs", "-sourcepath", sourcepath, absolutepath };
		return cmd;
	}

	public void generateDocs(File file) {
		if (isProcessing()) {
			return;
		}
		super.resetMessageArea();
		if (!EJE.getEJE().isJDKValid()) {
			EJEOptionsDialog.getInstance().getJavaOptionsPanel().getChangeJdkPathAction()
					.actionPerformed(null);
			EJEOptionsDialog.getInstance().getJavaOptionsPanel().store();
			EJEOptionsDialog.getInstance().getJavaOptionsPanel().reload();
		}
		try {
			FileValidator.isCompilableFile(file);
		} catch (Exception exc) {
			exc.printStackTrace();
		}
		try {
			setFile(file);
			String[] commandLine = this.formatCommandLine(file);
			/*
			 * for (int i = 0; i < commandLine.length; ++i)
			 * System.out.print(commandLine[i]+" ");
			 */
			Process docsGeneration = Runtime.getRuntime().exec(commandLine, null,
					file.getParentFile());
			processes.addElement(docsGeneration);
			outputStreamGetter = new OutputStreamGetter(docsGeneration.getInputStream(), this);
			/*
			 * errorStreamGetter = new
			 * ErrorStreamGetter(docsGeneration.getErrorStream(), this);
			 */
			outputStreamGetter.start();
			EJEStatusBar.getStatusBar()
					.changeColor(EJE.resources.getString("build.javadoc.status"));
			/* errorStreamGetter.start(); */
		} catch (Exception exc) {
			this.addOutputLine(BugReporter.getMessage(exc.toString(), "Javadoc", "generateDocs()"),
					errorStreamGetter);
		}
	}

	public synchronized void stopProcessing() {
		super.stopProcessing();
		outputStreamGetter.setStreamInterrupted();
		/* errorStreamGetter.setStreamInterrupted(); */
	}

	public synchronized void execute(File file) {
		this.generateDocs(file);
	}

	public synchronized void setNoErrorMessage(String text) {
		setOutput("File: " + getFile() + ", " + EJE.resources.getString("stream.docs") + text);
		notifyGui();
		processes.removeAllElements();
		EJEStatusBar.getStatusBar().changeColor("");
	}

	public synchronized void setErrorMessage(String text) {
		setOutputMessage(text);
	}

	public synchronized void setOutputMessage(String text) {
		notifyGuiForErrors(text);
		processes.removeAllElements();
		EJEStatusBar.getStatusBar().changeColor("");
	}

	public String getAction() {
		return EJE.options.getProperty("status.documenting");
	}
}