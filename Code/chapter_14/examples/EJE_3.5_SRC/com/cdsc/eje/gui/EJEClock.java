package com.cdsc.eje.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Timer;
import java.util.TimerTask;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListModel;

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

public class EJEClock extends JPanel {
	public final static byte TIME = 0;

	public final static byte COUNTDOWN = 1;

	public final static byte COUNT = 2;

	private Vector alarmTasks;

	private byte displayType = TIME;

	private Timer session;

	private Timer sessionCountdown;

	private Timer sessionChrono;

	private Timer projectChrono;

	private JLabel timeLabel;

	private DateFormat timeFormatter;

	/** Creates a new instance of EJEClock */
	public EJEClock() {
		alarmTasks = new Vector();
		timeFormatter = DateFormat.getTimeInstance(DateFormat.SHORT, Locale.getDefault());
		timeLabel = new JLabel();
		session = new EJEClockTimer();
		timeLabel.addMouseListener(mouseListener);
		add(timeLabel);
	}

	public void addAlarmTask(AlarmClockDialog.AlarmClockTimerTask alarmTask) {
		alarmTasks.addElement(alarmTask);
		timeLabel.setIcon(new ImageIcon("resources/images/clock.png"));
	}

	public void removeAlarmTask(AlarmClockDialog.AlarmClockTimerTask alarmTask) {
		alarmTasks.removeElement(alarmTask);
		updateIcon();
	}

	public void updateIcon() {
		if (alarmTasks.isEmpty())
			timeLabel.setIcon(null);
	}

	public void setDisplay(byte displayType) {
		this.displayType = displayType;
	}

	private class EJEClockTimer extends Timer {

		public EJEClockTimer() {
			this.schedule(new EJEClockTimerTask(), 0);
			this.scheduleAtFixedRate(new EJEClockTimerTask(), getDelay() * 1000, 60000);
		}

		private int getDelay() {
			Calendar cal = Calendar.getInstance();
			return (60 - cal.get(Calendar.SECOND));
		}
	}

	private class EJEClockTimerTask extends TimerTask {
		public synchronized void run() {
			Date today = new Date();
			String dateOut = timeFormatter.format(today);
			timeLabel.setText(dateOut);
		}
	}

	protected MouseAdapter mouseListener = new MouseAdapter() {
		public void mousePressed(MouseEvent ev) {
			final int alarmTasksSize = alarmTasks.size();
			final Vector alarmTasks = EJEClock.this.alarmTasks;
			final EJE frame = EJE.getEJE();
			if (alarmTasksSize < 1)
				return;
			final Object[] options = {
					new JButton(EJE.resources.getString("alarm_confirm_dialog.ok")),
					new JButton(EJE.resources.getString("alarm_confirm_dialog.discard_selected")),
					new JButton(EJE.resources.getString("alarm_confirm_dialog.discard_all")) };
			final JList list = new JList(alarmTasks);
			final JScrollPane scroll = new JScrollPane(list);
			final JDialog dialog = new JDialog(frame,
					EJE.resources.getString("alarm_confirm_dialog.title"), true);
			ActionListener optionListener = new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Object source = e.getSource();
					if (source.equals(options[0])) {
						dialog.setVisible(false);
					} else if (source.equals(options[1])) {
						Object[] selected = list.getSelectedValues();
						EJEStatusBar status = EJEStatusBar.getStatusBar();
						for (int i = 0; i < selected.length; ++i) {
							AlarmClockDialog.AlarmClockTimerTask alarmTask = ((AlarmClockDialog.AlarmClockTimerTask) selected[i]);
							alarmTask.cancel();
							status.removeAlarmTask(alarmTask);
							alarmTasks.removeElement(alarmTask);
							list.updateUI();
						}
					} else if (source.equals(options[2])) {
						EJEStatusBar status = EJEStatusBar.getStatusBar();
						ListModel model = list.getModel();
						for (int i = 0; i < model.getSize(); ++i) {
							AlarmClockDialog.AlarmClockTimerTask alarmTask = ((AlarmClockDialog.AlarmClockTimerTask) model
									.getElementAt(i));
							alarmTask.cancel();
							status.removeAlarmTask(alarmTask);
						}
						alarmTasks.removeAllElements();
						list.updateUI();
					}
					dialog.pack();
					dialog.setLocationRelativeTo(frame);
				}
			};
			JPanel panel = new JPanel();
			for (int i = 0; i < options.length; ++i) {
				((JButton) options[i]).addActionListener(optionListener);
				panel.add((JButton) options[i]);
			}
			dialog.getContentPane().add(scroll, "Center");
			dialog.getContentPane().add(panel, "South");
			dialog.pack();
			dialog.setLocationRelativeTo(frame);
			dialog.setVisible(true);
		}
	};
}