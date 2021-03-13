package com.cdsc.eje.gui.options;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GraphicsEnvironment;
import java.awt.GridLayout;

import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

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
public class EditorOptionsPanel extends EJEActivePanel {
    private final String[] fontStyleValues = { EJE.resources.getString("options.font.plain"), EJE.resources.getString("options.font.bold"),
            EJE.resources.getString("options.font.italic"), EJE.resources.getString("options.font.bold_italic") };
    private final String[] fontSizeValues = { "8", "9", "10", "11", "12", "13", "14", "16", "18", "20", "22", "24", "26", "28", "32", "36",
            "40", "48", "56", "64", "72" };
    private JComboBox fontSizeCombo;
    private final String[] bracesStyleValues = { "C Style", "Java Style" };
    private JComboBox bracesStyleCombo;
    private final String[] tabSizeValues = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14" };
    private JComboBox tabSizeCombo;
    private JCheckBox classWizardCheckBox;
    private final String[] fontTypeValues;
    private JComboBox fontTypeCombo;
    private JPanel fontTypePanel;
    private JPanel fontTypeLeftPanel;
    private JPanel fontTypeRightPanel;
    private JPanel fontStylePanel;
    private JPanel fontStyleLeftPanel;
    private JPanel fontStyleRightPanel;
    private JPanel fontSizePanel;
    private JPanel fontSizeLeftPanel;
    private JPanel fontSizeRightPanel;
    private JPanel bracesStylePanel;
    private JPanel bracesStyleLeftPanel;
    private JPanel bracesStyleRightPanel;
    private JPanel tabSizePanel;
    private JPanel tabSizeLeftPanel;
    private JPanel tabSizeRightPanel;
    private JPanel classWizardPanel;
    private JPanel classWizardLeftPanel;
    private JPanel classWizardRightPanel;
    private JComboBox fontStyleCombo;

    public EditorOptionsPanel() {
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        fontTypeValues = ge.getAvailableFontFamilyNames();
        fontTypeCombo = new JComboBox(fontTypeValues);
        fontStyleCombo = new JComboBox(fontStyleValues);
        fontSizeCombo = new JComboBox(fontSizeValues);
        bracesStyleCombo = new JComboBox(bracesStyleValues);
        tabSizeCombo = new JComboBox(tabSizeValues);
        classWizardCheckBox = new JCheckBox(EJE.resources.getString("options.classwizard"));
        fontTypePanel = new JPanel();
        fontTypeLeftPanel = new JPanel();
        fontTypeRightPanel = new JPanel();
        fontStylePanel = new JPanel();
        fontStyleLeftPanel = new JPanel();
        fontStyleRightPanel = new JPanel();
        fontSizePanel = new JPanel();
        fontSizeLeftPanel = new JPanel();
        fontSizeRightPanel = new JPanel();
        bracesStylePanel = new JPanel();
        bracesStyleLeftPanel = new JPanel();
        bracesStyleRightPanel = new JPanel();
        tabSizePanel = new JPanel();
        tabSizeLeftPanel = new JPanel();
        tabSizeRightPanel = new JPanel();
        classWizardPanel = new JPanel();
        classWizardLeftPanel = new JPanel();
        classWizardRightPanel = new JPanel();
        setup();
        addDetails();
    }

    private void addDetails() {
        reload();
    }

    private void setup() {
        setLayouts();
        fontStyleLeftPanel.add(new JLabel(EJE.resources.getString("options.font.style")));
        fontStyleRightPanel.add(fontStyleCombo);
        fontSizeLeftPanel.add(new JLabel(EJE.resources.getString("options.font.size")));
        fontSizeRightPanel.add(fontSizeCombo);
        bracesStyleLeftPanel.add(new JLabel(EJE.resources.getString("options.braces.style")));
        bracesStyleRightPanel.add(bracesStyleCombo);
        tabSizeLeftPanel.add(new JLabel(EJE.resources.getString("options.tab.size")));
        tabSizeRightPanel.add(tabSizeCombo);
        fontTypeLeftPanel.add(new JLabel(EJE.resources.getString("options.font.type")));
        fontTypeRightPanel.add(fontTypeCombo);
        classWizardLeftPanel.add(classWizardCheckBox);
        fontTypePanel.add(fontTypeLeftPanel, BorderLayout.WEST);
        fontTypePanel.add(fontTypeRightPanel, BorderLayout.EAST);
        fontStylePanel.add(fontStyleLeftPanel, BorderLayout.WEST);
        fontStylePanel.add(fontStyleRightPanel, BorderLayout.EAST);
        fontSizePanel.add(fontSizeLeftPanel, BorderLayout.WEST);
        fontSizePanel.add(fontSizeRightPanel, BorderLayout.EAST);
        tabSizePanel.add(tabSizeLeftPanel, BorderLayout.WEST);
        tabSizePanel.add(tabSizeRightPanel, BorderLayout.EAST);
        classWizardPanel.add(classWizardLeftPanel, BorderLayout.WEST);
        classWizardPanel.add(classWizardRightPanel, BorderLayout.EAST);
        bracesStylePanel.add(bracesStyleLeftPanel, BorderLayout.WEST);
        bracesStylePanel.add(bracesStyleRightPanel, BorderLayout.EAST);
        this.add(fontTypePanel);
        this.add(fontStylePanel);
        this.add(fontSizePanel);
        this.add(tabSizePanel);
        this.add(classWizardPanel);
        this.add(bracesStylePanel);
    }

    private void setLayouts() {
        setLayout(new GridLayout(3, 2));
        fontTypePanel.setLayout(new BorderLayout());
        fontTypeLeftPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
        fontTypeRightPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
        fontSizePanel.setLayout(new BorderLayout());
        fontSizeLeftPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
        fontSizeRightPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
        fontStylePanel.setLayout(new BorderLayout());
        fontStyleLeftPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
        fontStyleRightPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
        bracesStylePanel.setLayout(new BorderLayout());
        bracesStyleLeftPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
        bracesStyleRightPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
        tabSizePanel.setLayout(new BorderLayout());
        tabSizeLeftPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
        tabSizeRightPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
        classWizardPanel.setLayout(new BorderLayout());
        classWizardLeftPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
        classWizardRightPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
    }

    @Override
    public void reload() {
        fontTypeCombo.setSelectedItem(EJE.options.getProperty("eje_area.font.type"));
        String fontStyle = "Error";
        switch (Integer.parseInt(EJE.options.getProperty("eje_area.font.style"))) {
        case 0:
            fontStyle = EJE.resources.getString("options.font.plain");
            break;
        case 1:
            fontStyle = EJE.resources.getString("options.font.bold");
            break;
        case 2:
            fontStyle = EJE.resources.getString("options.font.italic");
            break;
        case 3:
            fontStyle = EJE.resources.getString("options.font.bold_italic");
            break;
        default:
            assert false;
        }
        fontStyleCombo.setSelectedItem(fontStyle);
        fontSizeCombo.setSelectedItem(EJE.options.getProperty("eje_area.font.size"));
        bracesStyleCombo.setSelectedItem(EJE.options.getProperty("eje_area.braces_style"));
        tabSizeCombo.setSelectedItem(EJE.options.getProperty("eje_area.tab"));
        classWizardCheckBox.setSelected(EJE.options.getProperty("eje_area.class_wizard").equals("true") ? true : false);
    }

    @Override
    public void store() {
        EJE.options.setProperty("eje_area.font.type", fontTypeCombo.getSelectedItem().toString());
        EJE.options.setProperty("eje_area.font.style", "" + fontStyleCombo.getSelectedIndex());
        EJE.options.setProperty("eje_area.font.size", fontSizeCombo.getSelectedItem().toString());
        EJE.options.setProperty("eje_area.braces_style", bracesStyleCombo.getSelectedItem().toString());
        EJE.options.setProperty("eje_area.tab", tabSizeCombo.getSelectedItem().toString());
        EJE.options.setProperty("eje_area.class_wizard", "" + classWizardCheckBox.isSelected());
        super.store();
    }

    public static String getTab() {
        int tabSpaces = 0;
        StringBuffer spaces = new StringBuffer();
        try {
            tabSpaces = Integer.parseInt(EJE.options.getProperty("eje_area.tab"));
        } catch (NumberFormatException e) {
            System.err.println("Malformed field eje_area.tab in resources/EJE_options.properties, reset to 4");
            tabSpaces = 4;
        }
        for (int i = 0; i < tabSpaces; ++i) {
            spaces.append(" ");
        }
        return spaces.toString();
    }
}