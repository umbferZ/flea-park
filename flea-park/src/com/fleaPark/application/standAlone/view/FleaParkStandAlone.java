/*
 * 
 * Created by Umberto Ferracci from urania's PC
 * email: umberto.ferracci@gmail.com
 * Project: fleaPark
 * Package: com.fleaPark.application.standAlone.view
 * Type: FleaParkStandAlone
 * Last update: 25-feb-2017 18.25.43
 * 
 */
package com.fleaPark.application.standAlone.view;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;

public class FleaParkStandAlone {

    private JFrame frmFleaPark;
    private CardLayout cl;
    private StatusBar statusBar;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    FleaParkStandAlone window = new FleaParkStandAlone();
                    window.frmFleaPark.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the application.
     */
    public FleaParkStandAlone() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frmFleaPark = new JFrame();
        frmFleaPark.setTitle("Flea Park");
        frmFleaPark.setBounds(600, 200, 600, 600);
        frmFleaPark.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frmFleaPark.getContentPane().setLayout(new BorderLayout(0, 0));
        /*
         * menu
         */
        JMenuBar menuBar = new JMenuBar();
        frmFleaPark.setJMenuBar(menuBar);

        JMenu mnFile = new JMenu("App");
        menuBar.add(mnFile);

        JMenuItem mntmITuoiProdotti = new JMenuItem("I tuoi prodotti");

        mnFile.add(mntmITuoiProdotti);

        JSeparator separator = new JSeparator();
        mnFile.add(separator);

        JMenuItem mntmEsci = new JMenuItem("Esci");
        mntmEsci.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int reply = JOptionPane.showConfirmDialog(null, "Sicuro di voler uscire?", "Flea Park", JOptionPane.YES_NO_OPTION);
                if (reply == JOptionPane.YES_OPTION)
                    System.exit(0);
            }
        });
        mnFile.add(mntmEsci);

        JMenu mnHelp = new JMenu("Help");
        menuBar.add(mnHelp);

        JMenuItem mntmAbout = new JMenuItem("About");
        mnHelp.add(mntmAbout);

        /*
         * cardLayout
         */

        JPanel cardLayout = new JPanel();
        cardLayout.setBackground(Color.RED);
        frmFleaPark.getContentPane().add(cardLayout);
        cardLayout.setLayout(new CardLayout(0, 0));

        JPanel login = new Login();

        cardLayout.add(login, "LOGIN");

        JPanel products = new ProdottiPanel();
        cardLayout.add(products, "1");

        statusBar = new StatusBar();
        frmFleaPark.getContentPane().add(statusBar, BorderLayout.SOUTH);

        mntmITuoiProdotti.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                cl = (CardLayout) cardLayout.getLayout();
                cl.show(cardLayout, "1");
            }
        });

    }

}
