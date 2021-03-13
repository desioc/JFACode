package com.cdsc.eje.jdk;

import java.io.File;
import java.util.ArrayList;
import java.util.StringTokenizer;

import com.cdsc.eje.gui.EJE;
import com.cdsc.eje.gui.EJEStatusBar;
import com.cdsc.eje.gui.options.EJEOptionsDialog;
import com.cdsc.eje.jdk.utilities.ErrorStreamGetter;
import com.cdsc.eje.jdk.utilities.FileValidator;
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

public class Compiler extends JDKApplication {

	private static Compiler compiler = null;

	private ErrorStreamGetter errorStreamGetter;

	protected Compiler() {

	}

	public static Compiler getCompiler() {
		if (compiler == null) {
			compiler = new Compiler();
		}
		return compiler;
	}

	private String[] formatCommandLine(File file) {
		ArrayList<String> absolutePathList = new ArrayList<String>();
		String javaHome = EJE.options.getProperty(EJE_JDK_PATH);// System.getProperty("java.home");
		String sourcepath = getOuputPath(file);
		String classpath = getClasspath() + File.pathSeparator
				+ getOuputPath(file);
		String source = EJE.options.getProperty("eje.javac.version");
		String target = EJE.options.getProperty("eje.javac.target");
		String absolutepath = file.getAbsolutePath();
		StringTokenizer st = new StringTokenizer(absolutepath, "*");
		absolutePathList.add(javaHome + "/bin/javac");
		absolutePathList.add("-d");
		absolutePathList.add(sourcepath);
		// directory
		// absolutePathList.add(/*target.equals("1.5") ? "-Xlint:unchecked" :
		// */"-deprecation");
		absolutePathList.add("-Xlint:all");
		absolutePathList.add("-source");
		absolutePathList.add(source);
		absolutePathList.add("-target");
		absolutePathList.add(target);
		absolutePathList.add("-sourcepath");
		absolutePathList.add(sourcepath);
		absolutePathList.add("-classpath");
		absolutePathList.add(classpath);

		while (st.hasMoreElements()) {
			absolutePathList.add(st.nextToken());
		}
		/*
		 * String cmd[] = { javaHome + "/bin/javac", "-d", sourcepath,
		 * target.equals("1.5") ? "-Xlint" : "-deprecation", "-source", source,
		 * "-target", target, "-sourcepath", sourcepath, absolutepath };
		 */
		String[] cmd = new String[absolutePathList.size()];
		for (int i = 0; i < cmd.length; i++) {
			cmd[i] = absolutePathList.get(i);
		}
		return cmd;
	}

	// TODO invece di un return si deve mettere la prima parte di questo metodo
	// nel
	// rispettivo della superclasse e gestire tutto con le eccezioni
	public void compile(File file) {
		if (isProcessing()) {
			return;
		}
		super.resetMessageArea();
		if (!(EJE.getEJE().isJDKValid())) {
			EJEOptionsDialog.getInstance().getJavaOptionsPanel()
					.getChangeJdkPathAction().actionPerformed(null);
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
			for (int i = 0; i < commandLine.length; ++i)
				System.out.print(commandLine[i] + " " /* + i + "*" */);
			Process compilation = Runtime.getRuntime().exec(commandLine, null,
					null);
			processes.addElement(compilation);
			errorStreamGetter = new ErrorStreamGetter(
					compilation.getErrorStream(), this);
			errorStreamGetter.start();
			EJEStatusBar.getStatusBar().changeColor(
					EJE.resources.getString("build.compile.status"));
		} catch (Exception exc) {
			this.addOutputLine(BugReporter.getMessage(exc.toString(),
					"Compiler", "compile()"), errorStreamGetter);
		}
	}

	@Override
	public synchronized void stopProcessing() {
		super.stopProcessing();
		errorStreamGetter.setStreamInterrupted();
	}

	@Override
	public synchronized void execute(File file) {
		this.compile(file);
	}

	@Override
	public synchronized void setNoErrorMessage(String text) {
		File file = getFile();
		setOutput(file + " " + EJE.resources.getString("stream.compiled")
				+ text + "\n"
				+ EJE.resources.getString("stream.output.directory") + " "
				+ getOuputPath(file));
		notifyGui();
		processes.removeAllElements();
		EJEStatusBar.getStatusBar().changeColor("");
	}

	@Override
	public synchronized void setErrorMessage(String text) {
		setOutputMessage(text);
	}

	@Override
	public synchronized void setOutputMessage(String text) {
		String output = null;
		if (errorStreamGetter!= null){
			output = errorStreamGetter.getJdkApplication().getExitProcessMessage();
		}
		// NON FUNZIONA è SEMPRE ""
		if (output != null && output.length() > 0 && output.contains("error")) {
			notifyGuiForErrors(text);
		} else {
			notifyGuiForErrors("");
		}
		processes.removeAllElements();
		EJEStatusBar.getStatusBar().changeColor("");
		errorStreamGetter.getJdkApplication().setOutput(null);
	}

	@Override
	public String getAction() {
		return EJE.options.getProperty("status.compiling");
	}
}