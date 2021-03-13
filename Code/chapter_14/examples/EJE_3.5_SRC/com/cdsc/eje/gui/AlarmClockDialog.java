package com.cdsc.eje.gui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimerTask;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

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

public class AlarmClockDialog extends JDialog implements ActionListener {
	private Object[] hoursModel;

	private Object[] minsModel;

	private JFrame frame;

	private JPanel combosPanel;

	private JPanel buttonsPanel;

	private JComboBox hoursCombo;

	private JComboBox minsCombo;

	private JButton submitButton;

	private JButton cancelButton;

	private JTextField messageField;

	private Container contentPane;

	private static AlarmClockDialog alarmClockDialog = null;

	private AlarmClockDialog(EJE frame) {
		super(frame, EJE.resources.getString("alarm_dialog.title"), false);
		this.frame = frame;
		combosPanel = new JPanel(new FlowLayout());
		buttonsPanel = new JPanel(new FlowLayout());
		hoursModel = new String[24];
		minsModel = new String[60];
		initModel(hoursModel);
		initModel(minsModel);
		hoursCombo = new JComboBox(hoursModel);
		minsCombo = new JComboBox(minsModel);
		submitButton = new JButton(EJE.resources.getString("alarm_dialog.submit"));
		cancelButton = new JButton(EJE.resources.getString("alarm_dialog.cancel"));
		messageField = new JTextField();
		contentPane = this.getContentPane();
		this.initialize();
	}

	public static AlarmClockDialog getAlarmClockDialog(EJE frame) {
		if (alarmClockDialog == null)
			alarmClockDialog = new AlarmClockDialog(frame);
		alarmClockDialog.messageField.setText(EJE.resources.getString("alarm_dialog.msg"));
		return alarmClockDialog;
	}

	public void initialize() {
		messageField.setBorder(BorderFactory.createLoweredBevelBorder());
		this.setup();
	}

	public void setup() {
		contentPane.add(combosPanel, BorderLayout.NORTH);
		contentPane.add(messageField, BorderLayout.CENTER);
		contentPane.add(buttonsPanel, BorderLayout.SOUTH);
		combosPanel.add(new JLabel(EJE.resources.getString("alarm_dialog.hours")));
		combosPanel.add(hoursCombo);
		combosPanel.add(new JLabel(EJE.resources.getString("alarm_dialog.mins")));
		combosPanel.add(minsCombo);
		buttonsPanel.add(submitButton);
		buttonsPanel.add(cancelButton);
		this.registerComponents();
	}

	public void registerComponents() {
		submitButton.addKeyListener(keyListener);
		cancelButton.addKeyListener(keyListener);
		hoursCombo.addKeyListener(keyListener);
		minsCombo.addKeyListener(keyListener);
		messageField.addKeyListener(keyListener);
		submitButton.addActionListener(this);
		cancelButton.addActionListener(this);
	}

	private void initModel(Object model[]) {
		for (int i = 0; i < model.length; ++i) {
			String firstNumber = "";
			if (i < 10)
				firstNumber = "0";
			model[i] = firstNumber + i;
		}
	}

	KeyListener keyListener = new KeyAdapter() {
		public void keyPressed(KeyEvent e) {
			Object source = e.getSource();
			switch (e.getKeyCode()) {
			case KeyEvent.VK_ENTER:
				if (source != submitButton && source != messageField)
					break;
				submitTask();
			case KeyEvent.VK_ESCAPE:
				setVisible(false);
			}
		}
	};

	public void submitTask() {
		byte hoursValue = (byte) hoursCombo.getSelectedIndex();
		byte minsValue = (byte) minsCombo.getSelectedIndex();
		String time = "\n[" + EJE.resources.getString("alarm_dialog.hours") + ":" + hoursValue
				+ ", " + EJE.resources.getString("alarm_dialog.mins") + ":" + minsValue + "]";
		long milliseconds = getTime(hoursValue, minsValue);
		new java.util.Timer().schedule(new AlarmClockTimerTask(messageField.getText() + time,
				milliseconds), milliseconds);
		EJEStatusBar.getStatusBar().ejeClock.mouseListener.mousePressed(null);
	}

	private int getTime(byte hoursValue, byte minsValue) {
		int hoursMilliseconds = hoursValue * 1000 * 60 * 60;
		int minsMilliseconds = minsValue * 1000 * 60;
		int totalMilliseconds = hoursMilliseconds + minsMilliseconds;
		return totalMilliseconds;
	}

	public void setVisible(boolean flag) {
		if (flag) {
			messageField.requestFocus();
			messageField.selectAll();
			this.pack();
			this.setLocationRelativeTo(frame);
		}
		super.setVisible(flag);
	}

	public void actionPerformed(ActionEvent ev) {
		Object source = ev.getSource();
		if (source == submitButton)
			submitTask();
		setVisible(false);
	}

	public class AlarmClockTimerTask extends TimerTask {

		private JDialog dialog;

		private JOptionPane pane;

		private String message;

		private Date creationTime;

		private Date notifyTime;

		private long timeToNotify;

		public AlarmClockTimerTask(String message, long timeToNotify) {
			this.message = message;
			this.timeToNotify = timeToNotify;
			Object o[] = { EJE.resources.getString("alarm_notify_dialog.ok"),
					EJE.resources.getString("alarm_notify_dialog.again") };
			pane = new JOptionPane(message, JOptionPane.WARNING_MESSAGE, JOptionPane.YES_NO_OPTION,
					null, o);
			dialog = pane.createDialog(frame, EJE.resources.getString("alarm_notify_dialog.title"));
			creationTime = new Date();
			notifyTime = new Date(creationTime.getTime() + timeToNotify);
			EJEStatusBar status = EJEStatusBar.getStatusBar();
			status.addAlarmTask(this);
		}

		public synchronized void run() {
			Toolkit toolkit = Toolkit.getDefaultToolkit();
			toolkit.beep();
			dialog.show();
			Object selectedValue = pane.getValue();
			if (selectedValue == EJE.resources.getString("alarm_notify_dialog.again"))
				AlarmClockDialog.this.setVisible(true);
			EJEStatusBar status = EJEStatusBar.getStatusBar();
			status.removeAlarmTask(this);
		}

		public String toString() {
			DateFormat timeFormatter = DateFormat.getTimeInstance(DateFormat.SHORT,
					Locale.getDefault());
			return message + EJE.resources.getString("alarm_confirm_dialog.created_at")
					+ timeFormatter.format(creationTime)
					+ EJE.resources.getString("alarm_confirm_dialog.notify_at")
					+ timeFormatter.format(notifyTime);
		}
	}
}