package com.cdsc.eje.jdk.utilities;

import java.io.InputStream;

import com.cdsc.eje.gui.EJE;
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

public class ErrorStreamGetter extends StreamGetter {
	public ErrorStreamGetter(InputStream in, JDKApplication jdkApplication) {
		super(in, jdkApplication);
		jdkApplication.setExitProcessMessage(new StringBuffer());
		// statusbar.changeColor(jdkApplication.getAction());
	}

	@Override
	public void specializedRun() {
		String exitProcessMessage = jdkApplication.getExitProcessMessage();
		if (!getStreamInterrupted())
			//if (!processed) {
			if ((exitProcessMessage == null || exitProcessMessage.length() == 0)) {
				jdkApplication.setNoErrorMessage(EJE.resources.getString("stream.end_noerrors"));
			} else if (exitProcessMessage.contains("error") || exitProcessMessage.contains("exception") || exitProcessMessage.contains("Exception")) {
					jdkApplication.setErrorMessage(EJE.resources.getString("stream.end_errors"));
			} else if(!exitProcessMessage.contains("error")){
				jdkApplication.setNoErrorMessage(exitProcessMessage + "\n"+ EJE.resources.getString("stream.end_noerrors"));
			}
	}

	@Override
	public String toString() {
		return super.toString() + " ErrorStreamGetter";
	}

}