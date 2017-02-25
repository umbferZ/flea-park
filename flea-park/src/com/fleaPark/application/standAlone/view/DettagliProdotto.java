/*
 * 
 * Created by Umberto Ferracci from urania's PC
 * email: umberto.ferracci@gmail.com
 * Project: fleaPark
 * Package: com.fleaPark.application.standAlone.view
 * Type: DettagliProdotto
 * Last update: 25-feb-2017 18.25.43
 * 
 */
package com.fleaPark.application.standAlone.view;

import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;

public class DettagliProdotto extends JPanel {
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    JLabel lblNomeprodotto = new JLabel("NomeProdotto");
    JLabel lblPrezzoprodotto = new JLabel("PrezzoProdotto");
    JLabel lblCategoriaprodotto = new JLabel("CategoriaProdotto");
    JLabel lblDisponibilit = new JLabel("Disponibilità");
    private final JTextPane textPane = new JTextPane();

    /**
     * Create the panel.
     */
    public DettagliProdotto(String nome, String descrizione, String categoria, String dispon, double prezzo) {
        setBounds(0, 0, 400, 400);
        lblNomeprodotto.setBounds(12, 15, 376, 15);
        lblNomeprodotto.setText(nome);
        lblPrezzoprodotto.setBounds(229, 373, 159, 15);
        lblPrezzoprodotto.setText(prezzo + " €");
        setLayout(null);

        lblNomeprodotto.setHorizontalAlignment(SwingConstants.CENTER);
        add(lblNomeprodotto);

        add(lblPrezzoprodotto);
        lblPrezzoprodotto.setHorizontalAlignment(SwingConstants.RIGHT);

        lblCategoriaprodotto.setBounds(22, 42, 366, 14);
        add(lblCategoriaprodotto);
        lblCategoriaprodotto.setText(categoria);

        lblCategoriaprodotto.setFont(new Font("Dialog", Font.PLAIN, 11));
        lblCategoriaprodotto.setHorizontalAlignment(SwingConstants.CENTER);
        lblDisponibilit.setBounds(12, 374, 158, 14);
        add(lblDisponibilit);
        lblDisponibilit.setText(dispon);

        lblDisponibilit.setFont(new Font("Dialog", Font.PLAIN, 11));
        textPane.setEditable(false);
        add(textPane);
        textPane.setBounds(12, 71, 376, 290);
        // add(textPane);
        textPane.setText(descrizione);

    }
}
