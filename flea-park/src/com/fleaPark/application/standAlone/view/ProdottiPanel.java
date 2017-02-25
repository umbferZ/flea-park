/*
 * 
 * Created by Umberto Ferracci from urania's PC
 * email: umberto.ferracci@gmail.com
 * Project: fleaPark
 * Package: com.fleaPark.application.standAlone.view
 * Type: ProdottiPanel
 * Last update: 25-feb-2017 2.08.38
 * 
 */
package com.fleaPark.application.standAlone.view;

import java.awt.BorderLayout;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.SwingConstants;

public class ProdottiPanel extends JPanel {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    /**
     * Create the panel.
     */
    public ProdottiPanel() {
        setLayout(new BorderLayout(0, 0));

        JPanel pnlTitle = new JPanel();
        add(pnlTitle, BorderLayout.NORTH);

        JLabel lblITuoiProdotti = new JLabel("I Tuoi Prodotti");
        lblITuoiProdotti.setHorizontalAlignment(SwingConstants.CENTER);
        pnlTitle.add(lblITuoiProdotti);

        JSplitPane splitPane = new JSplitPane();
        add(splitPane, BorderLayout.CENTER);

        JPanel pnlListaProdotti = new JPanel();
        splitPane.setLeftComponent(pnlListaProdotti);
        pnlListaProdotti.setLayout(new BorderLayout(0, 0));

        JLabel lblListaDeiProdotti = new JLabel("Lista dei prodotti");
        lblListaDeiProdotti.setHorizontalAlignment(SwingConstants.CENTER);
        pnlListaProdotti.add(lblListaDeiProdotti, BorderLayout.NORTH);

        JList<String> list = new JList<>();
        pnlListaProdotti.add(list);
        DefaultListModel<String> dlm = new DefaultListModel<>();
        dlm.addElement("mark");
        dlm.addElement("giovanni Pascoli");
        list.setModel(dlm);

        JPanel pnlDettagliProdotto = new JPanel();
        splitPane.setRightComponent(pnlDettagliProdotto);
        pnlDettagliProdotto.setLayout(new BorderLayout(0, 0));

        JLabel lblDettagliProdotto = new JLabel("Dettagli prodotto");
        lblDettagliProdotto.setHorizontalAlignment(SwingConstants.CENTER);
        pnlDettagliProdotto.add(lblDettagliProdotto, BorderLayout.NORTH);

        JPanel pnlAction = new JPanel();
        add(pnlAction, BorderLayout.SOUTH);

        JButton btnNuovoProdotto = new JButton("Nuovo Prodotto");
        btnNuovoProdotto.setHorizontalAlignment(SwingConstants.RIGHT);
        pnlAction.add(btnNuovoProdotto);

    }

}
