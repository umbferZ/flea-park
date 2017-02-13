/*
 * 
 * Created by Umberto Ferracci from urania's PC
 * email: umberto.ferracci@gmail.com
 * Project: fleaPark
 * Package: com.fleaPark.application.standAlone.view
 * Type: FleaParkFrame
 * Last update: 13-feb-2017 4.41.54
 * 
 */
package com.fleaPark.application.standAlone.view;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.UIManager;

import com.fleaPark.application.standAlone.view.listener.MouseSpy;

public class FleaParkFrame extends JFrame {
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private JPanel bottomPanel;
    private Container c;
    private JPanel leftPanel;
    private JMenuBar menuBar;
    private JPanel rightPanel;
    private JPanel topPanel;

    public FleaParkFrame() {
        super("FleaPark");
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        c = getContentPane();
        c.setLayout(new BorderLayout());
        menuBar = new JMenuBar();
        leftPanel = new JPanel();
        rightPanel = new JPanel();
        topPanel = new JPanel();
        bottomPanel = new JPanel();
        leftPanel.add(new JLabel("left panel"));
        rightPanel.add(new JLabel("right panel"));
        topPanel.add(new JLabel("top panel"));
        bottomPanel.add(new JLabel("bottom panel"));
        c.add(topPanel, BorderLayout.NORTH);
        c.add(bottomPanel, BorderLayout.SOUTH);
        c.add(leftPanel, BorderLayout.WEST);
        c.add(rightPanel, BorderLayout.CENTER);
        c.addMouseListener(new MouseSpy());
        // contentPane.add(topPanel);
        // contentPane.add(bottomPanel);
        // contentPane.add(leftPanel);
        // contentPane.add(rightPanel);
        /*
         * java.awt.Container frmContntenPane = getContentPane();
         * frmContntenPane.setLayout(new FlowLayout()); JMenuBar menubar = new
         * JMenuBar(); JMenu jm_edit = new JMenu("Edit"); menubar.add(jm_edit);
         * setJMenuBar(menubar); frmContntenPane.add(new JButton("ciao1"),
         * BorderLayout.PAGE_START); frmContntenPane.add(new JButton("ciao2"),
         * BorderLayout.PAGE_END); frmContntenPane.add(new JButton("ciao3"));
         * frmContntenPane.add(new JButton("ciao4")); frmContntenPane.add(new
         * JButton("ciao5"));
         */
        setSize(600, 400);
        setVisible(true);
    }

    public JPanel getBottomPanel() {
        return bottomPanel;
    }

    public JPanel getLeftPanel() {
        return leftPanel;
    }

    public JPanel getRightPanel() {
        return rightPanel;
    }

    public JPanel getTopPanel() {
        return topPanel;
    }

    public void setBottomPanel(JPanel bottomPanel) {
        this.bottomPanel = bottomPanel;
    }

    public void setLeftPanel(JPanel leftPanel) {
        this.leftPanel = leftPanel;
    }

    public void setMenuBar(JMenuBar menuBar) {
        this.menuBar = menuBar;
    }

    public void setRightPanel(JPanel rightPanel) {
        this.rightPanel = rightPanel;
    }

    public void setTopPanel(JPanel topPanel) {
        this.topPanel = topPanel;
    }

}