package com.cdsc.eje.gui.search;

import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
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

public abstract class SearchDialog extends JDialog implements ActionListener {
	protected JFrame frame;

	protected EJEArea textArea;

	protected JTextField findText;

	protected JButton findNextButton;

	protected JButton cancelButton;

	protected String mode;

	protected int position;

	public SearchDialog(EJE frame, EJEArea textArea, String mode) {
		super(frame, EJE.resources.getString("search_dialog.title") + mode, false);
		this.frame = frame;
		this.textArea = textArea;
		findText = new JTextField(10);
		findNextButton = new JButton();
		cancelButton = new JButton(EJE.resources.getString("search_dialog.cancel"));
	}

	public abstract void initialize();

	public abstract void setup();

	public void registerComponents() {
		findText.addKeyListener(keyListener);
	}

	public void setMode(String mode) {
		this.mode = mode;
	}

	KeyListener keyListener = new KeyAdapter() {
		public void keyPressed(KeyEvent e) {
			if (e.getKeyCode() == KeyEvent.VK_ENTER)
				find();
			else if (e.getKeyCode() == KeyEvent.VK_ESCAPE)
				setVisible(false);
		}
	};

	public abstract void find();

	public void setVisible(boolean flag) {
		if (flag) {
			findText.requestFocus();
			findText.setCaretPosition(0);
			findText.setText(textArea.getSelectedText());
			findText.selectAll();
			findText.moveCaretPosition(findText.getText().length());
			this.pack();
			this.setLocationRelativeTo(frame);
		} else {
			textArea.setCaretPosition(textArea.getSelectionStart());
		}
		super.setVisible(flag);
	}
}