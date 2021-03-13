package com.cdsc.eje.gui.options;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;

import com.cdsc.eje.gui.EJE;

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

public class EJEOptionsPanel extends EJEActivePanel {

	private final String[] languageValues = { "en", "it", "es", "de" };

	private JComboBox languageCombo;

	private final String[] styleValues;

	private final UIManager.LookAndFeelInfo[] lookAndFeelInfo = UIManager
			.getInstalledLookAndFeels();

	private JComboBox styleCombo;

	private JCheckBox lineNumbersCheckBox;

	private JPanel labelPanel;

	private JPanel centerPanel;

	private JPanel lineNumbersPanel;

	private JPanel stylePanel;

	private JPanel languagePanel;

	public EJEOptionsPanel() {
		languageCombo = new JComboBox(languageValues);
		styleValues = new String[lookAndFeelInfo.length];
		for (int i = 0; i < lookAndFeelInfo.length; i++) {
			styleValues[i] = lookAndFeelInfo[i].getName();
		}
		styleCombo = new JComboBox(styleValues);
		lineNumbersCheckBox = new JCheckBox(EJE.resources.getString("options.lineNumbers"));
		labelPanel = new JPanel();
		centerPanel = new JPanel();
		lineNumbersPanel = new JPanel();
		stylePanel = new JPanel();
		languagePanel = new JPanel();
		setup();
		addDetails();
	}

	private void addDetails() {
		reload();
	}

	@Override
	public void reload() {
		UIManager.LookAndFeelInfo[] info = getLookAndFeelInfo();
		for (int i = 0; i < info.length; i++) {
			if (info[i].getClassName().equals(EJE.options.getProperty("eje.style"))) {
				styleCombo.setSelectedItem(info[i].getName());
				break;
			}
		}
		languageCombo.setSelectedItem(EJE.options.getProperty("eje.lang"));
		lineNumbersCheckBox.setSelected(Boolean.parseBoolean(EJE.options.getProperty("eje.line.numbers")));
	}

	private void setup() {
		setLayouts();
		labelPanel.add(new JLabel(EJE.resources.getString("options.label")));
		stylePanel.add(new JLabel(EJE.resources.getString("options.style")));
		languagePanel.add(new JLabel(EJE.resources.getString("options.language")));
		stylePanel.add(styleCombo);
		languagePanel.add(languageCombo);
		lineNumbersPanel.add(lineNumbersCheckBox);
		centerPanel.add(stylePanel, BorderLayout.EAST);
		centerPanel.add(lineNumbersPanel, BorderLayout.WEST);
		this.add(labelPanel);
		this.add(languagePanel);
		this.add(centerPanel);
	}

	private void setLayouts() {
		setLayout(new GridLayout(3, 1));
		labelPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
		centerPanel.setLayout(new BorderLayout());
		languagePanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
		stylePanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
	}

	public UIManager.LookAndFeelInfo[] getLookAndFeelInfo() {
		return lookAndFeelInfo;
	}

	@Override
	public void store() {
		UIManager.LookAndFeelInfo[] info = getLookAndFeelInfo();
		for (int i = 0; i < info.length; i++) {
			if (info[i].getName().equals(styleCombo.getSelectedItem())) {
				EJE.options.setProperty("eje.style", info[i].getClassName());
				break;
			}
		}
		EJE.options.setProperty("eje.lang", languageCombo.getSelectedItem().toString());
		EJE.options.setProperty("eje.line.numbers", lineNumbersCheckBox.isSelected()+"");
		super.store();
	}

	/**
	 * Getter method for centerPanel property.
	 *
	 * @return the centerPanel.
	 */
	public JPanel getCenterPanel() {
		return centerPanel;
	}

	/**
	 * Setter method for centerPanel property.
	 *
	 * @param centerPanel the centerPanel to set.
	 */
	public void setCenterPanel(JPanel centerPanel) {
		this.centerPanel = centerPanel;
	}

	/**
	 * Getter method for lineNumbersPanel property.
	 *
	 * @return the lineNumbersPanel.
	 */
	public JPanel getLineNumbersPanel() {
		return lineNumbersPanel;
	}

	/**
	 * Setter method for lineNumbersPanel property.
	 *
	 * @param lineNumbersPanel the lineNumbersPanel to set.
	 */
	public void setLineNumbersPanel(JPanel lineNumbersPanel) {
		this.lineNumbersPanel = lineNumbersPanel;
	}
}