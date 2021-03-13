package com.cdsc.eje.gui;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.URI;
import java.net.URISyntaxException;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.text.Element;

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
public class EJEStatusBar extends JPanel {
    private static final long serialVersionUID = -684115110936720448L;
    protected JLabel messageLabel;
    protected JLabel actionLabel;
    protected JLabel lineLabel;
    protected JLabel processLabel;
    protected JPanel centerPanel;
    protected JPanel westPanel;
    protected JPanel centerCenterPanel;
    protected JPanel socialNetworkPanel;
    protected EJEArea textArea;
    protected EJEClock ejeClock;
    protected String title;
    private static EJEStatusBar statusBar = null;
    private ImageIcon active;
    private ImageIcon inactive;
    private JLabel facebookLabel;
    private JLabel linkedInLabel;
    private JLabel twitterLabel;
    private JLabel googlePlusLabel;
    //private JLabel eMailLabel;
//    private JLabel sourceForgeLabel;

    private EJEStatusBar(String title) {
        this.title = "     " + title + "     ";
        inactive = new ImageIcon("resources/images/ylwled.png");
        active = new ImageIcon("resources/images/redled.png");
        facebookLabel = new JLabel(" ", new ImageIcon("resources/images/facebook.png"), JLabel.LEFT);
        linkedInLabel = new JLabel(" ", new ImageIcon("resources/images/linkedin.png"), JLabel.RIGHT);
        twitterLabel = new JLabel(" ", new ImageIcon("resources/images/twitter.png"), JLabel.RIGHT);
        googlePlusLabel = new JLabel(" ", new ImageIcon("resources/images/googleplus.png"), JLabel.RIGHT);
        //eMailLabel = new JLabel(" ", new ImageIcon("resources/images/mail.png"), JLabel.CENTER);
        //sourceForgeLabel = new JLabel(" ", new ImageIcon("resources/images/sourceforge.jpg"), JLabel.LEFT);
        socialNetworkPanel = getSocialNetworksPanel();
        westPanel = new JPanel(new BorderLayout());
        centerPanel = new JPanel(new BorderLayout());
        centerCenterPanel = new JPanel();
        messageLabel = new JLabel(this.title);
        actionLabel = new JLabel("");
        lineLabel = new JLabel(EJE.resources.getString("options.java.version.using") + System.getProperty("java.version"), JLabel.RIGHT);
        processLabel = new JLabel("", inactive, JLabel.LEFT);
        ejeClock = new EJEClock();
        setup();
        registerListeners();
    }

    public void setup() {
        setLayouts();
        add(westPanel, BorderLayout.WEST);
        add(centerPanel, BorderLayout.CENTER);
        add(lineLabel, BorderLayout.EAST);
        westPanel.add(messageLabel, BorderLayout.WEST);
        westPanel.add(socialNetworkPanel, BorderLayout.CENTER);
        centerPanel.add(ejeClock, BorderLayout.EAST);
        centerPanel.add(centerCenterPanel, BorderLayout.CENTER);
        centerCenterPanel.add(actionLabel, BorderLayout.WEST);
        centerCenterPanel.add(lineLabel, BorderLayout.EAST);
        centerPanel.add(processLabel, BorderLayout.WEST);
        addDetails();
    }

    public void addDetails() {
        westPanel.setFont(new Font("dialog", Font.BOLD, 11));
        lineLabel.setFont(new Font("dialog", Font.BOLD, 11));
        westPanel.setBorder(BorderFactory.createEtchedBorder());
        lineLabel.setBorder(BorderFactory.createEtchedBorder());
        processLabel.setBorder(BorderFactory.createEtchedBorder());
        ejeClock.setBorder(BorderFactory.createEtchedBorder());
        centerPanel.setBorder(BorderFactory.createEtchedBorder());
    }

    public void setLayouts() {
        setLayout(new BorderLayout());
        centerCenterPanel.setLayout(new BorderLayout());
    }

    public void registerListeners() {
        MouseListener hyperlinkMouseListener =new MouseAdapter() {
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
                    } /*else if (e.getSource().equals(eMailLabel)) {
                        uri = "mailto:eje@claudiodesio.com?subject=from%20EJE";
                    } else if (e.getSource().equals(sourceForgeLabel)) {
                        uri = "http://sourceforge.net/users/cdsc";
                    }*/
                    EJE.getEJE().open(new URI(uri));
                } catch (URISyntaxException exc) {
                    exc.printStackTrace();
                }
            }
        };
        messageLabel.addMouseListener(hyperlinkMouseListener);
        linkedInLabel.addMouseListener(hyperlinkMouseListener);
        facebookLabel.addMouseListener(hyperlinkMouseListener);
        twitterLabel.addMouseListener(hyperlinkMouseListener);
        googlePlusLabel.addMouseListener(hyperlinkMouseListener);
        //eMailLabel.addMouseListener(hyperlinkMouseListener);
       // sourceForgeLabel.addMouseListener(hyperlinkMouseListener);
    }

    private JPanel getSocialNetworksPanel() {
        JPanel socialNetworksPanel = new JPanel();
        socialNetworksPanel.setLayout(new GridLayout(1, 6));
        facebookLabel.setToolTipText("Stay tuned with Facebook!");
        socialNetworksPanel.add(facebookLabel);
        linkedInLabel.setToolTipText("Connect with me on LinkedIn!");
        socialNetworksPanel.add(linkedInLabel);
        twitterLabel.setToolTipText("Follow me on Twitter!");
        socialNetworksPanel.add(twitterLabel);
        googlePlusLabel.setToolTipText("Add me on Google+!");
        socialNetworksPanel.add(googlePlusLabel);
        //eMailLabel.setToolTipText("Questions, suggestions & bugs report to eje@claudiodesio.com");
        //socialNetworksPanel.add(eMailLabel);
        //sourceForgeLabel.setToolTipText("Visit my projects on SourceForge!");
        //socialNetworksPanel.add(sourceForgeLabel);
        return socialNetworksPanel;
    }

    public void addAlarmTask(AlarmClockDialog.AlarmClockTimerTask alarmTask) {
        ejeClock.addAlarmTask(alarmTask);
    }

    public void removeAlarmTask(AlarmClockDialog.AlarmClockTimerTask alarmTask) {
        ejeClock.removeAlarmTask(alarmTask);
    }

    public static EJEStatusBar getStatusBar(String title) {
        if (statusBar == null) {
            statusBar = new EJEStatusBar(title);
        }
        return statusBar;
    }

    public static EJEStatusBar getStatusBar() {
        return statusBar;
    }

    public void setTextArea(EJEArea textArea) {
        this.textArea = textArea;
    }

    public int updateCaretPosition() {
        int caretPosition = textArea.getCaretPosition();
        Element element = textArea.getDocument().getDefaultRootElement();
        int rowNumber = element.getElementIndex(caretPosition);
        Element row = element.getElement(rowNumber);
        int firstColumnInRow = row.getStartOffset();
        int lastColumnInRow = row.getEndOffset();
        int rowCount = element.getElementCount();
        lineLabel.setText("     " + EJE.resources.getString("status.line") + (rowNumber + 1) + "/" + rowCount + " "
                + EJE.resources.getString("status.column") + ((caretPosition - firstColumnInRow) + 1) + "/"
                + (lastColumnInRow - firstColumnInRow) + " - " + ((rowNumber + 1) * 100) / rowCount + "%     ");
        return rowCount;
    }

    public void changeColor(String processInAction) {
        Icon icon = inactive;
        if (!processInAction.equals("")) {
            icon = active;
        }
        actionLabel.setText(processInAction);
        processLabel.setIcon(icon);
    }
}