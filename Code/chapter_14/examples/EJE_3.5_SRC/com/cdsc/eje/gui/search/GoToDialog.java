package com.cdsc.eje.gui.search;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.text.Element;

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

public class GoToDialog extends SearchDialog {
	protected JPanel buttonPanel;

	protected JPanel centerPanel;

	protected JPanel labelPanel;

	protected JPanel textPanel;

	protected JTextField replaceText;

	protected JLabel findLabel;

	protected JLabel replaceLabel;

	public GoToDialog(EJE frame, EJEArea textArea, String mode) {
		super(frame, textArea, mode);
		this.initialize();
	}

	public void initialize() {
		findNextButton.setText(EJE.resources.getString("search_dialog.go_to"));
		buttonPanel = new JPanel(new GridLayout(2, 1));
		centerPanel = new JPanel(new GridLayout(2, 1));
		findLabel = new JLabel(EJE.resources.getString("search_dialog.line_number_label"));
		this.setup();
		this.registerComponents();
	}

	public void setup() {
		centerPanel.add(findLabel, BorderLayout.WEST);
		centerPanel.add(findText, BorderLayout.CENTER);
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

	public void find() {
		try {
			Element element = textArea.getDocument().getDefaultRootElement();
			int lineRequested = Integer.parseInt(findText.getText());
			int rowCount = element.getElementCount();
			if (lineRequested > rowCount || lineRequested < 0) {
				System.out.println("There's no " + lineRequested + " line!");
				setVisible(false);
				return;
			}
			Element row = null;
			int firstCharacter = 0;
			int rowNumber = 0;
			for (int i = 0; i < lineRequested; ++i) {
				firstCharacter = getFirstCharacter(row);
				rowNumber = element.getElementIndex(firstCharacter);
				row = element.getElement(rowNumber);
			}
			int lastColumnInRow = row.getEndOffset();
			textArea.select(firstCharacter, lastColumnInRow - 1);
		} catch (NumberFormatException exc) {
			System.out.println(exc.toString());
		}
	}

	private int getFirstCharacter(Element row) {
		if (row == null)
			return 0;
		int lastColumnInRow = row.getEndOffset();
		return lastColumnInRow;
	}
}