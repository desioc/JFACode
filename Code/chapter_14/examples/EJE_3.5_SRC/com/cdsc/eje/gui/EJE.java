package com.cdsc.eje.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.Event;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.JobAttributes;
import java.awt.PageAttributes;
import java.awt.PrintJob;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.Window;
import java.awt.datatransfer.DataFlavor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.StringReader;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.Properties;
import java.util.ResourceBundle;
import java.util.StringTokenizer;
import java.util.Vector;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JEditorPane;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import javax.swing.JToolBar;
import javax.swing.JViewport;
import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.HyperlinkEvent;
import javax.swing.event.HyperlinkListener;
import javax.swing.text.BadLocationException;
import javax.swing.text.Element;
import javax.swing.text.html.HTMLDocument;
import javax.swing.text.html.HTMLFrameHyperlinkEvent;
import javax.swing.tree.DefaultMutableTreeNode;

import com.cdsc.eje.entities.CompilableFile;
import com.cdsc.eje.entities.JavaFile;
import com.cdsc.eje.entities.ProjectFile;
import com.cdsc.eje.gui.options.EJEOptionsDialog;
import com.cdsc.eje.gui.options.EditorOptionsPanel;
import com.cdsc.eje.gui.options.JavaOptionsPanel;
import com.cdsc.eje.gui.search.ReplaceDialog;
import com.cdsc.eje.gui.search.SearchDialog;
import com.cdsc.eje.gui.search.SearchFactory;
import com.cdsc.eje.gui.utilities.EJEUtils;
import com.cdsc.eje.gui.utilities.JavaFileView;
import com.cdsc.eje.gui.utilities.JavaFilter;
import com.cdsc.eje.jdk.Compiler;
import com.cdsc.eje.jdk.JDKApplication;
import com.cdsc.eje.jdk.JVM;
import com.cdsc.eje.jdk.utilities.FileValidator;

/*
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
public class EJE extends JFrame {
    private static final long serialVersionUID = -6017898306748121062L;
    public static final String EJE_VERSION = "3.5";
    public static final String EJE_CODE_NAME = "Take The Time";
    // Variables declaration ***************************************************
    private JMenuBar menuBar;
    // Declaration of file menu ************************************************
    private JMenu fileMenu;
    private JMenuItem newMenuItem;
    private JMenuItem openMenuItem;
    private JMenuItem saveMenuItem;
    private JMenuItem saveAsMenuItem;
    private JMenuItem saveAllMenuItem;
    private JMenuItem printMenuItem;
    private JMenu recentMenu;
    private JMenuItem optionsMenuItem;
    private JMenuItem closeMenuItem;
    private JMenuItem exitMenuItem;
    // Declaration of edit menu ************************************************
    private JMenu editMenu;
    private JMenuItem undoMenuItem;
    private JMenuItem redoMenuItem;
    private JMenuItem cutMenuItem;
    private JMenuItem copyMenuItem;
    private JMenuItem pasteMenuItem;
    private JMenuItem deleteMenuItem;
    private JMenuItem selectAllMenuItem;
    private JMenuItem toUpperCaseMenuItem;
    private JMenuItem toLowerCaseMenuItem;
    private JMenuItem invertCaseMenuItem;
    // Declaration of search menu **********************************************
    private JMenu searchMenu;
    private JMenuItem findMenuItem;
    private JMenuItem replaceMenuItem;
    private JMenuItem findNextMenuItem;
    private JMenuItem gotoMenuItem;
    /*
     *
     * 0 class 1 interface 2 enum 3 annotation 4 constructor 5 constructor with
     * args 6 main 7 java bean property 8costant 9 singleton pattern
     *
     * f1 comment f2 if f3 switch f4 for f5 while f6 do-while f7 for-each f8
     * try-catch f9 System.out.println f10 collection (arrayList-HashMap- f11
     * list (con generics) f12 map () -set
     */
    // Declaration of insert menu **********************************************
    private JMenu insertMenu;
    private JMenuItem classMenuItem;
    private JMenuItem interfaceMenuItem;
    private JMenuItem enumMenuItem;
    private JMenuItem annotationMenuItem;
    private JMenuItem constructorMenuItem;
    private JMenuItem constructorWithArgsMenuItem;
    private JMenuItem mainMenuItem;
    private JMenuItem javaBeanPropertyMenuItem;
    private JMenuItem constantMenuItem;
    private JMenuItem singletonMenuItem;
    private JMenuItem ifMenuItem;
    private JMenuItem switchMenuItem;
    private JMenuItem forMenuItem;
    private JMenuItem whileMenuItem;
    private JMenuItem doWhileMenuItem;
    private JMenuItem forEachMenuItem;
    private JMenuItem tryCatchMenuItem;
    private JMenuItem roundBracketsMenuItem;
    private JMenuItem squareBracketsMenuItem;
    private JMenuItem curlyBracesMenuItem;
    private JMenuItem systemOutMenuItem;
    private JMenuItem commentMenuItem;
    /*
     * private JMenuItem infoCommentMenuItem;
     *
     * private JMenuItem licenseMenuItem;
     */
    // Declaration of view menu ************************************************
    private JMenu viewMenu;
    private JMenuItem nextFileMenuItem;
    private JMenuItem previousFileMenuItem;
    private JCheckBoxMenuItem toolbarMenuItem;
    private JCheckBoxMenuItem statusbarMenuItem;
    private JCheckBoxMenuItem rowNumberMenuItem;
    /*
     * private JMenu lookAndFeelMenu;
     *
     * private ButtonGroup styleGroup;
     *
     * private JRadioButtonMenuItem javaMenuItem;
     *
     * private JRadioButtonMenuItem windowsMenuItem;
     *
     * private JRadioButtonMenuItem motifMenuItem;
     */
    // Declaration of project menu *********************************************
    private JMenu projectMenu;
    private JMenuItem newProjectMenuItem;
    private JMenuItem openProjectMenuItem;
    private JMenuItem saveProjectMenuItem;
    private JMenuItem saveAsProjectMenuItem;
    private JMenu recentProjectMenuItem;
    private JMenuItem addFileMenuItem;
    private JMenuItem removeFileMenuItem;
    private JMenuItem projectPropertiesMenuItem;
    private JMenuItem closeProjectMenuItem;
    // Declaration of build menu ***********************************************
    private JMenu buildMenu;
    private JMenuItem workDirectoryMenuItem;
    // private JMenuItem setAsMainMenuItem;
    private JMenuItem compileMenuItem;
    // TODO
    // private JMenuItem compileWithArgsMenuItem;
    private JMenuItem compileProjectMenuItem;
    // TODO
    // private JMenuItem compileProjectWithArgsMenuItem;
    private JMenuItem executeMenuItem;
    private JMenuItem executeWithArgsMenuItem;
    private JMenuItem stopProcessingMenuItem;
    // Declaration of tools menu ***********************************************
    private JMenu toolsMenu;
    private JMenuItem alarmMenuItem;
    private JMenuItem showMemMenuItem;
    private JMenuItem javaDocMenuItem;
    // TODO
    // private JMenuItem makeJarMenuItem;
    // TODO
    // private JMenuItem makeManifestMenuItem;
    private JMenuItem formatCodeMenuItem;
    // Declaration of help menu ************************************************
    private JMenu helpMenu;
    // private JMenuItem tipMenuItem;
    private JMenuItem contentsMenuItem;
    private JMenuItem showAPIDocsMenuItem;
    private JMenuItem aboutMenuItem;
    // Declaration of visible components ***************************************
    private JToolBar toolbar;
    private JSplitPane centerSplitPane;
    private JSplitPane mainSplitPane;
    private JTabbedPane tabbedPane;
    private EJETab ejeTab;
    private DefaultMutableTreeNode root;
    private EJETree ejeTree;
    private EJEIOArea messageArea;
    private JFileChooser fileDialog;
    private SearchDialog searchDialog;
    private EJEStatusBar statusbar;
    // Declaration of toolbar buttons components
    // **********************************
    private JButton newButton;
    private JButton openButton;
    private JButton saveButton;
    private JButton saveAllButton;
    private JButton printButton;
    private JButton undoButton;
    private JButton redoButton;
    private JButton cutButton;
    private JButton copyButton;
    private JButton pasteButton;
    private JButton findButton;
    private JButton nextFileButton;
    private JButton previousFileButton;
    private JButton compileButton;
    private JButton compileAllButton;
    private JButton executeButton;
    private JButton stopProcessingButton;
    private JButton alarmClockButton;
    private JButton showMemButton;
    private JButton formatButton;
    private JButton commentButton;
    private JButton showAPIDocsButton;
    private JButton aboutButton;
    private JComboBox setAsMainCombo;
    // Declaration of components
    // **************************************************
    private Vector<EJETab> documents;
    protected HashSet<URL> classPathForReflection;
    private SearchFactory searchFactory;
    private String ejeStyle;
    // Declaration of configuration attribute
    // *************************************
    /**
     * The resource bundle for the EJE project.
     */
    public static ResourceBundle resources;
    /**
     * The options for the EJE project.
     */
    public static Properties options;
    // Declarations of JDK utilities
    // **********************************************
    private JDKApplication jdkApplication;
    private boolean isJDKValid;
    // Declarations of Listeners
    // ***************************************************
    private TabHandler tabHandler;
    AbstractAction newAction;
    AbstractAction openAction;
    OpenRecentListener openRecentListener;
    AbstractAction saveAction;
    AbstractAction saveAllAction;
    AbstractAction cutAction;
    AbstractAction copyAction;
    AbstractAction pasteAction;
    AbstractAction stopProcessingAction;
    AbstractAction alarmClockAction;
    AbstractAction lookAndFeelAction;
    static RecentFilesHandler recentFiles;
    /**
     * Contains the name of the operating system.
     */
    public static final String OS_NAME = System.getProperty("os.name");
    // Static initializer to load language resources
    // *******************************
    static {
        try {
            options = new Properties();
            try {
                loadProperties();
                recentFiles = new RecentFilesHandler();
            } catch (FileNotFoundException e) {
                System.err.println("resources/EJE_options.properties not found");
                System.exit(0);
            } catch (IOException e) {
                e.printStackTrace();
            }
            Locale locale = null;
            String language = EJE.options.getProperty("eje.lang");
            locale = (language != null && !language.equals("") ? new Locale(language) : Locale.getDefault());
            resources = ResourceBundle.getBundle("resources.EJE", locale);
            EJE.options.setProperty("eje.lang", locale.getLanguage());
            checkVersion();
            saveProperties();
        } catch (MissingResourceException mre) {
            System.err.println("resources/EJE.properties not found");
            System.exit(0);
        }
    }

    /**
     * Load the properties file.
     *
     * @throws FileNotFoundException
     */
    public static void loadProperties() throws FileNotFoundException {
        InputStream inputStream = null;
        try {
            inputStream = new FileInputStream("resources/EJE_options.properties");
            options.load(inputStream);
        } catch (FileNotFoundException e) {
            System.err.println("resources/EJE_options.properties not found");
            e.printStackTrace();
            throw e;
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                inputStream.close();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
    }

    private static void checkVersion() {
        URLConnection connection = null;
        BufferedReader bufferredReader = null;
        try {
            final String EJE_VERSION_URL = "http://www.claudiodesio.com/eje_version.htm";
            URL url = new URL(EJE_VERSION_URL);
            connection = url.openConnection();
            connection.connect();
            System.out.println("Connecting to " + EJE_VERSION_URL + "...");
            bufferredReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            System.out.println("Reading version...");
            String currentEJEVersion;
            if ((currentEJEVersion = bufferredReader.readLine()) != null) {
                System.out.println("Current EJE version = " + currentEJEVersion);
            }
            if (currentEJEVersion != null && !EJE_VERSION.equals(currentEJEVersion)) {
                int result = JOptionPane.showOptionDialog(null, String.format(resources.getString("update_version_msg"), currentEJEVersion),
                        resources.getString("update_version_title"), JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null,
                        null);
                if (result == 0) {
                    Desktop.getDesktop().browse(new URI("http://sourceforge.net/projects/eje/"));
                    System.exit(0);
                }
            }
        } catch (Exception exc) {
            exc.printStackTrace();
        }
    }

    /**
     * Save the properties file.
     */
    public static void saveProperties() {
        OutputStream os = null;
        try {
            os = new FileOutputStream("resources/EJE_options.properties");
            EJE.options.store(os, "EJE OPTIONS - DO NOT EDIT");
        } catch (FileNotFoundException e) {
            System.err.println("resources/EJE_options.properties not found");
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                os.close();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
    }

    /**
     * Update the properties file.
     */
    public static void updateProperties() {
        try {
            loadProperties();
            System.out.println("Properties updated");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    static class RecentFilesHandler {
        private String[] files;

        public RecentFilesHandler() throws IOException {
            try {
                int number = Integer.parseInt(EJE.options.getProperty("file.number.recent"));
                if (number > 20) {
                    number = 20;
                }
                files = new String[number];
            } catch (NumberFormatException e) {
                e.printStackTrace();
                System.out.println("Property file.number.recent in resources/EJE_options.properties is not a number...using default");
                files = new String[Integer.parseInt(EJE.options.getProperty("file.number.recent"))];
            }
            Enumeration<?> enumeration = EJE.options.elements();
            enumeration.nextElement();
            int i = 0;
            while (enumeration.hasMoreElements()) {
                String element = (String) enumeration.nextElement();
                String value = (String) EJE.options.get(element);
                files[i] = value;
            }
        }

        public void add(String file) {
            if (EJE.options.containsValue(file)) {
                Enumeration<?> keys = EJE.options.keys();
                while (keys.hasMoreElements()) {
                    String key = (String) keys.nextElement();
                    String value = EJE.options.getProperty(key);
                    if (value != null && value.equals(file)) {
                        if (key.endsWith("1")) {
                            return;
                        }
                        EJE.options.setProperty(key, "");
                        break;
                    }
                }
            }
            shiftFile("file.recent2", (String) EJE.options.get("file.recent1"));
            EJE.options.setProperty("file.recent1", file);
            saveProperties();
        }

        public void shiftFile(String recentKey, String recentValue) {
            int recentKeyLength = recentKey.length();
            String nextKey = recentKey.substring(0, recentKeyLength - 1) + (Integer.parseInt(recentKey.substring(recentKeyLength - 1)) + 1);
            String nextValue = (String) EJE.options.get(recentKey);
            if (EJE.options.containsKey(recentKey)) {
                EJE.options.setProperty(recentKey, recentValue);
                if (nextValue != null && !nextValue.equals("")) {
                    shiftFile(nextKey, nextValue);
                }
            }
        }

        public ArrayList<String> getKeys() {
            Enumeration<?> recentFilesKeys = EJE.options.keys();
            ArrayList<String> keys = new ArrayList<String>();
            while (recentFilesKeys.hasMoreElements()) {
                String key = (String) recentFilesKeys.nextElement();
                if (key.startsWith("file.recent")) {
                    keys.add(key);
                }
            }
            return keys;
        }
    }

    private static EJE eje = null;
    private Vector<String> runnableDocuments;

    public static EJE getEJE() {
        if (eje == null)
            eje = new EJE();
        return eje;
    }

    // End of variables declaration
    // Initialize every attribute **********************************************
    private EJE() {
        DataFlavor[] availableFlavors = { DataFlavor.plainTextFlavor, DataFlavor.stringFlavor };
        DataFlavor.selectBestTextFlavor(availableFlavors);
        setJDKValid(true);
        ejeStyle = (String) EJE.options.get("eje.style");
        try {
            UIManager.setLookAndFeel(ejeStyle);
            SwingUtilities.updateComponentTreeUI(this);
        } catch (Exception e) {
            e.printStackTrace();
        }
        classPathForReflection = new HashSet<URL>();
        openRecentListener = new OpenRecentListener();
        // Initialize menu attributes
        fileMenu = new JMenu(resources.getString("menu.file"));
        newMenuItem = new JMenuItem(resources.getString("file.new"), new ImageIcon("resources" + File.separator + "images" + File.separator
                + "new.png"));
        openMenuItem = new JMenuItem(resources.getString("file.open"), new ImageIcon("resources/images/open.png"));
        recentMenu = new JMenu(resources.getString("file.recent"));
        saveMenuItem = new JMenuItem(resources.getString("file.save"), new ImageIcon("resources/images/save.png"));
        saveAllMenuItem = new JMenuItem(resources.getString("file.save_all"), new ImageIcon("resources/images/saveall.png"));
        saveAsMenuItem = new JMenuItem(resources.getString("file.save_as"), new ImageIcon("resources/images/saveas.png"));
        printMenuItem = new JMenuItem(resources.getString("file.print"), new ImageIcon("resources/images/print.png"));
        optionsMenuItem = new JMenuItem(resources.getString("file.options"), new ImageIcon("resources/images/options.png"));
        closeMenuItem = new JMenuItem(resources.getString("file.close_file"), new ImageIcon("resources/images/close.png"));
        exitMenuItem = new JMenuItem(resources.getString("file.exit"), new ImageIcon("resources/images/quit.png"));
        // Initialize edit attributes
        editMenu = new JMenu(resources.getString("menu.edit"));
        undoMenuItem = new JMenuItem(resources.getString("edit.undo"), new ImageIcon("resources/images/undo.png"));
        redoMenuItem = new JMenuItem(resources.getString("edit.redo"), new ImageIcon("resources/images/redo.png"));
        cutMenuItem = new JMenuItem(resources.getString("edit.cut"), new ImageIcon("resources/images/cut.png"));
        copyMenuItem = new JMenuItem(resources.getString("edit.copy"), new ImageIcon("resources/images/copy.png"));
        pasteMenuItem = new JMenuItem(resources.getString("edit.paste"), new ImageIcon("resources/images/paste.png"));
        deleteMenuItem = new JMenuItem(resources.getString("edit.delete"), new ImageIcon("resources/images/delete.png"));
        selectAllMenuItem = new JMenuItem(resources.getString("edit.select_all"), new ImageIcon("resources/images/selectall.png"));
        toUpperCaseMenuItem = new JMenuItem(resources.getString("edit.to_upper_case"), new ImageIcon("resources/images/up.png"));
        toLowerCaseMenuItem = new JMenuItem(resources.getString("edit.to_lower_case"), new ImageIcon("resources/images/down.png"));
        invertCaseMenuItem = new JMenuItem(resources.getString("edit.invert_case"), new ImageIcon("resources/images/refresh.png"));
        // Initialize search attributes
        searchMenu = new JMenu(resources.getString("menu.search"));
        findMenuItem = new JMenuItem(resources.getString("search.find"), new ImageIcon("resources/images/find.png"));
        findNextMenuItem = new JMenuItem(resources.getString("search.find_next"), new ImageIcon("resources/images/findnext.png"));
        replaceMenuItem = new JMenuItem(resources.getString("search.replace"), new ImageIcon("resources/images/replace.png"));
        gotoMenuItem = new JMenuItem(resources.getString("search.go_to"), new ImageIcon("resources/images/goto.png"));
        // Initialize insert attributes
        insertMenu = new JMenu(resources.getString("menu.insert"));
        classMenuItem = new JMenuItem(resources.getString("insert.class"), new ImageIcon("resources/images/lightning_add.png"));
        interfaceMenuItem = new JMenuItem(resources.getString("insert.interface"), new ImageIcon("resources/images/lightning_add.png"));
        enumMenuItem = new JMenuItem(resources.getString("insert.enum"), new ImageIcon("resources/images/lightning_add.png"));
        annotationMenuItem = new JMenuItem(resources.getString("insert.annotation"), new ImageIcon("resources/images/lightning_add.png"));
        constructorMenuItem = new JMenuItem(resources.getString("insert.constructor"), new ImageIcon("resources/images/lightning_add.png"));
        constructorWithArgsMenuItem = new JMenuItem(resources.getString("insert.constructor_with_args"), new ImageIcon(
                "resources/images/brick_add.png"));
        mainMenuItem = new JMenuItem(resources.getString("insert.main"), new ImageIcon("resources/images/lightning_add.png"));
        javaBeanPropertyMenuItem = new JMenuItem(resources.getString("insert.javabean_property"), new ImageIcon(
                "resources/images/brick_add.png"));
        constantMenuItem = new JMenuItem(resources.getString("insert.constant"), new ImageIcon("resources/images/brick_add.png"));
        singletonMenuItem = new JMenuItem(resources.getString("insert.singleton"), new ImageIcon("resources/images/lightning_add.png"));
        ifMenuItem = new JMenuItem(resources.getString("insert.if"), new ImageIcon("resources/images/lightning_add.png"));
        switchMenuItem = new JMenuItem(resources.getString("insert.switch"), new ImageIcon("resources/images/lightning_add.png"));
        forMenuItem = new JMenuItem(resources.getString("insert.for"), new ImageIcon("resources/images/lightning_add.png"));
        whileMenuItem = new JMenuItem(resources.getString("insert.while"), new ImageIcon("resources/images/lightning_add.png"));
        doWhileMenuItem = new JMenuItem(resources.getString("insert.do_while"), new ImageIcon("resources/images/lightning_add.png"));
        forEachMenuItem = new JMenuItem(resources.getString("insert.for_each"), new ImageIcon("resources/images/lightning_add.png"));
        tryCatchMenuItem = new JMenuItem(resources.getString("insert.try_catch"), new ImageIcon("resources/images/lightning_add.png"));
        roundBracketsMenuItem = new JMenuItem(resources.getString("insert.round_brackets"), new ImageIcon(
                "resources/images/lightning_add.png"));
        squareBracketsMenuItem = new JMenuItem(resources.getString("insert.square_brackets"), new ImageIcon(
                "resources/images/lightning_add.png"));
        curlyBracesMenuItem = new JMenuItem(resources.getString("insert.curly_braces"), new ImageIcon("resources/images/lightning_add.png"));
        systemOutMenuItem = new JMenuItem(resources.getString("insert.system_out"), new ImageIcon("resources/images/lightning_add.png"));
        /*
         * listMenuItem = new JMenuItem(resources.getString("insert.list"), new
         * ImageIcon( "resources/images/brick_add.png")); mapMenuItem = new
         * JMenuItem(resources.getString("insert.map"), new ImageIcon(
         * "resources/images/brick_add.png")); setMenuItem = new
         * JMenuItem(resources.getString("insert.set"), new ImageIcon(
         * "resources/images/brick_add.png"));
         */
        commentMenuItem = new JMenuItem(resources.getString("insert.comment"), new ImageIcon("resources/images/comment_selection.png"));
        // Initialize view attributes
        viewMenu = new JMenu(resources.getString("menu.view"));
        nextFileMenuItem = new JMenuItem(resources.getString("view.next_file"), new ImageIcon("resources/images/next_file.png"));
        previousFileMenuItem = new JMenuItem(resources.getString("view.previous_file"), new ImageIcon("resources/images/previous_file.png"));
        toolbarMenuItem = new JCheckBoxMenuItem(resources.getString("view.toolbar"), new ImageIcon("resources/images/Blank.gif"), true);
        statusbarMenuItem = new JCheckBoxMenuItem(resources.getString("view.statusbar"), new ImageIcon("resources/images/Blank.gif"), true);
        rowNumberMenuItem = new JCheckBoxMenuItem(resources.getString("view.row_number"), new ImageIcon("resources/images/Blank.gif"), true);
        // lookAndFeelMenu = new
        // JMenu(resources.getString("view.look_and_feel"));
        // styleGroup = new ButtonGroup();
        // Initialize project attributes
        projectMenu = new JMenu(resources.getString("menu.project"));
        newProjectMenuItem = new JMenuItem(resources.getString("project.new"), new ImageIcon("resources/images/new.png"));
        openProjectMenuItem = new JMenuItem(resources.getString("project.open"), new ImageIcon("resources/images/open.png"));
        recentProjectMenuItem = new JMenu(resources.getString("project.recent"));
        saveProjectMenuItem = new JMenuItem(resources.getString("project.save"), new ImageIcon("resources/images/save.png"));
        saveAsProjectMenuItem = new JMenuItem(resources.getString("project.save_as"), new ImageIcon("resources/images/saveas.png"));
        addFileMenuItem = new JMenuItem(resources.getString("project.add_file"), new ImageIcon("resources/images/new.png"));
        removeFileMenuItem = new JMenuItem(resources.getString("project.remove_file"), new ImageIcon("resources/images/Remove.gif"));
        projectPropertiesMenuItem = new JMenuItem(resources.getString("project.properties"), new ImageIcon("resources/images/Options.gif"));
        closeProjectMenuItem = new JMenuItem(resources.getString("project.close"), new ImageIcon("resources/images/Blank.gif"));
        // Initialize build attributes
        buildMenu = new JMenu(resources.getString("menu.build"));
        workDirectoryMenuItem = new JMenuItem(resources.getString("build.work_directory"), new ImageIcon("resources/images/folder.png"));
        // setAsMainMenuItem = new JMenuItem(resources
        // .getString("build.set_as_main"), new ImageIcon(
        // "resources/images/Blank.gif"));
        compileMenuItem = new JMenuItem(resources.getString("build.compile"), new ImageIcon("resources/images/compile.png"));
        /*
         * compileWithArgsMenuItem = new
         * JMenuItem(resources.getString("build.compile_with_args"), new
         * ImageIcon("resources/images/Blank.gif"));
         */
        compileProjectMenuItem = new JMenuItem(resources.getString("build.compile_project"), new ImageIcon(
                "resources/images/compile_all.png"));
        /*
         * compileProjectWithArgsMenuItem = new JMenuItem(resources
         * .getString("build.compile_project_with_args"), new ImageIcon(
         * "resources/images/Blank.gif"));
         */
        executeMenuItem = new JMenuItem(resources.getString("build.execute"), new ImageIcon("resources/images/execute.png"));
        executeWithArgsMenuItem = new JMenuItem(resources.getString("build.execute_with_args"), new ImageIcon(
                "resources/images/execute_args.png"));
        stopProcessingMenuItem = new JMenuItem(resources.getString("build.stop_processing"), new ImageIcon("resources/images/stop.png"));
        // Initialize tools attributes
        toolsMenu = new JMenu(resources.getString("menu.tools"));
        alarmMenuItem = new JMenuItem(resources.getString("tools.alarm"), new ImageIcon("resources/images/clock.png"));
        showMemMenuItem = new JMenuItem(resources.getString("tools.show_memory"), new ImageIcon("resources/images/memory.png"));
        javaDocMenuItem = new JMenuItem(resources.getString("tools.javadoc"), new ImageIcon("resources/images/javadoc.png"));
        /*
         * makeJarMenuItem = new
         * JMenuItem(resources.getString("tools.make_jar"), new ImageIcon(
         * "resources/images/Blank.gif")); makeManifestMenuItem = new
         * JMenuItem(resources.getString("tools.make_manifest"), new
         * ImageIcon("resources/images/Blank.gif"));
         */
        formatCodeMenuItem = new JMenuItem(resources.getString("tools.format_code"), new ImageIcon("resources/images/format.png"));
        /*
         * commentSelectionMenuItem = new
         * JMenuItem(resources.getString("tools.comment_selection"), new
         * ImageIcon("resources/images/comment_selection.png"));
         */
        // Initialize help attributes
        helpMenu = new JMenu(resources.getString("menu.help"));
        /*
         * tipMenuItem = new JMenuItem(resources.getString("help.tip"), new
         * ImageIcon("resources/images/Blank.gif"));
         */
        contentsMenuItem = new JMenuItem(resources.getString("help.contents"), new ImageIcon("resources/images/contents.png"));
        showAPIDocsMenuItem = new JMenuItem(resources.getString("help.apidocs"), new ImageIcon("resources/images/javacup.png"));
        aboutMenuItem = new JMenuItem(resources.getString("help.about"), new ImageIcon("resources/images/about.png"));
        // Initialize visual attributes
        toolbar = new JToolBar();
        centerSplitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
        mainSplitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
        tabbedPane = new JTabbedPane(JTabbedPane.TOP);
        root = new DefaultMutableTreeNode("Directory");
        setEjeTree(new EJETree(root));
        messageArea = new EJEIOArea();
        statusbar = EJEStatusBar.getStatusBar("EJE " + EJE_VERSION + " - Claudio De Sio Cesari");
        menuBar = new JMenuBar();
        setWorkDirectoryInFileDialog();
        // Initialize toolbar buttons attributes
        newButton = new JButton();
        openButton = new JButton();
        saveButton = new JButton();
        saveAllButton = new JButton();
        printButton = new JButton();
        undoButton = new JButton(new ImageIcon("resources/images/undo.png"));
        redoButton = new JButton(new ImageIcon("resources/images/redo.png"));
        cutButton = new JButton();
        copyButton = new JButton();
        pasteButton = new JButton();
        findButton = new JButton();
        previousFileButton = new JButton();
        nextFileButton = new JButton();
        compileButton = new JButton();
        compileAllButton = new JButton();
        executeButton = new JButton();
        stopProcessingButton = new JButton();
        alarmClockButton = new JButton();
        showMemButton = new JButton();
        formatButton = new JButton();
        commentButton = new JButton();
        showAPIDocsButton = new JButton();
        aboutButton = new JButton();
        runnableDocuments = new Vector<String>();
        runnableDocuments.addElement(resources.getString("build.current_file"));
        setAsMainCombo = new JComboBox(runnableDocuments);
        // Initialize some actions
        newAction = new NewAction();
        openAction = new OpenAction();
        saveAction = new SaveAction();
        saveAllAction = new SaveAllAction();
        cutAction = new CutAction();
        copyAction = new CopyAction();
        pasteAction = new PasteAction();
        tabHandler = new TabHandler();
        stopProcessingAction = new StopProcessingAction();
        alarmClockAction = new AlarmClockAction();
        // lookAndFeelAction = new LookAndFeelAction();
        // Initialize not visual attributes
        documents = new Vector<EJETab>(1, 1);
        searchFactory = SearchFactory.getSearchFactory();
        // Calling startup methods
        this.addDetails();
        this.setup();
        this.registerComponents();
        // Calling visualization methods
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        this.setVisible(true);
        this.setSize(new Dimension(800, 600));
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
    }

    private void setWorkDirectoryInFileDialog() {
        String workDirectory = System.getProperty("user.work_dir");
        if (workDirectory == null)
            fileDialog = new JavaFileChooser();
        else
            fileDialog = new JavaFileChooser(workDirectory);
    }

    // Build the GUI with visual components
    // ****************************************
    private void setup() {
        // setup of file menu
        fileMenu.add(newMenuItem);
        fileMenu.addSeparator();
        fileMenu.add(openMenuItem);
        fileMenu.add(recentMenu);
        fileMenu.addSeparator();
        fileMenu.add(saveMenuItem);
        fileMenu.add(saveAllMenuItem);
        fileMenu.add(saveAsMenuItem);
        fileMenu.addSeparator();
        fileMenu.add(printMenuItem);
        fileMenu.addSeparator();
        fileMenu.add(optionsMenuItem);
        fileMenu.addSeparator();
        fileMenu.add(closeMenuItem);
        fileMenu.addSeparator();
        fileMenu.add(exitMenuItem);
        // setup of edit men
        editMenu.add(undoMenuItem);
        editMenu.add(redoMenuItem);
        editMenu.addSeparator();
        editMenu.add(cutMenuItem);
        editMenu.add(copyMenuItem);
        editMenu.add(pasteMenuItem);
        editMenu.add(deleteMenuItem);
        editMenu.addSeparator();
        editMenu.add(selectAllMenuItem);
        editMenu.addSeparator();
        editMenu.add(toUpperCaseMenuItem);
        editMenu.add(toLowerCaseMenuItem);
        editMenu.add(invertCaseMenuItem);
        // setup of search menu
        searchMenu.add(findMenuItem);
        searchMenu.add(findNextMenuItem);
        searchMenu.add(replaceMenuItem);
        searchMenu.addSeparator();
        searchMenu.add(gotoMenuItem);
        // setup of insert menu
        insertMenu.add(classMenuItem);
        insertMenu.add(interfaceMenuItem);
        insertMenu.add(enumMenuItem);
        insertMenu.add(annotationMenuItem);
        insertMenu.addSeparator();
        insertMenu.add(constructorMenuItem);
        insertMenu.add(constructorWithArgsMenuItem);
        insertMenu.add(mainMenuItem);
        insertMenu.add(javaBeanPropertyMenuItem);
        insertMenu.add(constantMenuItem);
        insertMenu.add(singletonMenuItem);
        insertMenu.addSeparator();
        insertMenu.add(ifMenuItem);
        insertMenu.add(switchMenuItem);
        insertMenu.add(forMenuItem);
        insertMenu.add(whileMenuItem);
        insertMenu.add(doWhileMenuItem);
        insertMenu.add(forEachMenuItem);
        insertMenu.add(tryCatchMenuItem);
        insertMenu.addSeparator();
        insertMenu.add(roundBracketsMenuItem);
        insertMenu.add(squareBracketsMenuItem);
        insertMenu.add(curlyBracesMenuItem);
        insertMenu.addSeparator();
        insertMenu.add(systemOutMenuItem);
        /*
         * insertMenu.add(listMenuItem); insertMenu.add(mapMenuItem);
         * insertMenu.add(setMenuItem);
         */
        insertMenu.addSeparator();
        insertMenu.add(commentMenuItem);
        // setup of view menu
        viewMenu.add(nextFileMenuItem);
        viewMenu.add(previousFileMenuItem);
        viewMenu.addSeparator();
        viewMenu.add(toolbarMenuItem);
        viewMenu.add(statusbarMenuItem);
        // viewMenu.addSeparator();
        // viewMenu.add(lookAndFeelMenu);
        /*
         * UIManager.LookAndFeelInfo[] info = EJEOptionsDialog.getInstance()
         * .getLookAndFeelInfo(); for (int i = 0; i < info.length; i++) {
         * JRadioButtonMenuItem rbmi = new JRadioButtonMenuItem(info[i]
         * .getName(), info[i].getClassName().equals(ejeStyle) ? true : false);
         * lookAndFeelMenu.add(rbmi); styleGroup.add(rbmi);
         * rbmi.addActionListener(lookAndFeelAction); }
         */
        // setup of project menu
        projectMenu.add(newProjectMenuItem);
        projectMenu.addSeparator();
        projectMenu.add(openProjectMenuItem);
        projectMenu.add(recentProjectMenuItem);
        projectMenu.addSeparator();
        projectMenu.add(saveProjectMenuItem);
        projectMenu.add(saveAsProjectMenuItem);
        projectMenu.addSeparator();
        projectMenu.add(addFileMenuItem);
        projectMenu.add(removeFileMenuItem);
        projectMenu.add(projectPropertiesMenuItem);
        projectMenu.addSeparator();
        projectMenu.add(closeProjectMenuItem);
        // setup of build menu
        // buildMenu.add(setAsMainMenuItem);
        // buildMenu.addSeparator();
        buildMenu.add(workDirectoryMenuItem);
        buildMenu.addSeparator();
        buildMenu.add(compileMenuItem);
        // buildMenu.add(compileWithArgsMenuItem);
        buildMenu.add(compileProjectMenuItem);
        // buildMenu.add(compileProjectWithArgsMenuItem);
        buildMenu.addSeparator();
        buildMenu.add(executeMenuItem);
        buildMenu.add(executeWithArgsMenuItem);
        buildMenu.addSeparator();
        buildMenu.add(stopProcessingMenuItem);
        // setup of tools menu
        toolsMenu.add(alarmMenuItem);
        toolsMenu.add(showMemMenuItem);
        toolsMenu.addSeparator();
        toolsMenu.add(javaDocMenuItem);
        // toolsMenu.add(makeJarMenuItem);
        // toolsMenu.add(makeManifestMenuItem);
        toolsMenu.add(formatCodeMenuItem);
        /*
         * toolsMenu.addSeparator(); toolsMenu.add(commentSelectionMenuItem);
         */
        // setup of tools menu
        // helpMenu.add(tipMenuItem);
        helpMenu.add(contentsMenuItem);
        helpMenu.addSeparator();
        helpMenu.add(showAPIDocsMenuItem);
        helpMenu.addSeparator();
        helpMenu.add(aboutMenuItem);
        // setup of menu bar
        menuBar.add(fileMenu);
        menuBar.add(editMenu);
        menuBar.add(searchMenu);
        menuBar.add(insertMenu);
        menuBar.add(viewMenu);
        // menuBar.add(projectMenu);
        menuBar.add(buildMenu);
        menuBar.add(toolsMenu);
        menuBar.add(helpMenu);
        this.setupToolBar();
        this.setupRecentFiles();
        this.setJMenuBar(menuBar);
        JScrollPane scrollTree = new JScrollPane(getEjeTree());
        centerSplitPane.setLeftComponent(scrollTree);
        centerSplitPane.setRightComponent(tabbedPane);
        mainSplitPane.setTopComponent(centerSplitPane);
        JScrollPane scrollMessage = new JScrollPane(messageArea);
        mainSplitPane.setBottomComponent(scrollMessage);
        Dimension minimumSize = new Dimension(0, 0);
        scrollMessage.setMinimumSize(minimumSize);
        scrollTree.setMinimumSize(minimumSize);
        Container contentPane = this.getContentPane();
        contentPane.add(toolbar, BorderLayout.NORTH);
        contentPane.add(mainSplitPane, BorderLayout.CENTER);
        contentPane.add(statusbar, BorderLayout.SOUTH);
    }

    // set up toolbar
    // *************************************************************
    public void setupToolBar() {
        toolbar.add(newButton);
        toolbar.add(openButton);
        toolbar.add(new JLabel("", new ImageIcon("resources/images/separator.png"), JLabel.CENTER));
        toolbar.add(saveButton);
        toolbar.add(saveAllButton);
        toolbar.add(new JLabel("", new ImageIcon("resources/images/separator.png"), JLabel.CENTER));
        toolbar.add(printButton);
        toolbar.add(new JLabel("", new ImageIcon("resources/images/separator.png"), JLabel.CENTER));
        toolbar.add(undoButton);
        toolbar.add(redoButton);
        toolbar.add(new JLabel("", new ImageIcon("resources/images/separator.png"), JLabel.CENTER));
        toolbar.add(cutButton);
        toolbar.add(copyButton);
        toolbar.add(pasteButton);
        toolbar.add(new JLabel("", new ImageIcon("resources/images/separator.png"), JLabel.CENTER));
        toolbar.add(findButton);
        toolbar.add(new JLabel("", new ImageIcon("resources/images/separator.png"), JLabel.CENTER));
        toolbar.add(commentButton);
        toolbar.add(new JLabel("", new ImageIcon("resources/images/separator.png"), JLabel.CENTER));
        toolbar.add(previousFileButton);
        toolbar.add(nextFileButton);
        toolbar.add(new JLabel("", new ImageIcon("resources/images/separator.png"), JLabel.CENTER));
        toolbar.add(compileAllButton);
        toolbar.add(compileButton);
        toolbar.add(executeButton);
        toolbar.add(stopProcessingButton);
        toolbar.add(new JLabel("", new ImageIcon("resources/images/separator.png"), JLabel.CENTER));
        toolbar.add(alarmClockButton);
        toolbar.add(showMemButton);
        toolbar.add(formatButton);
        toolbar.add(new JLabel("", new ImageIcon("resources/images/separator.png"), JLabel.CENTER));
        toolbar.add(showAPIDocsButton);
        toolbar.add(aboutButton);
        toolbar.add(new JLabel("", new ImageIcon("resources/images/separator.png"), JLabel.CENTER));
        toolbar.add(new JLabel(" " + resources.getString("build.set_as_main.label")));
        toolbar.add(setAsMainCombo);
    }

    // Setup recent files
    // ****************************************************************
    protected void setupRecentFiles() {
        recentMenu.removeAll();
        ArrayList<String> keys = recentFiles.getKeys();
        Collections.sort(keys);
        int i = 0;
        for (Iterator<String> iter = keys.iterator(); iter.hasNext();) {
            String key = iter.next();
            JMenuItem recentMenuItem = new JMenuItem(++i + ". " + EJE.options.get(key));
            recentMenuItem.addActionListener(openRecentListener);
            recentMenu.add(recentMenuItem);
        }
    }

    // Add details
    // ****************************************************************
    private void addDetails() {
        this.setIconImage(getToolkit().getImage("resources/images/eje.png"));
        this.setTitle(/* resources.getString("eje.no_project") + */" - EJE " + EJE_VERSION + " -");
        tabbedPane.setOpaque(true);
        fileMenu.setMnemonic(KeyEvent.VK_F);
        newMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, Event.CTRL_MASK));
        openMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, Event.CTRL_MASK));
        saveMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, Event.CTRL_MASK));
        saveAllMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, Event.CTRL_MASK + InputEvent.SHIFT_MASK));
        printMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, Event.CTRL_MASK));
        optionsMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F12, 0));
        closeMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, Event.CTRL_MASK + InputEvent.SHIFT_MASK));
        exitMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, Event.CTRL_MASK));
        editMenu.setMnemonic(KeyEvent.VK_E);
        undoMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Z, Event.CTRL_MASK));
        redoMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Y, Event.CTRL_MASK));
        cutMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, Event.CTRL_MASK));
        copyMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, Event.CTRL_MASK));
        pasteMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V, Event.CTRL_MASK));
        deleteMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_H, Event.CTRL_MASK));
        selectAllMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, Event.CTRL_MASK));
        toUpperCaseMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_U, Event.CTRL_MASK));
        toLowerCaseMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L, Event.CTRL_MASK));
        invertCaseMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_J, Event.CTRL_MASK));
        searchMenu.setMnemonic(KeyEvent.VK_S);
        findMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F, Event.CTRL_MASK));
        findNextMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F3, 0));
        replaceMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R, Event.CTRL_MASK));
        gotoMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_G, Event.CTRL_MASK));
        insertMenu.setMnemonic(KeyEvent.VK_I);
        classMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_0, Event.CTRL_MASK));
        interfaceMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_1, Event.CTRL_MASK));
        enumMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_2, Event.CTRL_MASK));
        annotationMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_3, Event.CTRL_MASK));
        constructorMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_4, Event.CTRL_MASK));
        constructorWithArgsMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_5, Event.CTRL_MASK));
        mainMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_6, Event.CTRL_MASK));
        javaBeanPropertyMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_7, Event.CTRL_MASK));
        constantMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_8, Event.CTRL_MASK));
        singletonMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_9, Event.CTRL_MASK));
        ifMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F1, Event.CTRL_MASK));
        switchMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F2, Event.CTRL_MASK));
        forMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F3, Event.CTRL_MASK));
        whileMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F4, Event.CTRL_MASK));
        doWhileMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F5, Event.CTRL_MASK));
        forEachMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F6, Event.CTRL_MASK));
        tryCatchMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F7, Event.CTRL_MASK));
        roundBracketsMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F8, Event.CTRL_MASK));
        squareBracketsMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F9, Event.CTRL_MASK));
        curlyBracesMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F10, Event.CTRL_MASK));
        systemOutMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F11, Event.CTRL_MASK));
        commentMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F12, Event.CTRL_MASK));
        viewMenu.setMnemonic(KeyEvent.VK_V);
        nextFileMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F5, 0));
        previousFileMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F4, 0));
        projectMenu.setMnemonic(KeyEvent.VK_P);
        buildMenu.setMnemonic(KeyEvent.VK_B);
        compileMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F7, 0));
        compileProjectMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F7, Event.SHIFT_MASK));
        executeMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F9, 0));
        executeWithArgsMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F9, Event.SHIFT_MASK));
        stopProcessingMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0));
        toolsMenu.setMnemonic(KeyEvent.VK_T);
        formatCodeMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F, Event.CTRL_MASK + InputEvent.SHIFT_MASK));
        helpMenu.setMnemonic(KeyEvent.VK_H);
        contentsMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F1, 0));
        showAPIDocsMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F2, 0));
        aboutMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F11, 0));
        centerSplitPane.setOneTouchExpandable(true);
        mainSplitPane.setOneTouchExpandable(true);
        toolbar.setRollover(true);
        fileDialog.setFileView(JavaFileView.getInstance());
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension dimension = toolkit.getScreenSize();
        centerSplitPane.setDividerLocation((int) (dimension.height * 0.2D));
        mainSplitPane.setDividerLocation((int) (dimension.height * 0.7D));
        undoButton.setEnabled(false);
        redoButton.setEnabled(false);
    }

    // Adds the listeners
    // *********************************************************
    private void registerComponents() {
        JavaDocAction javaDocAction = new JavaDocAction();
        WorkDirectoryAction workDirectoryAction = new WorkDirectoryAction();
        CompileAction compileAction = new CompileAction();
        CompileProjectAction compileAllAction = new CompileProjectAction();
        ExecuteAction executeAction = new ExecuteAction();
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent evt) {
                exitActionPerformed();
            }
        });
        tabbedPane.addChangeListener(tabHandler);
        newMenuItem.addActionListener(newAction);
        openMenuItem.addActionListener(openAction);
        saveMenuItem.addActionListener(saveAction);
        saveAllMenuItem.addActionListener(new SaveAllAction());
        saveAsMenuItem.addActionListener(new SaveAsAction());
        printMenuItem.addActionListener(printAction);
        optionsMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                EJEOptionsDialog optionsDialog = EJEOptionsDialog.getInstance();
                optionsDialog.setLocationRelativeTo(EJE.this);
                optionsDialog.setVisible(true);
            }
        });
        closeMenuItem.addActionListener(closeAction);
        exitMenuItem.addActionListener(exitAction);
        // PS: Undo & Redo handler will be added on the air by TabHandler
        selectAllMenuItem.addActionListener(new SelectAllAction());
        toUpperCaseMenuItem.addActionListener(new ToUpperCaseAction());
        toLowerCaseMenuItem.addActionListener(new ToLowerCaseAction());
        invertCaseMenuItem.addActionListener(new InvertCaseAction());
        cutMenuItem.addActionListener(cutAction);
        copyMenuItem.addActionListener(copyAction);
        pasteMenuItem.addActionListener(pasteAction);
        deleteMenuItem.addActionListener(new DeleteAction());
        findMenuItem.addActionListener(searchMenuAction);
        findNextMenuItem.addActionListener(searchMenuAction);
        replaceMenuItem.addActionListener(searchMenuAction);
        gotoMenuItem.addActionListener(searchMenuAction);
        toolbarMenuItem.addActionListener(viewAction);
        statusbarMenuItem.addActionListener(viewAction);
        // rowNumberMenuItem.addActionListener(viewAction);
        // javaMenuItem.addActionListener(lookAndFeelAction);
        // windowsMenuItem.addActionListener(lookAndFeelAction);
        // motifMenuItem.addActionListener(lookAndFeelAction);
        classMenuItem.addActionListener(insertAction);
        interfaceMenuItem.addActionListener(insertAction);
        enumMenuItem.addActionListener(insertAction);
        annotationMenuItem.addActionListener(insertAction);
        constructorMenuItem.addActionListener(insertAction);
        constructorWithArgsMenuItem.addActionListener(insertAction);
        mainMenuItem.addActionListener(insertAction);
        javaBeanPropertyMenuItem.addActionListener(insertAction);
        constantMenuItem.addActionListener(insertAction);
        singletonMenuItem.addActionListener(insertAction);
        ifMenuItem.addActionListener(insertAction);
        switchMenuItem.addActionListener(insertAction);
        forMenuItem.addActionListener(insertAction);
        whileMenuItem.addActionListener(insertAction);
        doWhileMenuItem.addActionListener(insertAction);
        forEachMenuItem.addActionListener(insertAction);
        tryCatchMenuItem.addActionListener(insertAction);
        roundBracketsMenuItem.addActionListener(insertAction);
        squareBracketsMenuItem.addActionListener(insertAction);
        curlyBracesMenuItem.addActionListener(insertAction);
        systemOutMenuItem.addActionListener(insertAction);
        commentMenuItem.addActionListener(insertAction);
        /*
         * javadocCommentMenuItem.addActionListener(insertAction);
         * infoCommentMenuItem.addActionListener(insertAction);
         * licenseMenuItem.addActionListener(insertAction);
         */
        previousFileMenuItem.addActionListener(previousFileAction);
        nextFileMenuItem.addActionListener(nextFileAction);
        workDirectoryMenuItem.addActionListener(workDirectoryAction);
        ejeTree.getEjeTreePopupMenu().getWorkDirectoryMenuItem().addActionListener(workDirectoryAction);
        compileMenuItem.addActionListener(compileAction);
        compileProjectMenuItem.addActionListener(compileAllAction);
        executeMenuItem.addActionListener(executeAction);
        executeWithArgsMenuItem.addActionListener(new ExecuteWithArgsAction());
        stopProcessingMenuItem.addActionListener(stopProcessingAction);
        alarmMenuItem.addActionListener(alarmClockAction);
        /* commentSelectionMenuItem.addActionListener(commentSelectionAction); */
        showMemMenuItem.addActionListener(showMemAction);
        javaDocMenuItem.addActionListener(javaDocAction);
        formatCodeMenuItem.addActionListener(formatCodeAction);
        contentsMenuItem.addActionListener(contentsAction);
        showAPIDocsMenuItem.addActionListener(showAPIDocsAction);
        aboutMenuItem.addActionListener(aboutAction);
        newButton.setAction(newAction);
        openButton.setAction(openAction);
        saveButton.setAction(saveAction);
        saveAllButton.setAction(saveAllAction);
        printButton.setAction(printAction);
        cutButton.setAction(cutAction);
        copyButton.setAction(copyAction);
        pasteButton.setAction(pasteAction);
        findButton.setAction(searchMenuAction);
        compileAllButton.setAction(compileAllAction);
        compileButton.setAction(compileAction);
        executeButton.setAction(executeAction);
        stopProcessingButton.setAction(stopProcessingAction);
        alarmClockButton.setAction(alarmClockAction);
        commentButton.setAction(insertAction);
        previousFileButton.setAction(previousFileAction);
        nextFileButton.setAction(nextFileAction);
        showMemButton.setAction(showMemAction);
        formatButton.setAction(formatCodeAction);
        showAPIDocsButton.setAction(showAPIDocsAction);
        aboutButton.setAction(aboutAction);
    }

    // Handler for tab selection
    // **************************************************
    public class TabHandler implements ChangeListener {
        @Override
        public void stateChanged(ChangeEvent e) {
            setEjeTab((EJETab) (((JTabbedPane) e.getSource()).getSelectedComponent()));
            if (getEjeTab() == null)
                return;
            // ///////////////////////////////////////////////////////////////////////
            tabbedPane.addMouseListener(getEjeTab().areaListener);
            tabbedPane.addMouseListener(tabListener);
            // ///////////////////////////////////////////////////////////////////////
            updateSaveFileState(getEjeTab());
            updateSaveAllFilesState();
            getEjeTab().takeStatusBar();
            getEjeTab().getTextArea().requestFocus();
            try {
                undoMenuItem.removeActionListener(undoMenuItem.getActionListeners()[0]);
                redoMenuItem.removeActionListener(redoMenuItem.getActionListeners()[0]);
            } catch (ArrayIndexOutOfBoundsException exc) {
                System.out.println("New tab");
            }
            undoMenuItem.addActionListener(getEjeTab().getUndoAction());
            redoMenuItem.addActionListener(getEjeTab().getRedoAction());
            undoButton.setAction(getEjeTab().getUndoAction());
            redoButton.setAction(getEjeTab().getRedoAction());
        }
    }

    public MouseListener tabListener = new MouseAdapter() {
        private boolean maximized = false;

        @Override
        public void mouseClicked(MouseEvent e) {
            if (e.getClickCount() == 2) {
                if (!maximized) {
                    centerSplitPane.setDividerLocation(centerSplitPane.getMinimumDividerLocation());
                    mainSplitPane.setDividerLocation(mainSplitPane.getMaximumDividerLocation());
                    maximized = true;
                } else {
                    Toolkit toolkit = Toolkit.getDefaultToolkit();
                    Dimension dimension = toolkit.getScreenSize();
                    centerSplitPane.setDividerLocation((int) (dimension.height * 0.2D));
                    mainSplitPane.setDividerLocation((int) (dimension.height * 0.7D));
                    maximized = false;
                }
            }
        }
    };

    public void updateSaveAllFilesState() {
        if (this.getDirtyDocs().size() != 0) {
            saveAllButton.setEnabled(true);
            saveAllMenuItem.setEnabled(true);
        } else {
            saveAllButton.setEnabled(false);
            saveAllMenuItem.setEnabled(false);
        }
    }

    public void updateSaveFileState(EJETab ejeTab) {
        if (ejeTab.isDirty()) {
            saveButton.setEnabled(true);
            saveMenuItem.setEnabled(true);
        } else {
            saveButton.setEnabled(false);
            saveMenuItem.setEnabled(false);
        }
    }

    // show a warning for set the main class
    public void showSetAsMainDialogWarning() {
        JOptionPane.showMessageDialog(this, EJE.resources.getString("build.main.warning"),
                EJE.resources.getString("build.main.warning.title"), JOptionPane.WARNING_MESSAGE);
        setAsMainCombo.requestFocus();
    }

    // reload setAsMainCombo
    private void reloadSetAsMainCombo() {
        Object selection = setAsMainCombo.getSelectedItem();
        toolbar.remove(setAsMainCombo);
        setAsMainCombo = new JComboBox(runnableDocuments);
        toolbar.add(setAsMainCombo);
        setAsMainCombo.setSelectedItem(selection);
        toolbar.repaint();
    }

    // print messages
    // ************************************************************
    public void printMessage(String msg) {
        messageArea.setText(msg);
        messageArea.setCaretPosition(msg.length());
    }

    // Return a Vector of docs not saved
    // ******************************************
    public Vector<EJETab> getDirtyDocs() {
        Vector<EJETab> dirtyDocs = new Vector<EJETab>(1, 1);
        for (int i = 0; i < documents.size(); ++i) {
            if ((documents.elementAt(i)).isDirty()) {
                dirtyDocs.addElement(documents.elementAt(i));
            }
        }
        return dirtyDocs;
    }

    // Handler method for exit
    // ****************************************************
    private void exitActionPerformed() {
        final Vector<EJETab> dirtyDocs = this.getDirtyDocs();
        if (dirtyDocs.size() < 1)
            System.exit(1);
        final Object[] options = { new JButton(resources.getString("exit_dialog.save_all")),
                new JButton(resources.getString("exit_dialog.save_selected")), new JButton(resources.getString("exit_dialog.discard_all")),
                new JButton(resources.getString("exit_dialog.cancel")) };
        final JList list = new JList(dirtyDocs);
        int size = dirtyDocs.size();
        int[] indices = new int[size];
        for (int i = 0; i < size; i++) {
            indices[i] = i;
        }
        list.setSelectedIndices(indices);
        final JScrollPane scroll = new JScrollPane(list);
        final JDialog dialog = new JDialog(this, resources.getString("exit_dialog.title"), true);
        ActionListener optionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dialog.setVisible(false);
                Object source = e.getSource();
                if (source.equals(options[0])) {
                    for (int i = 0; i < dirtyDocs.size(); ++i) {
                        tabbedPane.setSelectedComponent(dirtyDocs.elementAt(i));
                        processSaveAction();
                    }
                    System.exit(1);
                } else if (source.equals(options[1])) {
                    Object[] selected = list.getSelectedValues();
                    for (int i = 0; i < selected.length; ++i) {
                        tabbedPane.setSelectedComponent((EJETab) selected[i]);
                        processSaveAction();
                    }
                    System.exit(1);
                } else if (source.equals(options[2]))
                    System.exit(1);
            }
        };
        JPanel panel = new JPanel();
        for (int i = 0; i < options.length; ++i) {
            ((JButton) options[i]).addActionListener(optionListener);
            panel.add((JButton) options[i]);
        }
        dialog.getContentPane().add(scroll, "Center");
        dialog.getContentPane().add(panel, "South");
        dialog.pack();
        dialog.setLocationRelativeTo(this);
        dialog.setVisible(true);
    }

    // Return the content pane
    // ****************************************************
    public Container getEditor() {
        return this.getContentPane();
    }

    // Return a file from a FileDialog
    // ********************************************
    public JavaFile getFile(int mode, String title) {
        int returnValue = 0;
        if (mode == JFileChooser.SAVE_DIALOG) {
            try {
                fileDialog.setSelectedFile(new File(ejeTab.getTextArea().popupListener.getClassName("\\bclass\\b")));
            } catch (BadLocationException e) {
                e.printStackTrace();
            } catch (NullPointerException e) {
                try {
                    fileDialog.setSelectedFile(new File(ejeTab.getTextArea().popupListener.getClassName("\\binterface\\b")));
                } catch (BadLocationException e1) {
                    e1.printStackTrace();
                } catch (NullPointerException e1) {
                    try {
                        fileDialog.setSelectedFile(new File(ejeTab.getTextArea().popupListener.getClassName("\\benum\\b")));
                    } catch (BadLocationException e2) {
                        e2.printStackTrace();
                    } catch (NullPointerException e2) {
                        try {
                            fileDialog.setSelectedFile(new File(ejeTab.getTextArea().popupListener.getClassName("\\b@interface\\b")));
                        } catch (BadLocationException e3) {
                            e3.printStackTrace();
                        } catch (NullPointerException e4) {
                            e4.printStackTrace();
                        }
                    }
                    e1.printStackTrace();
                }
                e.printStackTrace();
            }
            returnValue = fileDialog.showSaveDialog(this);
        } else
            returnValue = fileDialog.showOpenDialog(this);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileDialog.getSelectedFile();
            if (selectedFile == null)
                return null;
            String fileName = selectedFile.getName();
            if (fileName == null)
                return null;
            String directoryName = selectedFile.getParent();
            System.out.println("TEST: " + (mode == JFileChooser.SAVE_DIALOG));
            System.out.println(!FileValidator.isJavaFile(fileName));
            System.out.println(fileDialog.getFileFilter());
            System.out.println(JavaFilter.getJavaFilter());
            if (mode == JFileChooser.SAVE_DIALOG && !FileValidator.isJavaFile(fileName)
                    && (fileDialog.getFileFilter() == JavaFilter.getJavaFilter()))
                fileName += ".java";
            System.out.println("You choose this file: " + directoryName + "/" + fileName);
            return new JavaFile(directoryName, fileName);
        } else {
            System.out.println("Action aborted");
            return null;
        }
    }

    // Handler to save files
    // ******************************************************
    public boolean processSaveAction() {
        boolean cancelled = false;
        if (ejeTab.isNew()) {
            cancelled = saveFileAs();
            System.out.println("saved new file");
        } else {
            ejeTab.saveFile();
        }
        return cancelled;
    }

    public void saveAll() {
        Vector<EJETab> dirtyDocs = this.getDirtyDocs();
        System.out.println("Save all...");
        Component tabSelected = tabbedPane.getSelectedComponent();
        for (int i = 0; i < dirtyDocs.size(); ++i) {
            tabbedPane.setSelectedComponent(dirtyDocs.elementAt(i));
            processSaveAction();
        }
        tabbedPane.setSelectedComponent(tabSelected);
    }

    // Handler to save files as
    // ***************************************************
    public boolean saveFileAs() {
        JavaFile file = getFile(JFileChooser.SAVE_DIALOG, "Save " + ejeTab + " as...");
        if (file == null) {
            return true;
        }
        if (file.exists()) {
            String msg = resources.getString("save_dialog.confirm_msg");
            Object opts[] = { resources.getString("save_dialog.confirm_yes"), resources.getString("save_dialog.confirm_no") };
            JOptionPane pane = new JOptionPane(msg, JOptionPane.QUESTION_MESSAGE, JOptionPane.YES_NO_OPTION, null, opts);
            JDialog dialog = pane.createDialog(EJE.this, resources.getString("save_dialog.confirm_title"));
            dialog.setVisible(true);
            Object selectedValue = pane.getValue();
            if (selectedValue == null) {
                return true;
            }
            if (!selectedValue.equals(opts[0])) {
                saveFileAs();
                return true;
            }
        }
        ejeTab.setJavaFile(file);
        ejeTab.saveFile();
        EJE.recentFiles.add(file.getPath());
        EJE.updateProperties();
        updateTab();
        System.out.println("saved as");
        return false;
    }

    private void updateTab() {
        int index = tabbedPane.getSelectedIndex();
        String name = ejeTab.getName();
        String path = ejeTab.getPath();
        tabbedPane.setTitleAt(index, name);
        tabbedPane.setToolTipTextAt(index, path);
    }

    // Action implementations
    // *****************************************************
    // New action implementation
    // **************************************************
    class NewAction extends AbstractAction {
        private static final long serialVersionUID = -4284665080091235910L;

        NewAction() {
            super("", new ImageIcon("resources/images/new.png"));
            putValue(SHORT_DESCRIPTION, resources.getString("tooltip.new"));
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            processOpenAction(null);
        }
    }

    // Open action implementation
    // *************************************************
    class OpenAction extends AbstractAction {
        private static final long serialVersionUID = 8942402240056525662L;

        OpenAction() {
            super("", new ImageIcon("resources/images/open.png"));
            putValue(SHORT_DESCRIPTION, resources.getString("tooltip.open"));
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            JavaFile file = getFile(JFileChooser.OPEN_DIALOG, "Open a file...");
            if (file == null)
                return;
            if (file.exists())
                processOpenAction(file);
        }
    }

    // Open recent action implementation
    // *************************************************
    class OpenRecentListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JavaFile file = new JavaFile(e.getActionCommand().substring(3).trim());
            if (file == null)
                return;
            if (file.exists())
                processOpenAction(file);
        }
    };

    public void processOpenAction(JavaFile file) {
        EJETab ejeTab = null;
        if (file == null) {
            ejeTab = new EJETab(rowNumberMenuItem.isSelected());
        } else {
            int length = documents.size();
            for (int i = 0; i < length; i++) {
                ejeTab = documents.elementAt(i);
                if (file.equals(ejeTab.getJavaFile())) {
                    tabbedPane.setSelectedComponent(ejeTab);
                    return;
                }
            }
            ejeTab = new EJETab(file, rowNumberMenuItem.isSelected());
        }
        tabbedPane.addTab(ejeTab.getName(), null, ejeTab, ejeTab.getPath());
        // tabbedPane.addTab(ejeTab.getName(), null, ejeTab,
        // EJE.resources.getString("tooltip.tab"));
        documents.addElement(ejeTab);
        tabbedPane.setSelectedIndex(tabbedPane.getTabCount() - 1);
        String className = FileValidator.trunkSuffix(ejeTab.getJavaFile(true).getName());
        if (FileValidator.isExecutableFile(className) && !runnableDocuments.contains(className)) {
            runnableDocuments.addElement(className);
            reloadSetAsMainCombo();
        }
    }

    // Save action implementation
    // *************************************************
    class SaveAction extends AbstractAction {
        private static final long serialVersionUID = 6051724833234026143L;
        SaveAction() {
            super("", new ImageIcon("resources/images/save.png"));
            putValue(SHORT_DESCRIPTION, resources.getString("tooltip.save"));
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if (getEjeTab() == null)
                return;
            processSaveAction();
        }
    }

    // Save All action implementation
    // **********************************************
    class SaveAllAction extends AbstractAction {
        private static final long serialVersionUID = 1423645189218004360L;

        SaveAllAction() {
            super("", new ImageIcon("resources/images/saveall.png"));
            putValue(SHORT_DESCRIPTION, resources.getString("tooltip.save_all"));
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if (getEjeTab() == null)
                return;
            saveAll();
        }
    }

    // Save As action implementation
    // **********************************************
    class SaveAsAction extends AbstractAction {
        private static final long serialVersionUID = -6882216641246170159L;

        SaveAsAction() {
            super("", new ImageIcon("resources/images/SaveAs.gif"));
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if (getEjeTab() == null)
                return;
            saveFileAs();
        }
    }

    // Print action implementation
    // **********************************************
    AbstractAction printAction = new AbstractAction() {
        private static final long serialVersionUID = -4474680233797801750L;
        private int pageNumber;
        private PrintJob printJob;
        private PageFormat pf;
        private int x, y;
        {
            putValue(SMALL_ICON, new ImageIcon("resources/images/print.png"));
            putValue(SHORT_DESCRIPTION, resources.getString("tooltip.print"));
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if (ejeTab == null)
                return;
            pageNumber = 1;
            pf = new PageFormat();
            x = (int) pf.getImageableX();
            y = (int) pf.getImageableY();
            JobAttributes jobAttributes = new JobAttributes();
            PageAttributes pageAttributes = new PageAttributes();
            Toolkit toolkit = Toolkit.getDefaultToolkit();
            printJob = toolkit.getPrintJob(EJE.this, ejeTab.getName(), jobAttributes, pageAttributes);
            Graphics g = printJob.getGraphics();
            String line = null;
            try {
                BufferedReader br = new BufferedReader(new StringReader(ejeTab.getTextArea().getText()));
                while ((line = br.readLine()) != null) {
                    if (line.length() > 79) {
                        line = handleLongLine(g, line);
                    }
                    g.drawString(line, x, y);
                    if (y > 700) {
                        y = 750;
                        g.drawString(" # " + pageNumber, x + 200, y);
                        pageNumber++;
                        g = printJob.getGraphics();
                        y = (int) pf.getImageableY();
                    }
                    y += 20;
                }
                y = 750;
                g.drawString("# " + pageNumber, x + 200, y);
                br.close();
            } catch (IOException exc) {
                exc.printStackTrace();
            } finally {
                g.dispose();
                printJob.end();
            }
        }

        private String handleLongLine(Graphics g, String line) {
            String firstLine = line.substring(0, 79) + "§";
            String secondLine = line.substring(79);
            g.drawString(firstLine, x, y);
            y += 20;
            if (secondLine.length() > 80) {
                if (y > 700) {
                    y = 750;
                    g.drawString(" # " + pageNumber, x + 200, y);
                    pageNumber++;
                    g = printJob.getGraphics();
                    y = (int) pf.getImageableY();
                }
                handleLongLine(g, secondLine);
            }
            return secondLine;
        }
    };

    class EditorPage implements Printable {
        private int maxRow;

        public EditorPage(int maxRow) {
            this.maxRow = maxRow;
            System.out.println("maxRow" + maxRow);
        }

        @Override
        public int print(Graphics g, PageFormat pf, int pageIndex) {
            if (pageIndex > 0) {
                return Printable.NO_SUCH_PAGE;
            }
            Graphics2D g2d = (Graphics2D) g;
            Font font = new Font("Monospaced", Font.BOLD, 14);
            g2d.setFont(font);
            g2d.translate(pf.getImageableX(), pf.getImageableY());
            Element root = getEjeTab().getTextArea().getDocument().getDefaultRootElement();
            // int count = root.getElementCount();
            int increment = font.getSize();
            int minRow = maxRow - 45;
            for (int i = minRow; i < maxRow; i++) {
                Element row = root.getElement(i);
                try {
                    g2d.drawString(getEjeTab().getTextArea().getText(row.getStartOffset(), row.getEndOffset() - row.getStartOffset()), 0,
                            increment);
                    increment += font.getSize();
                } catch (BadLocationException e) {
                    e.printStackTrace();
                }
            }
            return Printable.PAGE_EXISTS;
        }
    }

    // Close action implementation
    // ************************************************
    AbstractAction closeAction = new AbstractAction() {
        private static final long serialVersionUID = 2843145986467663528L;

        @Override
        public void actionPerformed(ActionEvent e) {
            if (ejeTab == null)
                return;
            boolean canRemove = true;
            if (ejeTab.isDirty())
                canRemove = askForConfirmation();
            if (canRemove) {
                EJEOptionsDialog.getInstance().removeReloadable(ejeTab);
                String className = FileValidator.trunkSuffix(ejeTab.getJavaFile(true).getName());
                if (className.equals(setAsMainCombo.getSelectedItem())) {
                    setAsMainCombo.setSelectedIndex(0);
                }
                runnableDocuments.removeElement(className);
                reloadSetAsMainCombo();
                documents.removeElement(ejeTab);
                tabbedPane.remove(tabbedPane.getSelectedIndex());
                tabHandler.stateChanged(new ChangeEvent(tabbedPane));
                System.out.println("file closed");
            }
        }

        public boolean askForConfirmation() {
            int result = JOptionPane.showConfirmDialog(EJE.this, resources.getString("close_dialog.confirm_msg"),
                    resources.getString("close_dialog.confirm_title"), JOptionPane.YES_NO_CANCEL_OPTION);
            boolean canRemove = true;
            switch (result) {
            case JOptionPane.YES_OPTION:
                if (processSaveAction())
                    break;
            case JOptionPane.NO_OPTION:
                System.out.println("file closed & not saved");
                break;
            case JOptionPane.CANCEL_OPTION:
            case JOptionPane.CLOSED_OPTION:
                canRemove = false;
            }
            return canRemove;
        }
    };
    // Exit action implementation
    // *************************************************
    AbstractAction exitAction = new AbstractAction() {
        private static final long serialVersionUID = -6964498857167043541L;

        @Override
        public void actionPerformed(ActionEvent e) {
            // da rivedere dopo l'ejeTree
            exitActionPerformed();
        }
    };

    // Cut action implementation
    // **************************************************
    class CutAction extends AbstractAction {
        CutAction() {
            super("", new ImageIcon("resources/images/cut.png"));
            putValue(SHORT_DESCRIPTION, resources.getString("tooltip.cut"));
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if (getEjeTab() == null)
                return;
            getEjeTab().getTextArea().cut();
        }
    }

    // Copy action implementation
    // *************************************************
    class CopyAction extends AbstractAction {
        CopyAction() {
            super("", new ImageIcon("resources/images/copy.png"));
            putValue(SHORT_DESCRIPTION, resources.getString("tooltip.copy"));
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if (getEjeTab() == null)
                return;
            getEjeTab().getTextArea().copy();
        }
    }

    // Paste action implementation
    // ************************************************
    class PasteAction extends AbstractAction {
        private static final long serialVersionUID = 364201214555308167L;

        PasteAction() {
            super("", new ImageIcon("resources/images/paste.png"));
            putValue(SHORT_DESCRIPTION, resources.getString("tooltip.paste"));
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if (getEjeTab() == null)
                return;
            try {
                // Clipboard clipboard = getToolkit().getSystemClipboard();
                // Transferable clipboardContent = clipboard.getContents(this);
                // if ((clipboardContent != null)
                // &&
                // (clipboardContent.isDataFlavorSupported(DataFlavor.stringFlavor)))
                // {
                //
                // String tempString = (String)
                // clipboardContent.getTransferData(DataFlavor.stringFlavor);
                // // destinationText.setText (tempString);
                //
                //
                // ejeTab.textArea.replaceSelection(tempString);
                // }
                getEjeTab().getTextArea().paste();
                System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!");
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    // Delete action implementation
    // ***********************************************
    class DeleteAction extends AbstractAction {
        DeleteAction() {
            super("", new ImageIcon("resources/images/delete.png"));
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if (getEjeTab() == null)
                return;
            String selectedText = getEjeTab().getTextArea().getSelectedText();
            if (selectedText == null)
                return;
            getEjeTab().getTextArea().replaceSelection(null);
        }
    }

    // Select all action implementation
    // *******************************************
    class SelectAllAction extends AbstractAction {
        private static final long serialVersionUID = 6466939609206293894L;

        SelectAllAction() {
            super("select all", new ImageIcon("resources/images/selectall.png"));
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if (getEjeTab() == null)
                return;
            getEjeTab().getTextArea().selectAll();
        }
    }

    // To upper case action implementation
    // ****************************************
    class ToUpperCaseAction extends AbstractAction {
        private static final long serialVersionUID = 3159584257989944540L;

        ToUpperCaseAction() {
            super("", new ImageIcon("resources/images/up.png"));
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if (getEjeTab() == null)
                return;
            String selectedText = getEjeTab().getTextArea().getSelectedText();
            if (selectedText == null)
                return;
            getEjeTab().getTextArea().replaceSelection(selectedText.toUpperCase());
        }
    }

    // To lower case action implementation
    // ****************************************
    class ToLowerCaseAction extends AbstractAction {
        private static final long serialVersionUID = -5079680423077165436L;

        ToLowerCaseAction() {
            super("", new ImageIcon("resources/images/down.png"));
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if (getEjeTab() == null)
                return;
            String selectedText = getEjeTab().getTextArea().getSelectedText();
            if (selectedText == null)
                return;
            getEjeTab().getTextArea().replaceSelection(getEjeTab().getTextArea().getSelectedText().toLowerCase());
        }
    }

    // To lower case action implementation
    // ****************************************
    class InvertCaseAction extends AbstractAction {
        private static final long serialVersionUID = -6100642609903921884L;

        InvertCaseAction() {
            super("", new ImageIcon("resources/images/refresh.png"));
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if (getEjeTab() == null)
                return;
            String selectedText = getEjeTab().getTextArea().getSelectedText();
            if (selectedText == null)
                return;
            char[] charArray = selectedText.toCharArray();
            for (int i = 0; i < charArray.length; i++) {
                if (charArray[i] >= 65 && charArray[i] <= 90) {
                    charArray[i] = (charArray[i] += 32);
                } else if (charArray[i] >= 97 && charArray[i] <= 122) {
                    charArray[i] = (charArray[i] -= 32);
                }
            }
            getEjeTab().getTextArea().replaceSelection(new String(charArray));
        }
    }

    // Search menu actions implementation
    // ****************************************
    AbstractAction searchMenuAction = new AbstractAction() {
        private static final long serialVersionUID = -5242916811931416611L;
        {
            putValue(SMALL_ICON, new ImageIcon("resources/images/find.png"));
            putValue(SHORT_DESCRIPTION, resources.getString("tooltip.find"));
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if (ejeTab == null)
                return;
            String mode = null;
            Object source = e.getSource();
            if (source.equals(findMenuItem) || source.equals(findButton)) {
                mode = resources.getString("search_dialog.find_mode");
                searchDialog = searchFactory.getSearchDialog(EJE.this, ejeTab.getTextArea(), mode);
                searchDialog.setVisible(true);
            } else if (source.equals(replaceMenuItem)) {
                mode = resources.getString("search_dialog.replace_mode");
                searchDialog = searchFactory.getSearchDialog(EJE.this, ejeTab.getTextArea(), mode);
                searchDialog.setVisible(true);
            } else if (source.equals(findNextMenuItem)) {
                if (searchDialog == null)
                    return;
                mode = resources.getString("search_dialog.find_next_mode");
                try {
                    searchDialog.find();
                } catch (ClassCastException exc) {
                    ((ReplaceDialog) searchDialog).find();
                }
            } else if (source.equals(gotoMenuItem)) {
                mode = resources.getString("search_dialog.go_to_mode");
                searchDialog = searchFactory.getSearchDialog(EJE.this, ejeTab.getTextArea(), mode);
                searchDialog.setVisible(true);
            }
        }
    };
    // View actions implementation
    // ************************************************
    AbstractAction viewAction = new AbstractAction() {
        private static final long serialVersionUID = -4959646393674125135L;

        @Override
        public void actionPerformed(ActionEvent e) {
            boolean isSelected = false;
            Object source = e.getSource();
            if (source.equals(toolbarMenuItem)) {
                if (toolbarMenuItem.isSelected())
                    isSelected = true;
                toolbar.setVisible(isSelected);
            } else if (source.equals(statusbarMenuItem)) {
                if (statusbarMenuItem.isSelected())
                    isSelected = true;
                statusbar.setVisible(isSelected);
            } else if (source.equals(rowNumberMenuItem)) {
                if (rowNumberMenuItem.isSelected())
                    isSelected = true;
                for (int i = 0; i < documents.size(); ++i) {
                    // EJETab ejeTab = documents.elementAt(i);
                    // ejeTab.setRowNumberArea(isSelected);
                }
            }
        }
    };

    // LookAndFeel Action implementation
    // **********************************************
    /*
     * class LookAndFeelAction extends AbstractAction { public void
     * actionPerformed(ActionEvent e) { try { UIManager.LookAndFeelInfo[] info =
     * EJEOptionsDialog .getInstance().getLookAndFeelInfo(); for (int i = 0; i <
     * info.length; i++) { if (info[i].getName().equals(e.getActionCommand())) {
     * String className = info[i].getClassName(); System.out.println(className);
     * UIManager.setLookAndFeel(className);
     * SwingUtilities.updateComponentTreeUI(EJE.this);
     * EJE.properties.setProperty("eje.style", className); break; } }
     * saveProperties(); } catch (Exception exc) {
     * //printMessage(exc.toString()); JOptionPane.showMessageDialog(EJE.this,
     * exc.toString(), resources.getString("view.error.title"),
     * JOptionPane.ERROR_MESSAGE); } } }
     */
    // Choose work directory action implementation
    // *************************************************
    class WorkDirectoryAction extends AbstractAction {
        private static final long serialVersionUID = -6971088363029879544L;

        WorkDirectoryAction() {
            super("", new ImageIcon("resources/images/folder.png"));
            putValue(SHORT_DESCRIPTION, resources.getString("tooltip.work_dir"));
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            JFileChooser workDirectoryChooser = new JFileChooser();
            workDirectoryChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            int returnValue = workDirectoryChooser.showOpenDialog(EJE.this);
            if (returnValue == JFileChooser.APPROVE_OPTION) {
                File selectedFile = workDirectoryChooser.getSelectedFile();
                try {
                    String dirName = selectedFile.getCanonicalPath();
                    if (EJEUtils.isNotVisibleInEJETree(dirName)) {
                        String workDirValue = options.getProperty("user.work_dir");
                        String value = workDirValue + (EJEUtils.isEmpty(workDirValue) ? ";" : "") + dirName + ";";
                        options.setProperty("user.work_dir", value);
                        System.setProperty("user.work_dir", value);
                        getEjeTree().createUserDirNodes(root, "user.work_dir");
                        getEjeTree().updateUI();
                        setWorkDirectoryInFileDialog();
                        saveProperties();
                    }
                } catch (Exception exc) {
                    exc.printStackTrace();
                }
            }
        }
    }

    // Compile action implementation
    // **********************************************
    class CompileAction extends AbstractAction {
        private static final long serialVersionUID = -4711578170657603948L;

        CompileAction() {
            super("", new ImageIcon("resources/images/compile.png"));
            putValue(SHORT_DESCRIPTION, resources.getString("tooltip.compile"));
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if (getEjeTab() == null)
                return;
            try {
                jdkApplication = com.cdsc.eje.jdk.Compiler.getCompiler();
                if (jdkApplication.isProcessing()) {
                    EJEStatusBar.getStatusBar().changeColor(EJE.resources.getString("build.wait"));
                    return;
                }
                CompilableFile file = getEjeTab().getJavaFile();
                processCompileAction(file);
            } catch (Exception exc) {
                System.out.println(exc.toString());
            }
        }

        public synchronized void processCompileAction(CompilableFile compilableFile) {
            try {
                EJE.this.processSaveAction();
                jdkApplication.execute(ejeTab.getJavaFile());
            } catch (Exception exc) {
                System.out.println(exc.toString());
            }
        }
    }

    // TEMPORARY Compile All Compile Project action implementation
    // **********************************************
    class CompileProjectAction extends AbstractAction {
        private static final long serialVersionUID = -6223094678424369868L;

        CompileProjectAction() {
            super("", new ImageIcon("resources/images/compile_all.png"));
            putValue(SHORT_DESCRIPTION, resources.getString("tooltip.compile_all"));
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if (getEjeTab() == null)
                return;
            try {
                jdkApplication = Compiler.getCompiler();
                // Vector compilableFiles = new Vector(1,1);
                ProjectFile projectFile = new ProjectFile("project");
                CompilableFile file = null;
                for (int i = 0; i < documents.size(); ++i) {
                    file = (documents.elementAt(i)).getJavaFile();
                    projectFile.add(file);
                }
                saveAll();
                jdkApplication.execute(projectFile);
            } catch (Exception exc) {
                System.out.println(exc.toString());
            }
        }

        public synchronized void processCompileProjectAction(Vector<?> compilableFiles) {
            try {
                // refactoring .txt
            } catch (Exception exc) {
                System.out.println(exc.toString());
            }
        }
    }

    // Execute action implementation ****************************************
    class ExecuteAction extends AbstractAction {
        private static final long serialVersionUID = -3865716032622867097L;

        ExecuteAction() {
            super("", new ImageIcon("resources/images/execute.png"));
            putValue(SHORT_DESCRIPTION, resources.getString("tooltip.execute"));
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if (getEjeTab() == null)
                return;
            JavaFile file = null;
            jdkApplication = com.cdsc.eje.jdk.JVM.getJVM();
            if (jdkApplication.isProcessing()) {
                EJEStatusBar.getStatusBar().changeColor(EJE.resources.getString("build.wait"));
                return;
            }
            String className = (String) setAsMainCombo.getSelectedItem();
            if (className.equals(resources.getString("build.current_file"))) {
                file = getEjeTab().getJavaFile(true);
            } else {
                for (int i = 0; i < tabbedPane.getComponentCount(); i++) {
                    EJETab tmp = (EJETab) tabbedPane.getComponentAt(i);
                    JavaFile tmpFile = tmp.getJavaFile(true);
                    String tmpName = FileValidator.trunkSuffix(tmpFile.getName());
                    if (tmpName.equals(className)) {
                        file = tmpFile;
                    }
                }
            }
            synchronized (jdkApplication) {
                jdkApplication.execute(file);
            }
            messageArea.requestFocus();
        }
    }

    // Execute with args action implementation
    // ****************************************
    class ExecuteWithArgsAction extends AbstractAction {
        private static final long serialVersionUID = -1317526846168995189L;
        private String args[];
        ArrayList<String> argsTmp;

        ExecuteWithArgsAction() {
            super("", new ImageIcon("resources/images/execute_args.png"));
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if (getEjeTab() == null)
                return;
            try {
                jdkApplication = JVM.getJVM();
                if (jdkApplication.isProcessing()) {
                    EJEStatusBar.getStatusBar().changeColor(EJE.resources.getString("build.wait"));
                    return;
                }
                argsTmp = new ArrayList<String>();
                String input = JOptionPane.showInputDialog(EJE.resources.getString("args_dialog.args")).trim();
                int index = -1;
                try {
                    index = find(input);
                } catch (IndexOutOfBoundsException exc) {
                    exc.printStackTrace();
                    System.out.println("Niente virgolette");
                }
                setArgs(input, index);
                int size = argsTmp.size();
                args = new String[size];
                for (int i = 0; i < size; i++) {
                    args[i] = argsTmp.get(i);
                    args[i] = (args[i].replaceAll("\\\\\"", "\\\""));
                }
                JavaFile file = getEjeTab().getJavaFile(true);
                String className = (String) setAsMainCombo.getSelectedItem();
                if (className.equals(resources.getString("build.current_file"))) {
                    file = getEjeTab().getJavaFile(true);
                } else {
                    for (int i = 0; i < tabbedPane.getComponentCount(); i++) {
                        EJETab tmp = (EJETab) tabbedPane.getComponentAt(i);
                        JavaFile tmpFile = tmp.getJavaFile(true);
                        String tmpName = FileValidator.trunkSuffix(tmpFile.getName());
                        if (tmpName.equals(className)) {
                            file = tmpFile;
                        }
                    }
                }
                synchronized (jdkApplication) {
                    ((JVM) (jdkApplication)).execute(file, args);
                }
                messageArea.requestFocus();
            } catch (Exception exc) {
                System.out.println(exc);
            }
        }

        private void setArgs(String input, int index) {
            if (index != 0) {
                String inputToScan = input;
                if (index >= 0) {
                    inputToScan = input.substring(0, index);
                    fillArgs(inputToScan);
                    setArgs(input.substring(index), 0);
                    return;
                }
                fillArgs(inputToScan);
            } else {
                int index2 = -1;
                int index3 = -1;
                try {
                    index2 = find(input.substring(index + 1));
                } catch (IndexOutOfBoundsException e) {
                    e.printStackTrace();
                    JOptionPane.showMessageDialog(eje, resources.getString("stream.bad_args"));
                }
                if (index2 != -1) {
                    argsTmp.add(input.substring(index + 1, index2 + 1));
                    index3 = find(input.substring(index2 + 2));
                    setArgs(input.substring(index2 + 2), index3);
                } else {
                    fillArgs(input.substring(1));
                }
            }
        }

        private int find(String input) throws IndexOutOfBoundsException {
            int index2 = -1;
            if ((index2 = (input.indexOf("\""))) >= 0) {
                if ((index2 == 0 || !(("" + input.charAt(index2 - 1)).equals("\\")))) {
                    System.out.println("trovata virgoletta");
                    return index2;
                } else {
                    System.out.println("seconda virgoletta da stampare");
                    find(input.substring(index2 + 1));
                }
            } else {
                return -1;
            }
            return -1;
        }

        private void fillArgs(String inputToScan) {
            StringTokenizer tokenizer = new StringTokenizer(inputToScan, " ");
            while (tokenizer.hasMoreTokens()) {
                String token = tokenizer.nextToken();
                argsTmp.add(token);
            }
        }
    }

    // Execute action implementation ****************************************
    class StopProcessingAction extends AbstractAction {
        private static final long serialVersionUID = 3179839485802627944L;

        StopProcessingAction() {
            super("", new ImageIcon("resources/images/stop.png"));
            putValue(SHORT_DESCRIPTION, resources.getString("tooltip.stop_processing"));
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if (getEjeTab() == null)
                return;
            try {
                jdkApplication.stopProcessing();
            } catch (Exception exc) {
                System.out.println(exc);
            }
        }
    }

    // Insert action implementation
    // **********************************************
    AbstractAction insertAction = new AbstractAction() {
        private static final long serialVersionUID = 5039811976534584375L;
        {
            putValue(SMALL_ICON, new ImageIcon("resources/images/comment_selection.png"));
            putValue(SHORT_DESCRIPTION, resources.getString("tooltip.comment_selection"));
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if (ejeTab == null)
                return;
            String selectedText = ejeTab.getTextArea().getSelectedText();
            int backsToReturn = 0;
            int gap = 0;
            if (selectedText == null)
                selectedText = "";
            else
                selectedText = selectedText.trim();
            String newText = "/* " + selectedText + " */";
            backsToReturn = 3 + selectedText.length();
            try {
                if (e.getSource().equals(javaBeanPropertyMenuItem)) {
                    showJavaBeanPropertyDialog();
                    return;
                } else if (e.getSource().equals(mainMenuItem)) {
                    newText = "public static void main(String args[]) {\n        " + selectedText + "\n    }";
                    backsToReturn = 6 + selectedText.length();
                } else if (e.getSource().equals(classMenuItem)) {
                    newText = "public class MyClass {\n    " + selectedText + "\n}";
                    backsToReturn = 2 + selectedText.length();
                } else if (e.getSource().equals(interfaceMenuItem)) {
                    newText = "public interface MyInterface {\n    " + selectedText + "\n}";
                    backsToReturn = 2 + selectedText.length();
                } else if (e.getSource().equals(enumMenuItem)) {
                    newText = "public enum MyEnum {\n    " + selectedText + "\n}";
                    backsToReturn = 2 + selectedText.length();
                } else if (e.getSource().equals(annotationMenuItem)) {
                    newText = "import java.lang.annotation.*;\n\n" + "@Retention(RetentionPolicy.RUNTIME)\n@Target(ElementType.TYPE)\n"
                            + "@Inherited\n@Documented\npublic @interface MyAnnotation {\n    " + selectedText + "\n}";
                    backsToReturn = 2 + selectedText.length();
                } else if (e.getSource().equals(constructorMenuItem)) {
                    String className = ejeTab.getTextArea().popupListener.getClassName("\\bclass\\b");
                    if (className == null) {
                        className = "ClassName";
                    }
                    newText = "public " + className + " (){\n        " + selectedText + "\n    }";
                    backsToReturn = 6 + selectedText.length();
                    gap = selectedText.length();
                } else if (e.getSource().equals(constructorWithArgsMenuItem)) {
                    String arguments = JOptionPane.showInputDialog(EJE.resources.getString("constructor_with_args_dialog.message_type"));
                    if (arguments == null)
                        return;
                    String className = ejeTab.getTextArea().popupListener.getClassName("\\bclass\\b");
                    if (className == null) {
                        className = "ClassName";
                        backsToReturn = 6 + selectedText.length();
                        gap = selectedText.length();
                    }
                    newText = "public " + className + " (" + arguments + "){\n        " + selectedText + "\n    }";
                    backsToReturn = 6 + selectedText.length();
                    gap = selectedText.length();
                } else if (e.getSource().equals(constantMenuItem)) {
                    String constantType = JOptionPane.showInputDialog(EJE.resources.getString("constant_dialog.message_type"));
                    if (constantType == null || constantType.equals(""))
                        return;
                    String constantName = JOptionPane.showInputDialog(EJE.resources.getString("constant_dialog.message_identifier"));
                    if (constantName == null)
                        return;
                    newText = "public final static " + constantType + " " + constantName + ";\n    ";
                    backsToReturn = 0;
                    gap = 0;
                } else if (e.getSource().equals(singletonMenuItem)) {
                    String className = ejeTab.getTextArea().popupListener.getClassName("\\bclass\\b");
                    if (className == null) {
                        className = "ClassName";
                    }
                    newText = "private static " + className + " instance;\n\n" + "    private " + className + " (){\n" + "    }\n\n"
                            + "    public static " + className + " getInstance(){\n" + "        if (instance == null) {\n"
                            + "            instance = new " + className + "();\n" + "        }\n" + "        return instance;\n"
                            + "    }\n    ";
                    backsToReturn = 0;
                    gap = 0;
                } else if (e.getSource().equals(forEachMenuItem)) {
                    newText = "for (Object object : objects) {\n            " + selectedText + "\n        }";
                    backsToReturn = 33 + selectedText.length();
                    gap = 7;
                } else if (e.getSource().equals(systemOutMenuItem)) {
                    newText = "System.out.println(" + selectedText + ");";
                    backsToReturn = 2 + selectedText.length();
                    gap = selectedText.length();
                } /*
                   * else if (e.getSource().equals(listMenuItem)) {
                   *
                   * } else if (e.getSource().equals(mapMenuItem)) { // TODO }
                   * else if (e.getSource().equals(setMenuItem)) { // TODO }
                   */else if (e.getSource().equals(ifMenuItem)) {
                    newText = "if (EXPR) {\n            " + selectedText + "\n        }";
                    backsToReturn = 30 + selectedText.length();
                    gap = 4;
                } else if (e.getSource().equals(switchMenuItem)) {
                    newText = "switch (VAR) {\n            case 1:\n                " + selectedText
                            + "\n            break;\n            default:\n                \n        }";
                    backsToReturn = 110 + selectedText.length();
                    gap = 3;
                } else if (e.getSource().equals(forMenuItem)) {
                    newText = "for (int i = 0; i < VAR; i++) {\n           " + selectedText + "\n        }";
                    backsToReturn = 33 + selectedText.length();
                    gap = 3;
                } else if (e.getSource().equals(whileMenuItem)) {
                    newText = "while (COND) {\n            " + selectedText + "\n        }";
                    backsToReturn = 30 + selectedText.length();
                    gap = 4;
                } else if (e.getSource().equals(doWhileMenuItem)) {
                    newText = "do {\n            " + selectedText + "\n        } while(COND);";
                    backsToReturn = 6;
                    gap = 4;
                } else if (e.getSource().equals(tryCatchMenuItem)) {
                    newText = "try {\n            " + selectedText
                            + "\n        }\n        catch (Exception exc) {\n            exc.printStackTrace();\n        }";
                    backsToReturn = 87 + selectedText.length();
                } else if (e.getSource().equals(roundBracketsMenuItem)) {
                    newText = "(" + selectedText + ")";
                    backsToReturn = 1 + selectedText.length();
                } else if (e.getSource().equals(squareBracketsMenuItem)) {
                    newText = "[" + selectedText + "]";
                    backsToReturn = 1 + selectedText.length();
                } else if (e.getSource().equals(curlyBracesMenuItem)) {
                    newText = "{" + selectedText + "}";
                    backsToReturn = 1 + selectedText.length();
                }
                // else //if (e.getSource().equals(commentMenuItem))
                ejeTab.getTextArea().replaceSelection(newText);
                int position = ejeTab.getTextArea().getCaretPosition() - backsToReturn;
                ejeTab.getTextArea().select(position, position + gap);
            } catch (Exception exc) {
                System.out.println(exc);
            }
        }

        private void showJavaBeanPropertyDialog() throws Exception {
            String type = JOptionPane.showInputDialog(EJE.resources.getString("javabean_dialog.message_type"));
            if (type == null || type.equals(""))
                return;
            String identifier = JOptionPane.showInputDialog(EJE.resources.getString("javabean_dialog.message_identifier"));
            if (identifier == null || identifier.equals(""))
                return;
            ejeTab.getTextArea().getDocument().insertString(ejeTab.getTextArea().getCaretPosition(), getPropertyString(type, identifier), null);
        }

        private String getPropertyString(String type, String identifier) {
            StringBuilder propString = new StringBuilder("    private " + type + " " + identifier + ";\n\n");
            String first = identifier.substring(0, 1);
            String firstUpperCase = first.toUpperCase();
            String identifierUpperCase = identifier.replaceFirst(first, firstUpperCase);
            propString.append("    public void set" + identifierUpperCase + "(" + type + " " + identifier + ") {\n");
            propString.append("        this." + identifier + " = " + identifier + ";" + "\n    }\n\n");
            propString.append("    public " + type + " get" + identifierUpperCase + "() {\n");
            propString.append("        return " + identifier + ";" + "\n    }\n\n");
            return propString.toString();
        }
    };

    // Alarm action implementation
    // **********************************************
    class AlarmClockAction extends AbstractAction {
        private static final long serialVersionUID = -7643135801505798338L;

        AlarmClockAction() {
            super("", new ImageIcon("resources/images/clock.png"));
            putValue(SHORT_DESCRIPTION, resources.getString("tooltip.alarm"));
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            AlarmClockDialog alarmClockDialog = AlarmClockDialog.getAlarmClockDialog(EJE.this);
            alarmClockDialog.setVisible(true);
        }
    };

    // Show memory action implementation
    // **********************************************
    AbstractAction showMemAction = new AbstractAction() {
        private static final long serialVersionUID = 5215772880705091810L;
        {
            putValue(SMALL_ICON, new ImageIcon("resources/images/memory.png"));
            putValue(SHORT_DESCRIPTION, resources.getString("tooltip.show_mem"));
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            Runtime rt = Runtime.getRuntime();
            long used = rt.freeMemory();
            long allocated = rt.totalMemory();
            String msg = (allocated / 1024) + resources.getString("memory_dialog.allocated") + (used / 1024)
                    + resources.getString("memory_dialog.used");
            JOptionPane pane = new JOptionPane(msg, JOptionPane.INFORMATION_MESSAGE);
            JDialog dialog = pane.createDialog(EJE.this, resources.getString("memory_dialog.title"));
            dialog.setVisible(true);
        }
    };

    // Javadoc action implementation
    // **********************************************
    class JavaDocAction extends AbstractAction {
        private static final long serialVersionUID = 465211532341449982L;

        JavaDocAction() {
            super("", new ImageIcon("resources/images/compile.png"));
            putValue(SHORT_DESCRIPTION, resources.getString("tooltip.compile"));
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if (getEjeTab() == null)
                return;
            try {
                jdkApplication = com.cdsc.eje.jdk.Javadoc.getJavadoc();
                if (jdkApplication.isProcessing())
                    return;
                CompilableFile file = getEjeTab().getJavaFile();
                processGenerateDocsAction(file);
            } catch (Exception exc) {
                System.out.println(exc.toString());
            }
        }

        public synchronized void processGenerateDocsAction(CompilableFile compilableFile) {
            try {
                EJE.this.processSaveAction();
                jdkApplication.execute(compilableFile);
            } catch (Exception exc) {
                System.out.println(exc.toString());
            }
        }
    }
    private enum TokenEnum {
        NULL, CLOSE, OPEN, STATEMENT;
    };
    // Format code action implementation
    // **********************************************
    AbstractAction formatCodeAction = new AbstractAction() {
        private static final long serialVersionUID = -6529001527628777062L;
        {
            putValue(SMALL_ICON, new ImageIcon("resources/images/format.png"));
            putValue(SHORT_DESCRIPTION, resources.getString("tooltip.format"));
        }
        private StringBuilder entersTyped;
        private StringBuilder formattedCode;
        private StringBuilder tab;
        private boolean dontUseTab;

        private TokenEnum last;
        private boolean isInvalid;
        private boolean isInSlashSlashComment;
        private boolean isInSlashStarComment;
        private boolean isInString;

        @Override
        public void actionPerformed(ActionEvent ev) {
            if (ejeTab == null)
                return;
            last = TokenEnum.NULL;
            String code = ejeTab.getTextArea().getText();
            if (code == null)
                return;
            entersTyped = new StringBuilder();
            tab = new StringBuilder();
            StringTokenizer codeTokenized = new StringTokenizer(code, "\n\"{}", true);
            formattedCode = new StringBuilder();
            try {
                while (codeTokenized.hasMoreTokens()) {
                    String token = codeTokenized.nextToken();
                    if (token.equals("\n")) {
                        entersTyped.append(isInvalid?"\n":getCarriageReturnForWindows()+"\n");
                        //entersTyped.append("\n");
                        isInSlashSlashComment = false;
                        isInvalid = isInSlashStarComment || isInString;
                        System.out.println("Invio codice: " + last);
                        continue;
                    }
                    handleToken(token);
                }
                String formattedCodeString = formattedCode.toString();
                ejeTab.getTextArea().setText(formattedCodeString);
            } catch (StringIndexOutOfBoundsException exc) {
                System.out.println("parentesi non pari");
                JOptionPane.showMessageDialog(EJE.this, resources.getString("format_dialog.msg"),
                        resources.getString("format_dialog.title"), JOptionPane.ERROR_MESSAGE);
            }
        }

        public void handleToken(String token) throws StringIndexOutOfBoundsException {
            String completeToken = token;
            token = token.trim();
            String tabString = " ";
            if (token == null || token.length() == 0 || completeToken.length() == 0
                    || ((completeToken.equals("\r") || completeToken.equals("\t")) && !isInvalid)) {
                if (isInvalid) {
                    formattedCode.append("" + entersTyped + completeToken);
                    entersTyped = new StringBuilder();
                }
                return;
            }
            if (token.contains("/*")) {
                isInSlashStarComment = true;
                isInvalid = true;
            }
            if (token.contains("*/")) {
                if (isInSlashStarComment) {
                    isInSlashStarComment = false;
                    isInvalid = false;
                }
            }
            if (!isInSlashSlashComment && !isInSlashStarComment && token.contains("\"")) {
                isInString = !isInString;
                if (isInString) {
                    isInvalid = true;
                } else if (isInString == false && isInSlashSlashComment == false && isInSlashStarComment == false) {
                    isInvalid = false;
                    dontUseTab = true;
                }
            }
            if (!isInString && !isInSlashStarComment && token.contains("//")) {
                isInSlashSlashComment = true;
                isInvalid = true;
            }
            // else if (token.endsWith("\n")) {
            // if (isInSlashSlashComment) {
            // isInSlashSlashComment = false;
            // isInvalid = false;
            // }
            // }
            if (isInvalid == false && token.equals("{")) {
                if (last == TokenEnum.OPEN || last == TokenEnum.CLOSE) {
                    entersTyped = new StringBuilder("\n");
                    tabString = tab.toString();
                } else {
                    entersTyped = new StringBuilder();
                }
                formattedCode.append((EJE.options.getProperty("eje_area.braces_style").equals("Java Style") ? "" + entersTyped + tabString
                        : "\n" + tab.toString()) + token);
                tab.append(EditorOptionsPanel.getTab());
                entersTyped = new StringBuilder();
                last = TokenEnum.OPEN;
            } else if (isInvalid == false && token.equals("}")) {
                if (entersTyped.length() == 0 || last == TokenEnum.CLOSE) {
                    entersTyped = new StringBuilder("\n");
                }
                int length = tab.length();
                tab = tab.delete(length - EditorOptionsPanel.getTab().length(), length);
                formattedCode.append("" + entersTyped + tab + token);
                entersTyped = new StringBuilder();
                last = TokenEnum.CLOSE;
            } else {
                tabString = (isInvalid || dontUseTab ? "" : tab.toString());
                if (token.equals(";")) {
                    tabString = "";
                    entersTyped = new StringBuilder();
                }
                if (last == TokenEnum.OPEN && isInvalid == false) {
                    entersTyped = new StringBuilder("\n");
                } else if (last == TokenEnum.CLOSE && entersTyped.length() == 0 && isInvalid == false) {
                    tabString = " ";
                } else if (last == TokenEnum.STATEMENT && entersTyped.length() == 0 && isInvalid == false) {
                    tabString = "";
                }
                // } else if (last == CLOSE && entersTyped.length() == 0 &&
                // isInvalid == false) {
                // tabString = " ";
                // } else if (last == STATEMENT && entersTyped.length() == 0 &&
                // isInvalid == false) {
                // tabString = "";
                // }
                if (completeToken.equals("")) {
                    return;
                }
                //formattedCode.append("" + (isInvalid? "":entersTyped) + tabString + (isInvalid ? completeToken : token));
                formattedCode.append("" + entersTyped + tabString + (isInvalid ? completeToken : token));
                entersTyped = new StringBuilder();
                last = TokenEnum.STATEMENT;
            }
            dontUseTab = false;
            System.out.println("Token: " + token + "codice: " + last);
        }

        private String getCarriageReturnForWindows() {
            return EJE.OS_NAME.toLowerCase().startsWith("win") ? "\r":"";
        }
    };
    // Guide action implementation
    // **********************************************
    AbstractAction contentsAction = new AbstractAction() {
        private static final long serialVersionUID = 6541927983511665819L;
        private JEditorPane htmlEditorPane;

        @Override
        public void actionPerformed(ActionEvent ev) {
            JScrollPane scroller = null;
            try {
                URL url = null;
                String path = null;
                try {
                    path = resources.getString("html.contents");
                    url = getClass().getResource(path);
                } catch (Exception e) {
                    System.err.println("Failed to open " + path);
                    url = null;
                }
                if (url != null) {
                    htmlEditorPane = new JEditorPane(url);
                    htmlEditorPane.setEditable(false);
                    htmlEditorPane.addHyperlinkListener(hyperLinkListener);
                    scroller = new JScrollPane();
                    JViewport vp = scroller.getViewport();
                    vp.add(htmlEditorPane);
                }
            } catch (MalformedURLException exc) {
                System.out.println("Malformed URL: " + exc);
            } catch (IOException exc) {
                System.out.println("IOException: " + exc);
            }
            JOptionPane pane = new JOptionPane(scroller);
            JDialog dialog = pane.createDialog(EJE.this, "EJE: Everyone's Java Editor...");
            dialog.setSize(864, 648);
            dialog.setLocationRelativeTo(null);
            dialog.setVisible(true);
        }

        HyperlinkListener hyperLinkListener = new HyperlinkListener() {
            @Override
            public void hyperlinkUpdate(HyperlinkEvent e) {
                if (e.getEventType() == HyperlinkEvent.EventType.ACTIVATED) {
                    if (e instanceof HTMLFrameHyperlinkEvent) {
                        ((HTMLDocument) htmlEditorPane.getDocument()).processHTMLFrameHyperlinkEvent((HTMLFrameHyperlinkEvent) e);
                    } else {
                        try {
                            Desktop.getDesktop().browse(e.getURL().toURI());
                        } catch (Exception ioe) {
                            System.out.println("Exception: " + ioe);
                        }
                    }
                }
            }
        };
    };
    // Sun Documentation action implementation
    // **********************************************
    AbstractAction showAPIDocsAction = new AbstractAction() {
        private static final long serialVersionUID = 8144963013726442881L;
        {
            putValue(SMALL_ICON, new ImageIcon("resources/images/javacup.png"));
            putValue(SHORT_DESCRIPTION, resources.getString("tooltip.api_docs"));
        }
        private JEditorPane htmlEditorPane;
        private JFrame apiDocsFrame;
        private EJEOptionsDialog optionsDialog;

        @Override
        public void actionPerformed(ActionEvent ev) {
            optionsDialog = EJEOptionsDialog.getInstance();
            try {
                String path = options.getProperty("eje.java.docs");
                if (path == null || path.equals("")) {
                    path = System.getProperty("java.home") + "/docs";
                }
                optionsDialog.getJavaOptionsPanel().checkValidDocsPath(path);
                showDocumentationBrowser(path);
            } catch (Exception exc) {
                exc.printStackTrace();
                showApiDocsFrame();
            }
        }

        private void showDocumentationBrowser(String path) throws IOException {
            try {
                Desktop.getDesktop().browse(new URI("file:///" + path.replace('\\', '/').replace(" ", "%20") + "/api/index.html"));
            } catch (Exception exc) {
                htmlEditorPane = new JEditorPane();
                htmlEditorPane.setEditable(false);
                htmlEditorPane.setPage("file:" + path + "/api/index.html");
                htmlEditorPane.addHyperlinkListener(hyperLinkListener);
                JScrollPane scroller = new JScrollPane(htmlEditorPane);
                apiDocsFrame = new JFrame("Java API documentation");
                apiDocsFrame.setContentPane(scroller);
                apiDocsFrame.setSize(800, 600);
                apiDocsFrame.setLocationRelativeTo(EJE.getEJE());
                apiDocsFrame.setVisible(true);
            }
        }

        HyperlinkListener hyperLinkListener = new HyperlinkListener() {
            @Override
            public void hyperlinkUpdate(HyperlinkEvent e) {
                if (e.getEventType() == HyperlinkEvent.EventType.ACTIVATED) {
                    if (e instanceof HTMLFrameHyperlinkEvent) {
                        ((HTMLDocument) htmlEditorPane.getDocument()).processHTMLFrameHyperlinkEvent((HTMLFrameHyperlinkEvent) e);
                    } else {
                        try {
                            htmlEditorPane.setPage(e.getURL());
                        } catch (Exception ioe) {
                            System.out.println("IOE: " + ioe);
                        }
                    }
                }
            }
        };

        public void showApiDocsFrame() {
            try {
                String docsPath = EJE.options.getProperty("eje.java.docs");
                if (docsPath == null || !(new File(docsPath).exists())) {
                    docsPath = System.getProperty("java.home");
                }
                String docsTitle = resources.getString("html.docs_msg");
                File selectedFile = optionsDialog.getJavaOptionsPanel().showChangePathDialog(docsPath, docsTitle);
                if (selectedFile != null) {
                    String dirName = selectedFile.getCanonicalPath();
                    showDocumentationBrowser(dirName);
                    options.setProperty("eje.java.docs", dirName);
                    saveProperties();
                }
            } catch (Exception ex) {
                ex.printStackTrace();
                optionsDialog.getJavaOptionsPanel().showMissingDocsDialog();
                options.setProperty("eje.java.docs", "");
                saveProperties();
                htmlEditorPane = null;
            }
        }
    };
    // About action implementation
    // **********************************************
    AbstractAction aboutAction = new AbstractAction() {
        private static final long serialVersionUID = -684115110936720448L;
        private JLabel facebookLabel = new JLabel("Facebook", new ImageIcon("resources/images/facebook.png"), JLabel.LEFT);
        private JLabel linkedInLabel = new JLabel("LinkedIn", new ImageIcon("resources/images/linkedin.png"), JLabel.LEFT);
        private JLabel twitterLabel = new JLabel("Twitter", new ImageIcon("resources/images/twitter.png"), JLabel.LEFT);
        private JLabel googlePlusLabel = new JLabel("Google+", new ImageIcon("resources/images/googleplus.png"), JLabel.LEFT);
        private JLabel eMailLabel = new JLabel("EMail", new ImageIcon("resources/images/mail.png"), JLabel.LEFT);
        private JLabel sourceForgeLabel = new JLabel("SF", new ImageIcon("resources/images/sourceforge.jpg"), JLabel.LEFT);
        {
            putValue(SMALL_ICON, new ImageIcon("resources/images/about.png"));
            putValue(SHORT_DESCRIPTION, resources.getString("tooltip.about"));
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            JPanel bkgPanel = new JPanel(new BorderLayout());
            JPanel msgPanel = new JPanel(new GridLayout(6, 1));
            JLabel siteLabel = new JLabel("<HTML><A HREF=\"http://www.claudiodesio.com\">http://www.claudiodesio.com</A></HTML>",
                    JLabel.CENTER);
            MouseAdapter hyperlinkMouseListener = new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent e) {
                    try {
                        String uri = "http://www.claudiodesio.com/index.htm";
                        if (e.getSource().equals(facebookLabel)) {
                            uri = "http://www.facebook.com/home.php?#!/pages/Claudio-De-Sio/109890719030094";
                        } else if (e.getSource().equals(linkedInLabel)) {
                            uri = "http://www.linkedin.com/in/claudiodesio";
                        } else if (e.getSource().equals(twitterLabel)) {
                            uri = "http://twitter.com/cdesio";
                        } else if (e.getSource().equals(googlePlusLabel)) {
                            uri = "https://plus.google.com/113437807917204055320/posts";
                        } else if (e.getSource().equals(eMailLabel)) {
                            uri = "mailto:eje@claudiodesio.com?subject=from%20EJE";
                        } else if (e.getSource().equals(sourceForgeLabel)) {
                            uri = "http://sourceforge.net/users/cdsc";
                        }
                        open(new URI(uri));
                    } catch (URISyntaxException exc) {
                        exc.printStackTrace();
                    }
                }

                @Override
                public void mouseEntered(MouseEvent me) {
                    setForeground(Color.RED);
                    setBackground(Color.LIGHT_GRAY);
                    setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                }
            };
            siteLabel.addMouseListener(hyperlinkMouseListener);
            msgPanel.add(new JLabel("EJE - version " + EJE_VERSION + " [" + EJE_CODE_NAME + "]", JLabel.CENTER));
            msgPanel.add(new JLabel(""));
            msgPanel.add(new JLabel("\"Everyone's Java Editor\"", JLabel.CENTER));
            msgPanel.add(new JLabel());
            msgPanel.add(new JLabel("  Written by Claudio De Sio Cesari (GPL License)  ", JLabel.CENTER));
            msgPanel.add(siteLabel);
            bkgPanel.add(msgPanel, BorderLayout.CENTER);
            //msgPanel.add(new JLabel());
            // JLabel("Questions, suggestions & bugs report to eje@claudiodesio.com"));
            JPanel socialNetworksPanel = getSocialNetworksPanel();
            bkgPanel.add(socialNetworksPanel, BorderLayout.EAST);
            registerListener(hyperlinkMouseListener);
            //msgPanel.add(socialNetworksPanel);
            JOptionPane pane = new JOptionPane(bkgPanel, JOptionPane.INFORMATION_MESSAGE, JOptionPane.DEFAULT_OPTION, new ImageIcon(
                    "resources/images/eje.png"));
            JDialog dialog = pane.createDialog(EJE.this, "About");
            dialog.setVisible(true);
        }

        private JPanel getSocialNetworksPanel() {
            JPanel socialNetworksPanel = new JPanel();
            //socialNetworksPanel.setBorder(BorderFactory.createEtchedBorder());
            socialNetworksPanel.setLayout(new GridLayout(6, 1,5,3));
            facebookLabel.setToolTipText("Stay tuned with Facebook!");
            socialNetworksPanel.add(facebookLabel);
            linkedInLabel.setToolTipText("Connect with me on LinkedIn!");
            socialNetworksPanel.add(linkedInLabel);
            twitterLabel.setToolTipText("Follow me on Twitter!");
            socialNetworksPanel.add(twitterLabel);
            googlePlusLabel.setToolTipText("Add me on Google+!");
            socialNetworksPanel.add(googlePlusLabel);
            eMailLabel.setToolTipText("Questions, suggestions & bugs report to eje@claudiodesio.com");
            socialNetworksPanel.add(eMailLabel);
            sourceForgeLabel.setToolTipText("Visit my projects on SourceForge!");
            socialNetworksPanel.add(sourceForgeLabel);
            return socialNetworksPanel;
        }

        private void registerListener(MouseAdapter hyperlinkMouseListener) {
            facebookLabel.addMouseListener(hyperlinkMouseListener);
            linkedInLabel.addMouseListener(hyperlinkMouseListener);
            twitterLabel.addMouseListener(hyperlinkMouseListener);
            googlePlusLabel.addMouseListener(hyperlinkMouseListener);
            eMailLabel.addMouseListener(hyperlinkMouseListener);
            sourceForgeLabel.addMouseListener(hyperlinkMouseListener);
        }
    };

    public void open(URI uri) {
        if (Desktop.isDesktopSupported()) {
            Desktop desktop = Desktop.getDesktop();
            try {
                desktop.browse(uri);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("No desktop is supported");
        }
    }

    AbstractAction nextFileAction = new AbstractAction() {
        private static final long serialVersionUID = 8093310932247045481L;
        {
            putValue(SMALL_ICON, new ImageIcon("resources/images/next_file.png"));
            putValue(SHORT_DESCRIPTION, resources.getString("tooltip.next_file"));
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                tabbedPane.setSelectedComponent(documents.elementAt(tabbedPane.getSelectedIndex() + 1));
            } catch (Exception exc) {
                tabbedPane.setSelectedComponent(documents.elementAt(0));
            }
        }
    };
    AbstractAction previousFileAction = new AbstractAction() {
        private static final long serialVersionUID = 5370529478136231455L;
        {
            putValue(SMALL_ICON, new ImageIcon("resources/images/previous_file.png"));
            putValue(SHORT_DESCRIPTION, resources.getString("tooltip.previous_file"));
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                tabbedPane.setSelectedComponent(documents.elementAt(tabbedPane.getSelectedIndex() - 1));
            } catch (Exception exc) {
                tabbedPane.setSelectedComponent(documents.elementAt(tabbedPane.getTabCount() - 1));
            }
        }
    };

    public void resetMessageArea() {
        messageArea.setText("");
        messageArea.setCaretPosition(0);
    }

    public void update() {
        String results = jdkApplication.getOutput();
        appendText(results);
        String className = FileValidator.trunkSuffix(ejeTab.getJavaFile(true).getName());
        if (FileValidator.isExecutableFile(className) && !runnableDocuments.contains(className)) {
            runnableDocuments.addElement(className);
            reloadSetAsMainCombo();
        }
    }

    public void update(String text) {
        String errors = jdkApplication.getExitProcessMessage() + text;
        appendText(errors);
    }

    public void appendText(String lastLine) {
        messageArea.append(lastLine);
        messageArea.setCaretPosition(messageArea.getText().length());
    }

    public String getIOAreaMessage() {
        return messageArea.getText();
    }

    public void updateClassPathForReflection(String baseDirectory, String packageName) {
        try {
            System.out.println("Added classpath = " + baseDirectory + " - "
                    + classPathForReflection.add(new File(baseDirectory).toURI().toURL()));
            // TODO dovrei sottrarre il nome del package al basedirectory
            System.out.println("Added classpath = " + baseDirectory + "/" + packageName + " - "
                    + EJE.getEJE().classPathForReflection.add(new File(baseDirectory + packageName).toURI().toURL()));
        } catch (Exception exc) {
            exc.printStackTrace();
        }
    }

    public java.net.URL getClassPathForReflection()[] {
        int size = classPathForReflection.size();
        java.net.URL[] urls = new java.net.URL[size];
        Iterator<URL> iterator = classPathForReflection.iterator();
        for (int i = 0; iterator.hasNext(); ++i) {
            urls[i] = iterator.next();
            System.out.println(urls[i]);
        }
        return urls;
    }

    private static void centerWindow(Window window) {
        Dimension screenDim = Toolkit.getDefaultToolkit().getScreenSize();
        Rectangle frameDim = window.getBounds();
        window.setLocation((screenDim.width - frameDim.width) / 2, (screenDim.height - frameDim.height) / 2);
    }

    public static void main(String[] args) {
        for (String string : args) {
            System.out.println("arg: " + string);
        }
        String version = System.getProperty("java.version");

        //String versionSubstring = version.substring(0, 1);
        if (version.startsWith("1.0") || version.startsWith("1.1") || version.startsWith("1.2")
                || version.startsWith("1.3") || version.startsWith("1.4") || version.startsWith("1.5")
                || version.startsWith("1.6") || version.startsWith("1.7")) {
            System.out.println("Require java 1.8");
            JFrame versionErrorFrame = new JFrame(resources.getString("version_error_title"));
            versionErrorFrame.getContentPane().add(new JLabel(resources.getString("version_error_msg")));
            versionErrorFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            versionErrorFrame.pack();
            centerWindow(versionErrorFrame);
            versionErrorFrame.setVisible(true);
            return;
        }
        if (args.length == 0 || !(args[0].equals("debug"))) {
            System.setOut(new PrintStream(new OutputStream() {
                @Override
                public void write(int b) {
                }
            }));
            System.setErr(System.out);
        }
        EJE.getEJE();
        // String jdkPath = EJE.properties.getProperty("eje.jdk.path");
        EJEOptionsDialog optionsDialog = EJEOptionsDialog.getInstance();
        JavaOptionsPanel javaOptionsPanel = optionsDialog.getJavaOptionsPanel();
        try {
            javaOptionsPanel.checkValidJdkPath(javaOptionsPanel.getJdkPathTextField().getText());
        } catch (FileNotFoundException exc) {
            exc.printStackTrace();
            javaOptionsPanel.getChangeJdkPathAction().actionPerformed(null);
            javaOptionsPanel.store();
            javaOptionsPanel.reload();
        }
    }

    public JDKApplication getJdkApplication() {
        return jdkApplication;
    }

    public void setJdkApplication(JDKApplication jdkApplication) {
        this.jdkApplication = jdkApplication;
    }

    public boolean isJDKValid() {
        return isJDKValid;
    }

    public void setJDKValid(boolean isJDKValid) {
        this.isJDKValid = isJDKValid;
    }

    /**
     * Setter method for ejeTree property.
     *
     * @param ejeTree
     *            the ejeTree to set.
     */
    public void setEjeTree(EJETree ejeTree) {
        this.ejeTree = ejeTree;
    }

    /**
     * Getter method for ejeTree property.
     *
     * @return the ejeTree.
     */
    public EJETree getEjeTree() {
        return ejeTree;
    }

    /**
     * Setter method for ejeTab property.
     *
     * @param ejeTab
     *            the ejeTab to set
     */
    public void setEjeTab(EJETab ejeTab) {
        this.ejeTab = ejeTab;
    }

    /**
     * Getter method for ejeTab property.
     *
     * @return the ejeTab
     */
    public EJETab getEjeTab() {
        return ejeTab;
    }

    public Vector<EJETab> getDocuments() {
        return documents;
    }

    public void setDocuments(Vector<EJETab> documents) {
        this.documents = documents;
    }
}