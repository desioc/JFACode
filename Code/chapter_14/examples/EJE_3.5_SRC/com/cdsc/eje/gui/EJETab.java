package com.cdsc.eje.gui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.JViewport;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import javax.swing.event.UndoableEditEvent;
import javax.swing.event.UndoableEditListener;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.Element;
import javax.swing.undo.CannotRedoException;
import javax.swing.undo.CannotUndoException;
import javax.swing.undo.UndoManager;

import com.cdsc.eje.entities.JavaFile;
import com.cdsc.eje.gui.options.EJEOptionsDialog;
import com.cdsc.eje.gui.options.Reloadable;

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
public class EJETab extends JScrollPane implements Reloadable {
    // Declaration of the variables
    // *************************************************************
    private boolean isDirty;
    private boolean isNew;
    private int rowNumber;
    private static int counter = 0;
    private int serial;
    private Element element;
    private EJEArea textArea;
    private JViewport port;
    private UndoManager undo;
    private UndoAction undoAction;
    private RedoAction redoAction;
    private EJEStatusBar statusBar;
    // Listener for the edits on the current document
    // ****************************************
    private UndoableEditListener undoHandler;
    private JavaFile javaFile;
    private boolean rowNumberMode;
    private Document document;
    private EJEAreaPopupMenu ejeAreaPopupMenu;
    private EJE eje;

    // This will be called by the "new" menu item
    // *******************************************
    public EJETab(boolean rowNumberMode) {
        eje = EJE.getEJE();
        this.rowNumberMode = rowNumberMode;
        serial = ++counter;
        javaFile = new JavaFile("No Name - " + serial);
        isNew = true;
        this.initialize();
        setAreaFont();
    }

    // This will be called by the "open" menu item
    // ******************************************
    public EJETab(JavaFile file, boolean rowNumberMode) {
        eje = EJE.getEJE();
        this.rowNumberMode = rowNumberMode;
        this.initialize();
        this.openFile(file);
        this.setJavaFile(file);
        this.makeClean();
        eje.updateSaveFileState(this);
        eje.updateSaveAllFilesState();
        getTextArea().setCaretPosition(0);
        setAreaFont();
    }

    public void initialize() {
        setTextArea(new EJEArea());
        ejeAreaPopupMenu = new EJEAreaPopupMenu();
        getTextArea().requestFocus();
        document = this.getDocument();
        statusBar = EJEStatusBar.getStatusBar();
        statusBar.setTextArea(getTextArea());
        undo = new UndoManager();
        undoAction = new UndoAction();
        redoAction = new RedoAction();
        undoHandler = new UndoHandler();
        this.setup();
    }

    public void openFile(File file) {
        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = bufferedReader.readLine();
            while (line != null) {
                try {
                    String nextLine = bufferedReader.readLine();
                    if (nextLine != null)
                        line += "\n";
                    document.insertString(getTextArea().getCaretPosition(), line, null);
                    line = nextLine;
                } catch (BadLocationException blExc) {
                    blExc.printStackTrace();
                }
            }
            fileReader.close();
            bufferedReader.close();
            System.out.println("file.getPath()" + file.getPath());
            EJE.recentFiles.add(file.getPath());
            EJE.updateProperties();
            EJE.getEJE().setupRecentFiles();
            EJE.getEJE().updateClassPathForReflection(file.getParent(), getTextArea().getPackageName());
        } catch (IOException exc) {
            exc.printStackTrace();
        }
    }

    public int getRowsCount() {
        return element.getElementCount();
    }

    public void setup() {
        // setLayout(new BorderLayout());
        // create a left margin to contain the line numbers
        // textArea.setBorder(BorderFactory.createMatteBorder(0, 36, 0, 0,new
        // Color(230,230,230)));
        // add(textArea, BorderLayout.CENTER);
        port = this.getViewport();
        port.setOpaque(true);
        // port.setBackground(Color.red);
        // TextPanel textPanel = new TextPanel(textArea);
        // port.setView(textPanel);
        port.setView(getTextArea());
        port.setScrollMode(JViewport.BACKINGSTORE_SCROLL_MODE);
        this.registerListeners();
    }

    private void registerListeners() {
        getTextArea().addMouseListener(areaListener);
        document.addUndoableEditListener(undoHandler);
        getTextArea().addCaretListener(caretListener);
        EJEOptionsDialog.getInstance().addReloadable(this);
    }

    @Override
    public String toString() {
        return getName();
    }

    // Accessor methods
    // ******************************************************************************
    public UndoAction getUndoAction() {
        return undoAction;
    }

    public RedoAction getRedoAction() {
        return redoAction;
    }

    public int getSerial() {
        return serial;
    }

    public void setJavaFile(JavaFile javaFile) {
        this.javaFile = javaFile;
    }

    public JavaFile getJavaFile(boolean withPackage) {
        if (withPackage) {
            String packageName = getTextArea().getPackageName();
            if (packageName != null && !packageName.equals("")) {
                packageName += ".";
            }
            return new JavaFile(getJavaFile().getParent(), packageName + javaFile.getName());
        }
        return getJavaFile();
    }

    public JavaFile getJavaFile() {
        return javaFile;
    }

    public void setDocument(Document document) {
        getTextArea().setDocument(document);
    }

    public Document getDocument() {
        return getTextArea().getDocument();
    }

    @Override
    public String getName() {
        if (javaFile != null) {
            return javaFile.getName();
        }
        return null;
    }

    public String getPath() {
        return javaFile.getPath();
    }

    // Utility Methods
    // **************************************************************************
    public void setNotNew() {
        isNew = false;
    }

    public boolean isNew() {
        return isNew;
    }

    public void makeClean() {
        isDirty = false;
    }

    public boolean isDirty() {
        return isDirty;
    }

    public void saveFile() {
        try {
            FileWriter fileWriter = new FileWriter(javaFile);
            PrintWriter printWriter = new PrintWriter(fileWriter);
            printWriter.print(getTextArea().getText());
            printWriter.close();
            System.out.println("saved old file " + javaFile);
            this.setNotNew();
            this.makeClean();
            eje.updateSaveFileState(this);
            eje.updateSaveAllFilesState();
            EJE.getEJE().updateClassPathForReflection(javaFile.getParent(), getTextArea().getPackageName());
        } catch (IOException exc) {
            exc.printStackTrace();
        }
    }

    // Actions Implementations
    // *************************************************************
    class UndoHandler implements UndoableEditListener {
        @Override
        public void undoableEditHappened(UndoableEditEvent e) {
            undo.addEdit(e.getEdit());
            isDirty = true;
            eje.updateSaveFileState(EJETab.this);
            eje.updateSaveAllFilesState();
            undoAction.update();
            redoAction.update();
        }
    }

    class UndoAction extends AbstractAction {
        public UndoAction() {
            super("", new ImageIcon("resources/images/undo.png"));
            putValue(SHORT_DESCRIPTION, EJE.resources.getString("tooltip.undo"));
            setEnabled(false);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                undo.undo();
            } catch (CannotUndoException ex) {
                System.out.println("Unable to undo: " + ex);
                ex.printStackTrace();
            }
            update();
            redoAction.update();
            isDirty = true;
            eje.updateSaveFileState(EJETab.this);
            eje.updateSaveAllFilesState();
        }

        private void update() {
            if (undo.canUndo()) {
                setEnabled(true);
                putValue(SHORT_DESCRIPTION, undo.getUndoPresentationName());
            } else {
                setEnabled(false);
                putValue(SHORT_DESCRIPTION, "Undo");
            }
        }
    }

    class RedoAction extends AbstractAction {
        public RedoAction() {
            super("", new ImageIcon("resources/images/redo.png"));
            putValue(SHORT_DESCRIPTION, EJE.resources.getString("tooltip.redo"));
            setEnabled(false);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                undo.redo();
            } catch (CannotRedoException ex) {
                System.out.println("Unable to redo: " + ex);
                ex.printStackTrace();
            }
            update();
            undoAction.update();
            isDirty = true;
            eje.updateSaveFileState(EJETab.this);
            eje.updateSaveAllFilesState();
        }

        private void update() {
            if (undo.canRedo()) {
                setEnabled(true);
                putValue(SHORT_DESCRIPTION, undo.getRedoPresentationName());
            } else {
                setEnabled(false);
                putValue(SHORT_DESCRIPTION, "Redo");
            }
        }
    }

    MouseListener areaListener = new MouseAdapter() {
        @Override
        public void mousePressed(MouseEvent e) {
            maybeShowPopup(e);
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            maybeShowPopup(e);
        }

        private void maybeShowPopup(MouseEvent e) {
            if (e.getButton() == MouseEvent.BUTTON3) {
                ejeAreaPopupMenu.show(e.getComponent(), e.getX(), e.getY());
            }
        }
    };

    public void takeStatusBar() {
        statusBar.setTextArea(getTextArea());
    }

    CaretListener caretListener = new CaretListener() {
        @Override
        public void caretUpdate(CaretEvent e) {
            rowNumber = statusBar.updateCaretPosition();
        }
    };

    public void setAreaFont() {
        String fontType = EJE.options.getProperty("eje_area.font.type");
        int fontStyle = Integer.parseInt(EJE.options.getProperty("eje_area.font.style"));
        int fontSize = Integer.parseInt(EJE.options.getProperty("eje_area.font.size"));
        this.setAreaFont(new Font(fontType, fontStyle, fontSize));
    }

    public void setAreaFont(Font font) {
        getTextArea().setFont(font);
    }

    @Override
    public void reload() {
        setAreaFont();
        getTextArea().setText(getTextArea().getText());
    }


    public String getPackageName() {
        return getTextArea().getPackageName();
    }

    public EJEArea getTextArea() {
        return textArea;
    }

    public void setTextArea(EJEArea textArea) {
        this.textArea = textArea;
    }
}