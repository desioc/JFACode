package com.cdsc.eje.jdk.utilities;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PipedReader;
import java.io.PipedWriter;

import com.cdsc.eje.gui.EJEStatusBar;
import com.cdsc.eje.jdk.JDKApplication;

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

public abstract class StreamGetter extends Thread {

	protected EJEStatusBar statusbar;

	protected JDKApplication jdkApplication;

	protected boolean processed;

	private boolean streamInterrupted;

	private BufferedWriter bufferedWriter;

	private BufferedReader bufferedPipedReader;

	private BufferedReader bufferedReader;

	public StreamGetter(InputStream in, JDKApplication jdkApplication) {
		this.jdkApplication = jdkApplication;
		statusbar = EJEStatusBar.getStatusBar();
		bufferedReader = new BufferedReader(new InputStreamReader(in)); // read from process
		PipedWriter pipedWriter = new PipedWriter();
		bufferedWriter = new BufferedWriter(pipedWriter);
		try {
			bufferedPipedReader = new BufferedReader(new PipedReader(pipedWriter)); // read
																					// from
																					// pipe
		} catch (Exception e) {
			e.printStackTrace();
		}
		setDaemon(true);
	}

	public void setStreamInterrupted() {
		streamInterrupted = true;
	}

	public boolean getStreamInterrupted() {
		return streamInterrupted;
	}

	@Override
	public void run() {
		try {
			//dataInputStream = new DataInputStream(bufferedInputStream);
			int read = -1;
			char b[]=new char[1];
			while ((read = bufferedReader.read(b,0,b.length)) != -1) {
			yield();
				if (streamInterrupted) {
					System.out.println("Stream interrupted!!");
					return;
				}
				processed = true;
				//char c[] = { (char) read };
				String line = new String(b);
				jdkApplication.addOutputLine(line, this);
			}
			specializedRun();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				bufferedReader.close();
				bufferedWriter.close();
				bufferedWriter = null;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		/*
		 * try { BufferedReader bufferedReader = new BufferedReader(new
		 * InputStreamReader( bufferedInputStream)); String line = null; while
		 * ((line = bufferedReader.readLine()) != null) { yield(); if
		 * (streamInterrupted) { System.out.println("Stream interrupted!!");
		 * closeStreams(bufferedReader, bufferedWriter); return; } processed =
		 * true; bufferedWriter.write(line); bufferedWriter.newLine();
		 * bufferedWriter.flush();
		 * jdkApplication.addOutputLine(bufferedPipedReader.readLine(), this); }
		 * specializedRun(); closeStreams(bufferedReader, bufferedWriter); }
		 * catch (Exception e) { e.printStackTrace(); }
		 */
	}

	public void closeStreams(BufferedReader bufferedReader, BufferedWriter bufferedWriter)
			throws Exception {
		bufferedReader.close();
		bufferedWriter.close();
	}

	public abstract void specializedRun();

	public JDKApplication getJdkApplication() {
		return jdkApplication;
	}

	public void setJdkApplication(JDKApplication jdkApplication) {
		this.jdkApplication = jdkApplication;
	}
}