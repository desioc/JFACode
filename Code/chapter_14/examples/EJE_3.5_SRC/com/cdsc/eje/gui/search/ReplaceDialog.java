package com.cdsc.eje.gui.search;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.cdsc.eje.gui.EJE;
import com.cdsc.eje.gui.EJEArea;

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

public class ReplaceDialog extends FindDialog {
	protected JButton replaceButton;

	protected JButton replaceAllButton;

	protected JPanel labelPanel;

	protected JPanel textPanel;

	protected JTextField replaceText;

	protected JLabel replaceLabel;

	public ReplaceDialog(EJE frame, EJEArea textArea, String mode) {
		super(frame, textArea, mode);
	}

	public void initialize() {
		replaceButton = new JButton(EJE.resources.getString("search_dialog.replace"));
		replaceAllButton = new JButton(EJE.resources.getString("search_dialog.replace_all"));
		replaceText = new JTextField(20);
		replaceLabel = new JLabel(EJE.resources.getString("search_dialog.replace_with"));
		labelPanel = new JPanel(new GridLayout(2, 1));
		textPanel = new JPanel(new GridLayout(2, 1));
		buttonPanel.setLayout(new GridLayout(4, 1));
		centerPanel.setLayout(new BorderLayout());
		optionsPanel.setLayout(new GridLayout(2, 1));
		this.setup();
		this.registerComponents();
	}

	public void setup() {
		labelPanel.add(findLabel);
		labelPanel.add(replaceLabel);
		textPanel.add(findText, BorderLayout.WEST);
		textPanel.add(replaceText, BorderLayout.CENTER);
		optionsPanel.add(matchCaseCheckBox, BorderLayout.SOUTH);
		optionsPanel.add(wholeWordsOnlyCheckBox, BorderLayout.SOUTH);
		centerPanel.add(labelPanel, BorderLayout.WEST);
		centerPanel.add(textPanel, BorderLayout.CENTER);
		centerPanel.add(optionsPanel, BorderLayout.SOUTH);
		buttonPanel.add(findNextButton);
		buttonPanel.add(replaceButton);
		buttonPanel.add(replaceAllButton);
		buttonPanel.add(cancelButton);
		this.getContentPane().add(centerPanel, BorderLayout.CENTER);
		this.getContentPane().add(buttonPanel, BorderLayout.EAST);
	}

	public void registerComponents() {
		super.registerComponents();
		replaceButton.addActionListener(this);
		replaceAllButton.addActionListener(this);
	}

	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		if (source == cancelButton)
			setVisible(false);
		else if (source == replaceButton)
			replace();
		else if (source == findNextButton)
			find();
		else if (source == replaceAllButton)
			replaceAll();
	}

	public void replace() {
		int selectionStart = textArea.getSelectionStart();
		int selectionEnd = textArea.getSelectionEnd();
		if (selectionEnd > selectionStart)
			textArea.replaceSelection(replaceText.getText());
		textArea.select(selectionStart, selectionStart + replaceText.getText().length());
		find();
	}

	public void replaceAll() {
		textArea.select(0, 0);
		do {
			replace();
		} while (position > 0);
	}
}