package com.cdsc.eje.gui;

import java.awt.BorderLayout;
import java.awt.Component;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

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

public class JavaInterface extends Vector {

	protected static int rowLength = 0;

	public static int getRowLength() {
		return rowLength;
	}

	public class ClassWizardCellRenderer extends JLabel implements ListCellRenderer {
		private final ImageIcon methodIcon = new ImageIcon("resources/images/blu.png");

		private final ImageIcon fieldIcon = new ImageIcon("resources/images/ylw.png");

		public ClassWizardCellRenderer() {
			setLayout(new BorderLayout());
		}

		public Component getListCellRendererComponent(JList list, Object value, // value
				// to
				// display
				int index, // cell index
				boolean isSelected, // is the cell selected
				boolean cellHasFocus) // the list and the cell have the focus
		{
			String s = value.toString();
			setText(s);
			setIcon((s.lastIndexOf("(") != -1) ? methodIcon : fieldIcon);
			if (isSelected) {
				setBackground(list.getSelectionBackground());
				setForeground(list.getSelectionForeground());
			} else {
				setBackground(list.getBackground());
				setForeground(list.getForeground());
			}
			setEnabled(list.isEnabled());
			setFont(list.getFont());
			setOpaque(true);
			return this;
		}
	}
}