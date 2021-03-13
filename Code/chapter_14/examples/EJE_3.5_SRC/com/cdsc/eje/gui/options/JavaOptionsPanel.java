package com.cdsc.eje.gui.options;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.StringTokenizer;

import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JDialog;
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
public class JavaOptionsPanel extends EJEActivePanel {
    private static final long serialVersionUID = -1132966092320070470L;
    private static final String OPTIONS_JAVA_TARGET = "options.java.target";
    private static final String OPTIONS_JAVA_VERSION = "options.java.version";
    private static final String OPTIONS_JAVA_DOCS_PATH = "options.java.docs.path";
    private static final String OPTIONS_JAVA_JDK_PATH = "options.java.jdk.path";
    private static final String JRE = "jre";
    private static final String JAVA_HOME = "java.home";
    private static final String EJE_JDK_PATH = "eje.jdk.path";
    private static final String OPTIONS_JAVA_ASSERTIONS = "options.java.assertions";
    private static final String OPTIONS_JAVA_BUTTON = "options.java.button";
    private final String[] javaVersionValues = { "1.3", "1.4", "1.5", "1.6", "1.7", "1.8", "9" };
    private final String[] javaTargetValues = { "1.1", "1.2", "1.3", "1.4", "1.5", "1.6", "1.7", "1.8", "9" };
    private JTextField jdkPathTextField;
    private JButton jdkPathButton;
    private JTextField docsPathTextField;
    private JButton docsPathButton;
    private JCheckBox javaAssertEnabledCheckBox;
    private JComboBox javaVersionCombo;
    private JComboBox javaTargetCombo;
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

    public JavaOptionsPanel() {
        jdkPathTextField = new JTextField("", 26);
        jdkPathButton = new JButton(EJE.resources.getString(OPTIONS_JAVA_BUTTON));
        docsPathTextField = new JTextField("", 26);
        docsPathButton = new JButton(EJE.resources.getString(OPTIONS_JAVA_BUTTON));
        javaAssertEnabledCheckBox = new JCheckBox(EJE.resources.getString(OPTIONS_JAVA_ASSERTIONS));
        javaVersionCombo = new JComboBox(javaVersionValues);
        javaTargetCombo = new JComboBox(javaTargetValues);
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
        // northPanel.add(new JLabel(EJE.resources
        // .getString("options.java.version.using")
        // + System.getProperty("eje.java.version")));
        northPanel.add(northLeftPanel, BorderLayout.WEST);
        northPanel.add(northCenterPanel, BorderLayout.CENTER);
        northPanel.add(northRightPanel, BorderLayout.EAST);
        centerPanel.add(centerLeftPanel, BorderLayout.WEST);
        centerPanel.add(centerCenterPanel, BorderLayout.CENTER);
        centerPanel.add(centerRightPanel, BorderLayout.EAST);
        southPanel.add(southLeftPanel);
        southPanel.add(southCenterPanel);
        southPanel.add(southRightPanel);
        northLeftPanel.add(new JLabel(EJE.resources.getString(OPTIONS_JAVA_JDK_PATH)));
        northCenterPanel.add(jdkPathTextField);
        northRightPanel.add(jdkPathButton);
        centerLeftPanel.add(new JLabel(EJE.resources.getString(OPTIONS_JAVA_DOCS_PATH)));
        centerCenterPanel.add(docsPathTextField);
        centerRightPanel.add(docsPathButton);
        southLeftPanel.add(javaAssertEnabledCheckBox);
        southCenterPanel.add(new JLabel(EJE.resources.getString(OPTIONS_JAVA_VERSION)));
        southCenterPanel.add(javaVersionCombo);
        southRightPanel.add(new JLabel(EJE.resources.getString(OPTIONS_JAVA_TARGET)));
        southRightPanel.add(javaTargetCombo);
        backgroundCenterPanel.add(northPanel);
        backgroundCenterPanel.add(centerPanel);
        backgroundCenterPanel.add(southPanel);
        this.add(backgroundCenterPanel, BorderLayout.CENTER);
        addDetails();
    }

    private void addDetails() {
        // backgroundCenterPanel.setBorder(new TitledBorder("Java & Javac
        // Options"));
        docsPathTextField.setEditable(false);
        jdkPathTextField.setEditable(false);
        reload();
    }

    @Override
    public void reload() {
        String jdkPath = EJE.options.getProperty(EJE_JDK_PATH);
        if (jdkPath == null || jdkPath.equals("")) {
            String jrePath = System.getProperty(JAVA_HOME);
            System.out.println("jrePath " + jrePath);
            jdkPath = (jrePath.endsWith(JRE) ? jrePath.substring(0, jrePath.length() - 4) : jrePath);
            /*
             * File file = new File(jdkPath +
             * "/bin/java"+(EJE.OS_NAME.toLowerCase().startsWith("win") ?
             * ".exe":"")); if (!file.exists()) {
             * JOptionPane.showMessageDialog(EJEOptionsDialog.getInstance(),
             * "JDK not found! Please select a valid location for JDK Path in
             * File - Options - Java"); }
             */
            System.out.println("jdkPath:" + jdkPath);
        }
        // System.setProperty(JAVA_HOME, jdkPath);
        jdkPathTextField.setText(jdkPath);
        String docsPath = EJE.options.getProperty("eje.java.docs");
        if (docsPath == null || docsPath.equals("")) {
            docsPath = jdkPath + "/docs";
            System.out.println("docsPath:" + docsPath);
            EJE.options.setProperty("eje.java.docs", docsPath);
            EJE.saveProperties();
        }
        docsPathTextField.setText(docsPath);
        // String jrePath = jdkPath + "/jre";
        // String jreLibPath = jrePath + "/lib";
        String javacVersion = EJE.options.getProperty("eje.javac.version");
        String javacTarget = EJE.options.getProperty("eje.javac.target");
        String javaVersion = getJavaVersion();
        /*
         * String osArch = System.getProperty("os.arch"); String
         * sunBootLibraryPath = jreLibPath + "/" +
         * osArch;//EJE.properties.getProperty("sun.boot.library.path"); String
         * endorsedDirs = jreLibPath + "/endorsed";//
         * EJE.properties.getProperty("java.endorsed.dirs"); String
         * javaLibraryPath = System.getProperty("java.library.path") +
         * File.pathSeparator + sunBootLibraryPath + "/client" +
         * File.pathSeparator + sunBootLibraryPath + File.pathSeparator +
         * jreLibPath; System.out.println("javaLibraryPath = " +
         * javaLibraryPath); String javaSpecificationVersion = javaVersion;
         * String javaExtDirs = jreLibPath + "/ext"; String sunBootClassPath =
         * System .getProperty("sun.boot.class.path") + File.pathSeparator +
         * jreLibPath + "/rt.jar" + File.pathSeparator + jreLibPath +
         * "/i18n.jar" + File.pathSeparator + jreLibPath + "/sunrsasign.jar" +
         * File.pathSeparator + jreLibPath + "/jsse.jar" + File.pathSeparator +
         * jreLibPath + "/jce.jar" + File.pathSeparator + jreLibPath +
         * "/charsets.jar" + File.pathSeparator + jrePath + "/classes";
         * System.setProperty("sun.boot.class.path", sunBootClassPath);
         *
         * System.out.println("sunBootClassPath = " + System
         * .getProperty("sun.boot.class.path"));
         */
        System.out.println("javaVersion:" + javaVersion);
        EJE.options.setProperty("eje.java.version", javaVersion);
        System.out.println("java " + javaVersion);
        System.out.println("javac " + javacVersion);
        if (javaVersion.startsWith("1.8") || javacVersion.equals("1.8") || jdkPath.contains("1.8")) {
            javacVersion = "1.8";
            javacTarget = "1.8";
        } else if (javaVersion.startsWith("1.7") || javacVersion.equals("1.7") || jdkPath.contains("1.7")) {
            javacVersion = "1.7";
            javacTarget = "1.7";
        } else if (javaVersion.startsWith("1.6") || javacVersion.equals("1.6") || jdkPath.contains("1.6")) {
            javacVersion = "1.6";
            javacTarget = "1.6";
        } else if (javaVersion.startsWith("1.5") || javacVersion.equals("1.5") || jdkPath.contains("1.5")) {
            javacVersion = "1.5";
            javacTarget = "1.5";
        } else if (javaVersion.startsWith("1.4")
                && ((javacVersion.equals("1.5") || javacVersion.equals("1.6") || javacVersion.equals("1.7"))
                        || (javacTarget.equals("1.5") || javacTarget.equals("1.6") || javacTarget.equals("1.7")) || (javacVersion
                        .equals("") && javacTarget.equals("")))) {
            javacVersion = "1.3";
            javacTarget = "1.4";
        } else if (javaVersion.startsWith("1.5")
                && (javacVersion.equals("1.6") || javacTarget.equals("1.6") || javacTarget.equals("1.7") || (javacVersion.equals("") && javacTarget
                        .equals("")))) {
            javacVersion = "1.3";
            javacTarget = "1.4";
        } else if ((javaVersion.startsWith("1.6") || javacTarget.equals("1.7")) && javacVersion.equals("") && javacTarget.equals("")) {
            javacVersion = "1.3";
            javacTarget = "1.4";
        }
        EJE.options.setProperty("eje.javac.version", javacVersion);
        EJE.options.setProperty("eje.javac.target", javacTarget);
        EJE.saveProperties();
        javaVersionCombo.setSelectedItem(javacVersion);
        javaTargetCombo.setSelectedItem(javacTarget);
        javaAssertEnabledCheckBox.setSelected(EJE.options.getProperty("eje.java.assertions").equals("true") ? true : false);
    }

    private String getJavaVersion() {
        try {
            String jdkPath = EJE.options.getProperty(EJE_JDK_PATH);
            System.out.println("get java version: jdkPath" + jdkPath);
            StringTokenizer st = new StringTokenizer(jdkPath, ".", false);
            char minorVersion = '4';
            for (int i = 0; i < 2; ++i) {
                System.out.println("minorVersion" + minorVersion);
                minorVersion = st.nextToken().charAt(0);
            }
            return "1." + minorVersion;
        } catch (Exception ex) {
            ex.printStackTrace();
            return "1.6";
        }
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
        southPanel.setLayout(new GridLayout(1, 3));
        southLeftPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
        southCenterPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
        southRightPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
        this.setLayout(new BorderLayout());
    }

    public void registerListeners() {
        jdkPathButton.addActionListener(changeJdkPathAction);
        docsPathButton.addActionListener(changeDocsPathAction);
    }

    @Override
    public void store() {
        EJE.options.setProperty(EJE_JDK_PATH, jdkPathTextField.getText());
        EJE.options.setProperty("eje.java.docs", docsPathTextField.getText());
        EJE.options.setProperty("eje.javac.version", javaVersionCombo.getSelectedItem().toString());
        EJE.options.setProperty("eje.javac.target", javaTargetCombo.getSelectedItem().toString());
        EJE.options.setProperty("eje.java.assertions", "" + javaAssertEnabledCheckBox.isSelected());
        // dumpProperties();
        // Properties properties = new Properties();
        // setSystemProperties(properties);
        // to be sure to load external resources:
        EJE.getEJE().updateClassPathForReflection(EJE.options.getProperty(EJE_JDK_PATH) + "/jre/lib/ext",
                EJE.options.getProperty(EJE_JDK_PATH) + "/lib");
        super.store();
    }

    /*
     * private void setSystemProperties(Properties properties) { try {
     * properties.load(new FileInputStream(new File(
     * "resources/EJE_env.properties"))); System.setProperties(properties);
     * Properties p = System.getProperties(); Enumeration e = p.keys(); while
     * (e.hasMoreElements()) { String key = (String) e.nextElement(); String
     * value = (String) p.get(key); System.out.println(key + "- - - " + value);
     * } } catch (FileNotFoundException e) { e.printStackTrace(); } catch
     * (IOException e) { e.printStackTrace(); } }
     *
     * private void dumpProperties() { File thisDir = new File("."); String here
     * = thisDir.getAbsolutePath(); here = here.substring(0, here.length() - 1);
     *
     * try { String cmd[] = { System.getProperty("java.home") + "/bin/java",
     * "-classpath", here, "com/cdsc/soft/eje/utilities/PropertiesDumper" };
     *
     * Runtime.getRuntime().exec(cmd, null, new File(here)); } catch (Exception
     * exc) { exc.printStackTrace(); } }
     */
    AbstractAction changeJdkPathAction = new AbstractAction() {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                String jdkPath = EJE.options.getProperty(EJE_JDK_PATH);
                if (jdkPath == null || !(new File(jdkPath).exists())) {
                    jdkPath = System.getProperty(JAVA_HOME);
                }
                int index = -1;
                if ((index = jdkPath.indexOf("jdk")) != -1) {
                    final String jdkPathSubstring = jdkPath.substring(index);
                    try {
                        checkValidJdkPath(jdkPathSubstring);
                    } catch (FileNotFoundException exc) {
                        //search for other JDK in C:\Program Files\Java programs directory
                        if ((index = jdkPath.indexOf("jdk")) != -1) {

                        }
                    }
                }
                String jdkTitle = EJE.resources.getString("options.java.jdk.choose.title");
                File selectedFile = showChangePathDialog(jdkPath, jdkTitle);
                if (selectedFile != null) {
                    String dirName = selectedFile.getCanonicalPath();
                    checkValidJdkPath(dirName);
                    jdkPathTextField.setText(dirName);
                    EJE.getEJE().setJDKValid(true);
                }
            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
                EJE.getEJE().setJDKValid(false);
                JPanel panel = new JPanel(new GridLayout(2, 1));
                panel.add(new JLabel(EJE.resources.getString("options.java.jdk.choose.error")));
                JOptionPane pane = new JOptionPane(panel);
                JDialog dialog = pane.createDialog(EJE.getEJE(), "EJE: Everyone's Java Editor...");
                dialog.pack();
                dialog.setLocationRelativeTo(null);
                dialog.setVisible(true);
                // dialog.show();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    };
    // showChangePathDialog
    AbstractAction changeDocsPathAction = new AbstractAction() {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                String docsPath = EJE.options.getProperty("eje.java.docs");
                if (docsPath == null || !(new File(docsPath).exists())) {
                    docsPath = System.getProperty(JAVA_HOME);
                }
                String docsTitle = EJE.resources.getString("html.docs_msg");
                File selectedFile = showChangePathDialog(docsPath, docsTitle);
                if (selectedFile != null) {
                    String dirName = selectedFile.getCanonicalPath();
                    checkValidDocsPath(dirName);
                    docsPathTextField.setText(dirName);
                }
            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
                showMissingDocsDialog();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    };

    public File showChangePathDialog(String docsPath, String title) {
        JFileChooser docsPathChooser = new JFileChooser(docsPath);
        docsPathChooser.setDialogTitle(title);
        docsPathChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int returnValue = docsPathChooser.showOpenDialog(EJEOptionsDialog.getInstance());
        File selectedFile = (returnValue == JFileChooser.APPROVE_OPTION) ? docsPathChooser.getSelectedFile() : null;
        return selectedFile;
    }

    public void showMissingDocsDialog() {
        JPanel panel = new JPanel(new GridLayout(2, 1));
        panel.add(new JLabel(EJE.resources.getString("html.missing_docs")));
        panel.add(new JLabel(EJE.resources.getString("html.positioning_docs")));
        JOptionPane pane = new JOptionPane(panel);
        JDialog dialog = pane.createDialog(EJE.getEJE(), "EJE: Everyone's Java Editor...");
        dialog.pack();
        dialog.setLocationRelativeTo(null);
        dialog.setVisible(true);
    }

    public void checkValidDocsPath(String dirName) throws FileNotFoundException {
        File java = new File(dirName + "/api/index.html");
        if (!java.exists())
            throw new FileNotFoundException("docs");
    }

    public void checkValidJdkPath(String dirName) throws FileNotFoundException {
        if (dirName == null || dirName.equals("")) {
            throw new FileNotFoundException("JDK path");
        }
        File java = new File(dirName + (EJE.OS_NAME.toLowerCase().startsWith("win") ? "/bin/java.exe" : "/bin/java"));
        if (!java.exists())
            throw new FileNotFoundException("java");
        File javac = new File(dirName + (EJE.OS_NAME.toLowerCase().startsWith("win") ? "/bin/javac.exe" : "/bin/javac"));
        if (!javac.exists())
            throw new FileNotFoundException("javac");
        File javadoc = new File(dirName + (EJE.OS_NAME.toLowerCase().startsWith("win") ? "/bin/javadoc.exe" : "/bin/javadoc"));
        if (!javadoc.exists()) {
            throw new FileNotFoundException("javadoc");
        }
    }

    public AbstractAction getChangeDocsPathAction() {
        return changeDocsPathAction;
    }

    public AbstractAction getChangeJdkPathAction() {
        return changeJdkPathAction;
    }

    public JTextField getJdkPathTextField() {
        return jdkPathTextField;
    }

    public void setJdkPathTextField(JTextField jdkPathTextField) {
        this.jdkPathTextField = jdkPathTextField;
    }
}