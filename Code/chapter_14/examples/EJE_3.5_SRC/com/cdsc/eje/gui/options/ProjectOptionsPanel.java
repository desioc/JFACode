package com.cdsc.eje.gui.options;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.StringTokenizer;

import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

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
public class ProjectOptionsPanel extends EJEActivePanel {

	private static final String OPTIONS_PROJECT_CLASSPATH_ERROR_MESSAGE = "options.project.classpath.error.message";

	private static final String OPTIONS_PROJECT_CLASSPATH_ERROR_TITLE = "options.project.classpath.error.title";

	private static final String PROJECT_OUTPUT_CHOOSE_TITLE = "options.project.output.choose.title";

	protected static final String PROJECT_DOCS_CHOOSE_TITLE = "options.project.docs.choose.title";

	private static final String JAVA_CLASS_PATH = "java.class.path";

	private static final String PROJECT_DOCS_PATH = "project.docs.path";

	private static final String PROJECT_OUTPUT_PATH = "project.output.path";

	private static final String PROJECT_CLASSPATH = "project.classpath";

	private static final String DOT = ".";

	private JTextField classpathTextField;

	private JButton classpathButton;

	private JTextField outputPathTextField;

	private JButton outputPathButton;

	private JTextField docsPathTextField;

	private JButton docsPathButton;

	private JPanel backgroundCenterPanel;

	private JPanel northPanel;

	private JPanel northLeftPanel;

	private JPanel northCenterPanel;

	private JPanel northRightPanel;

	private JPanel centerPanel;

	private JPanel centerLeftPanel;

	private JPanel centerCenterPanel;

	private JPanel centerRightPanel;

	private JPanel southPanel;

	private JPanel southLeftPanel;

	private JPanel southCenterPanel;

	private JPanel southRightPanel;

	public ProjectOptionsPanel() {
		classpathTextField = new JTextField("", 26);
		classpathButton = new JButton(EJE.resources.getString("options.java.button"));
		outputPathTextField = new JTextField("", 26);
		outputPathButton = new JButton(EJE.resources.getString("options.java.button"));
		docsPathTextField = new JTextField("", 26);
		docsPathButton = new JButton(EJE.resources.getString("options.java.button"));
		backgroundCenterPanel = new JPanel();
		northPanel = new JPanel();
		northLeftPanel = new JPanel();
		northCenterPanel = new JPanel();
		northRightPanel = new JPanel();
		centerPanel = new JPanel();
		centerLeftPanel = new JPanel();
		centerCenterPanel = new JPanel();
		centerRightPanel = new JPanel();
		southPanel = new JPanel();
		southLeftPanel = new JPanel();
		southCenterPanel = new JPanel();
		southRightPanel = new JPanel();
		setup();
		registerListeners();
	}

	private void setup() {
		setLayouts();
		northPanel.add(northLeftPanel, BorderLayout.WEST);
		northPanel.add(northCenterPanel, BorderLayout.CENTER);
		northPanel.add(northRightPanel, BorderLayout.EAST);

		centerPanel.add(centerLeftPanel, BorderLayout.WEST);
		centerPanel.add(centerCenterPanel, BorderLayout.CENTER);
		centerPanel.add(centerRightPanel, BorderLayout.EAST);

		southPanel.add(southLeftPanel, BorderLayout.WEST);
		southPanel.add(southCenterPanel, BorderLayout.CENTER);
		southPanel.add(southRightPanel, BorderLayout.EAST);

		northLeftPanel.add(new JLabel(EJE.resources.getString("options.project.class.path")));
		northCenterPanel.add(classpathTextField);
		northRightPanel.add(classpathButton);

		centerLeftPanel.add(new JLabel(EJE.resources.getString("options.project.output.path")));
		centerCenterPanel.add(outputPathTextField);
		centerRightPanel.add(outputPathButton);

		southLeftPanel.add(new JLabel(EJE.resources.getString("options.project.docs.path")));
		southCenterPanel.add(docsPathTextField);
		southRightPanel.add(docsPathButton);

		backgroundCenterPanel.add(northPanel);
		backgroundCenterPanel.add(centerPanel);
		backgroundCenterPanel.add(southPanel);

		this.add(backgroundCenterPanel, BorderLayout.CENTER);
		addDetails();
	}

	private void addDetails() {
		classpathTextField.setEditable(false);
		outputPathTextField.setEditable(false);
		docsPathTextField.setEditable(false);
		reload();
	}

	private void setLayouts() {
		backgroundCenterPanel.setLayout(new GridLayout(3, 1));
		northPanel.setLayout(new BorderLayout());
		northLeftPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
		northCenterPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
		northRightPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
		centerPanel.setLayout(new BorderLayout());
		centerLeftPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
		centerCenterPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
		centerRightPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
		southPanel.setLayout(new BorderLayout());
		southLeftPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
		southCenterPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
		southRightPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
		this.setLayout(new BorderLayout());
	}

	public void registerListeners() {
		classpathButton.addActionListener(changeClasspathAction);
		classpathTextField.addFocusListener(confirmClasspathAction);
		outputPathButton.addActionListener(outputPathAction);
		docsPathButton.addActionListener(changeDocsPathAction);
	}

	@Override
	public void reload() {
		String classpath = EJE.options.getProperty(PROJECT_CLASSPATH);
		if (classpath == null || classpath.equals("")) {
			classpath = System.getProperty(JAVA_CLASS_PATH);
			System.out.println("Default Classpath (System classpath - \"java.class.path\"):"
					+ classpath);
			EJE.options.setProperty(PROJECT_CLASSPATH, classpath);
		}

		classpathTextField.setText(classpath);

		String outputPath = EJE.options.getProperty(PROJECT_OUTPUT_PATH);
		if (outputPath == null || outputPath.equals("")) {
			outputPath = "";
			System.out.println("outputPath:" + outputPath);
			EJE.options.setProperty(PROJECT_OUTPUT_PATH, outputPath);
		}
		outputPathTextField.setText(outputPath);

		String docsPath = EJE.options.getProperty(PROJECT_DOCS_PATH);
		if (docsPath == null || docsPath.equals("")) {
			docsPath = "./docs";
			System.out.println("docsPath:" + docsPath);
			EJE.options.setProperty(PROJECT_DOCS_PATH, docsPath);
		}
		docsPathTextField.setText(docsPath);
		EJE.saveProperties();
	}

	@Override
	public void store() {

		String classpathValue = verifyClasspath(classpathTextField.getText());

		EJE.options.setProperty(PROJECT_CLASSPATH, classpathValue);
		EJE.options.setProperty(PROJECT_OUTPUT_PATH, outputPathTextField.getText());
		EJE.options.setProperty(PROJECT_DOCS_PATH, docsPathTextField.getText());
		EJE.getEJE().updateClassPathForReflection(EJE.options.getProperty(PROJECT_CLASSPATH), "");
		EJE.getEJE().updateClassPathForReflection(EJE.options.getProperty(PROJECT_OUTPUT_PATH), "");
		super.store();
	}

	private String verifyClasspath(String classpathValue) {
		StringTokenizer tokenizer = new StringTokenizer(classpathValue, File.pathSeparator);
		StringBuffer classpathVerified = new StringBuffer();
		ArrayList errors = new ArrayList(1);
		while (tokenizer.hasMoreTokens()) {
			String token = tokenizer.nextToken().trim();
			File fileToVerify = new File(token);
			if (!fileToVerify.exists()) {
				errors.add(token);
				JOptionPane.showMessageDialog(EJEOptionsDialog.getInstance(), token + " "
						+ EJE.resources.getString(OPTIONS_PROJECT_CLASSPATH_ERROR_MESSAGE),
						EJE.resources.getString(OPTIONS_PROJECT_CLASSPATH_ERROR_TITLE),
						JOptionPane.ERROR_MESSAGE);
			} else {
				classpathVerified.append(token + File.pathSeparatorChar);
			}
		}
		return classpathVerified.toString();
	}

	AbstractAction changeClasspathAction = new AbstractAction() {
		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				classpathTextField.setEditable(true);
			} catch (Exception ex) {
				ex.printStackTrace();

			}
		}
	};

	FocusListener confirmClasspathAction = new FocusAdapter() {
		@Override
		public void focusLost(FocusEvent e) {
			try {
				classpathTextField.setEditable(false);
			} catch (Exception ex) {
				ex.printStackTrace();

			}
		}
	};

	AbstractAction outputPathAction = new AbstractAction() {
		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				String outputPath = EJE.options.getProperty(PROJECT_OUTPUT_PATH);
				if (outputPath == null || !(new File(outputPath).exists())) {
					outputPath = DOT;
				}
				String outputTitle = EJE.resources.getString(PROJECT_OUTPUT_CHOOSE_TITLE);
				File selectedFile = showChangePathDialog(outputPath, outputTitle);
				if (selectedFile != null) {
					String dirName = selectedFile.getCanonicalPath();
					outputPathTextField.setText(dirName);
				}
			} catch (FileNotFoundException ex) {
				ex.printStackTrace();
				assert false;
			} catch (Exception ex) {
				ex.printStackTrace();
				assert false;
			}
		}
	};

	AbstractAction changeDocsPathAction = new AbstractAction() {
		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				String docsPath = EJE.options.getProperty(PROJECT_DOCS_PATH);
				if (docsPath == null || !(new File(docsPath).exists())) {
					docsPath = DOT;
				}
				String docsTitle = EJE.resources.getString(PROJECT_DOCS_CHOOSE_TITLE);
				File selectedFile = showChangePathDialog(docsPath, docsTitle);
				if (selectedFile != null) {
					String dirName = selectedFile.getCanonicalPath();
					docsPathTextField.setText(dirName);
				}
			} catch (FileNotFoundException ex) {
				ex.printStackTrace();
				assert false;
			} catch (Exception ex) {
				ex.printStackTrace();
				assert false;
			}
		}

	};

	public File showChangePathDialog(String docsPath, String title) {
		JFileChooser docsPathChooser = new JFileChooser(docsPath);
		docsPathChooser.setDialogTitle(title);
		docsPathChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		int returnValue = docsPathChooser.showOpenDialog(EJEOptionsDialog.getInstance());
		File selectedFile = (returnValue == JFileChooser.APPROVE_OPTION) ? docsPathChooser
				.getSelectedFile() : null;
		return selectedFile;
	}

	/**
	 * @return Returns the jdkPathTextField.
	 */
	public JTextField getOutputPathTextField() {
		return outputPathTextField;
	}

	/**
	 * @param jdkPathTextField
	 *            The jdkPathTextField to set.
	 */
	public void setOutputPathTextField(JTextField jdkPathTextField) {
		this.outputPathTextField = jdkPathTextField;
	}
}
