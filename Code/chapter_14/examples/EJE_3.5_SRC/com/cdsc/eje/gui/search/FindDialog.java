package com.cdsc.eje.gui.search;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;

import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

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

public class FindDialog extends SearchDialog {
	protected JPanel buttonPanel;

	protected JPanel centerPanel;

	protected JPanel optionsPanel;

	protected JLabel findLabel;

	protected JCheckBox matchCaseCheckBox;

	protected JCheckBox wholeWordsOnlyCheckBox;

	public FindDialog(EJE frame, EJEArea textArea, String mode) {
		super(frame, textArea, mode);
		findNextButton.setText(EJE.resources.getString("search_dialog.find_next"));
		buttonPanel = new JPanel();
		centerPanel = new JPanel();
		optionsPanel = new JPanel();
		findLabel = new JLabel(EJE.resources.getString("search_dialog.find_label"));
		matchCaseCheckBox = new JCheckBox(EJE.resources.getString("search_dialog.match_case"));
		wholeWordsOnlyCheckBox = new JCheckBox(
				EJE.resources.getString("search_dialog.whole_words_only"));
		this.initialize();
	}

	public void initialize() {
		buttonPanel.setLayout(new GridLayout(2, 1));
		centerPanel.setLayout(new BorderLayout());
		optionsPanel.setLayout(new GridLayout(1, 2));
		this.setup();
		this.registerComponents();
	}

	public void setup() {
		optionsPanel.add(matchCaseCheckBox, BorderLayout.SOUTH);
		optionsPanel.add(wholeWordsOnlyCheckBox, BorderLayout.SOUTH);
		centerPanel.add(findLabel, BorderLayout.WEST);
		centerPanel.add(findText, BorderLayout.CENTER);
		centerPanel.add(optionsPanel, BorderLayout.SOUTH);
		buttonPanel.add(findNextButton);
		buttonPanel.add(cancelButton);
		this.getContentPane().add(centerPanel, BorderLayout.CENTER);
		this.getContentPane().add(buttonPanel, BorderLayout.EAST);
	}

	public void registerComponents() {
		super.registerComponents();
		findNextButton.addActionListener(this);
		cancelButton.addActionListener(this);
	}

	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		if (source == cancelButton)
			setVisible(false);
		else if (source == findNextButton)
			find();
	}

	/*
	 * public void find() { try { int length =
	 * textArea.getDocument().getLength(); String editorString =
	 * textArea.getDocument().getText(0,length); String fieldString =
	 * findText.getText(); if (!matchCaseCheckBox.isSelected()) { editorString =
	 * editorString.toLowerCase(); fieldString = fieldString.toLowerCase(); }
	 * Pattern p = Pattern.compile("\\b" + fieldString + "\\b"); Matcher m =
	 * p.matcher(editorString); String className = null; while (m.find()) { int
	 * start = m.start(); className = getClassName(start); } }
	 * catch(StringIndexOutOfBoundsException exc) { this.position = -1; find();
	 * } catch(Exception exc) { System.out.println(exc); } }
	 */

	public void find() {
		try {
			int length = textArea.getDocument().getLength();
			String editorString = textArea.getDocument().getText(0, length);
			String fieldString = findText.getText();
			if (!matchCaseCheckBox.isSelected()) {
				editorString = editorString.toLowerCase();
				fieldString = fieldString.toLowerCase();
			}
			if (wholeWordsOnlyCheckBox.isSelected()) {
				int position = editorString.indexOf(fieldString,
						this.position + fieldString.length());
				if (position == -1 && this.position != -1) {
					Toolkit.getDefaultToolkit().beep();
					this.position = 0;
					return;
				}
				editorString = editorString.substring(position - 1, position + fieldString.length()
						+ 1);
				if (!this.isWholeWord(editorString)) {
					this.position = position + fieldString.length();
					find();
					return;
				}
				if (this.position != position && position >= 0) {
					textArea.select(position, position + fieldString.length());
					this.position = position + fieldString.length();
				} else {
					this.position = -1;
					find();
				}
			} else {
				int position = editorString.indexOf(fieldString,
						this.position + fieldString.length());
				if (position == -1 && this.position != -1) {
					Toolkit.getDefaultToolkit().beep();
					this.position = 0;
					System.out.println("position " + position);
					return;
				}
				if (this.position != position && position >= 0) {
					textArea.select(position, position + fieldString.length());
					this.position = position;
				} else {
					this.position = -1;
					find();
				}
			}
		}// end try
		catch (StringIndexOutOfBoundsException exc) {
			this.position = -1;
			find();
		} catch (Exception exc) {
			System.out.println(exc);
		}
	}

	private boolean isWholeWord(String word) {
		int length = word.length();
		char firstLetter = word.charAt(0);
		char lastLetter = word.charAt(length - 1);
		if (Character.isJavaIdentifierPart(firstLetter))
			return false;
		if (Character.isJavaIdentifierPart(lastLetter))
			return false;
		return true;
	}
}