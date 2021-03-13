package com.cdsc.eje.jdk;

import java.io.File;
import java.io.IOException;

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

public class JVM extends JDKApplication {

	private static JVM jvm = null;

	private OutputStreamGetter outputStreamGetter;

	private ErrorStreamGetter errorStreamGetter;

	private boolean flag;

	private boolean errors;

	protected JVM() {

	}

	public static JVM getJVM() {
		if (jvm == null) {
			jvm = new JVM();
		}
		return jvm;
	}

	protected String[] formatCommandLine(File file, String args[]) {
		int length = args.length + 4;
		String cmd[] = new String[length];
		String classpath = getClasspath() + File.pathSeparator + getOuputPath(file);
		cmd[0] = /*System.getProperty("java.home")*/ EJE.options.getProperty(EJE_JDK_PATH)+ "/bin/java";
		cmd[1] = "-classpath";
		cmd[2] = classpath;
		cmd[3] = FileValidator.trunkSuffix(file.getName());
		for (int i = 4; i < length; ++i) {
			cmd[i] = args[i - 4];
			System.out.println(cmd[i]);
		}
		return cmd;
	}

	protected String[] formatCommandLine(File file) {
		String classpath = getClasspath() + File.pathSeparator + getOuputPath(file);
		String cmd[] = { EJE.options.getProperty(EJE_JDK_PATH) + "/bin/java", "-classpath", classpath,
				EJE.options.getProperty("eje.java.assertions").equals("true") ? "-ea" : "-da",
						FileValidator.trunkSuffix(file.getName()) };
		return cmd;
	}

	@Override
	public void execute(File javaFile) {
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
		File classFile = null;
		try {
			classFile = FileValidator.getExecutableClass(javaFile);
		} catch (Exception exc) {
			classFile = javaFile;
		}
		try {
			String commandLine[] = this.formatCommandLine(classFile);
			execute(javaFile, classFile, commandLine);
		} catch (Exception exc) {
			this.addOutputLine(BugReporter.getMessage(exc.toString(), "JVM", "execute()"),
					errorStreamGetter);
		}
	}

	public void execute(File javaFile, String args[]) {
		if (isProcessing()) {
			return;
		}
		super.resetMessageArea();
		File classFile = null;
		try {
			classFile = FileValidator.getExecutableClass(javaFile);
		} catch (Exception exc) {
			classFile = javaFile;
		}
		try {
			String commandLine[] = this.formatCommandLine(classFile, args);
			execute(javaFile, classFile, commandLine);
		} catch (Exception exc) {
			this.addOutputLine(BugReporter.getMessage(exc.toString(), "JVM", "execute(args)"),
					errorStreamGetter);
		}
	}

	private void execute(File javaFile, File classFile, String[] commandLine) throws IOException {
		for (int i = 0; i < commandLine.length; ++i)
			System.out.print(commandLine[i] + " ");
		setFile(classFile);
		Process execution = Runtime.getRuntime().exec(commandLine, null, javaFile.getParentFile());
		processes.addElement(execution);
		outputStreamGetter = new OutputStreamGetter(execution.getInputStream(), this);
		errorStreamGetter = new ErrorStreamGetter(execution.getErrorStream(), this);
		outputStreamGetter.start();
		errorStreamGetter.start();
		EJEStatusBar.getStatusBar().changeColor(EJE.resources.getString("build.execute.status"));
	}

	@Override
	public synchronized void stopProcessing() {
		super.stopProcessing();
		outputStreamGetter.setStreamInterrupted();
		errorStreamGetter.setStreamInterrupted();
	}

	public void processInput(String input) {
		if (isProcessing())
			try {
				((Process) processes.lastElement()).getOutputStream().write(input.getBytes());
				((Process) processes.lastElement()).getOutputStream().flush();
			} catch (Exception exc) {
				exc.printStackTrace();
			}
	}

	@Override
	public synchronized void setNoErrorMessage(String text) {
		try {
			notify();
		} catch (Exception exc) {
			exc.printStackTrace();
		}
		flag = true;
		errors = false;
	}

	@Override
	public synchronized void setErrorMessage(String text) {
		try {
			notify();
		} catch (Exception exc) {
			exc.printStackTrace();
		}
		flag = true;
		errors = true;
	}

	@Override
	public synchronized void setOutputMessage(String text) {
		if (!flag)
			try {
				wait();
			} catch (Exception exc) {
				exc.printStackTrace();
			}
		if (errors) {
			text += EJE.resources.getString("stream.errors");
			notifyGuiForErrors(text);
		}
		flag = false;
		errors = false;
		processes.removeAllElements();
		EJEStatusBar.getStatusBar().changeColor("");
	}

	public String getVersion() {
		String versionSubstring = null;
		try {
			String version = EJE.options.getProperty("eje.java.version");
			versionSubstring = version.substring(0, 3);
		} catch (StringIndexOutOfBoundsException e) {
			return "1.4";
		}
		return versionSubstring;
	}

	@Override
	public String getAction() {
		return EJE.options.getProperty("status.running");
	}

}