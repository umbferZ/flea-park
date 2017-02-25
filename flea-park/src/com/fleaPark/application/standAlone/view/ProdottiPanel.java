/*
 * 
 * Created by Umberto Ferracci from urania's PC
 * email: umberto.ferracci@gmail.com
 * Project: fleaPark
 * Package: com.fleaPark.application.standAlone.view
 * Type: ProdottiPanel
 * Last update: 25-feb-2017 18.25.43
 * 
 */
package com.fleaPark.application.standAlone.view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.SwingConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import org.umbZfer.debug.Message4Debug;

import com.fleaPark.application.controls.crudProdotti.BeanIMieiProdotti;

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
        pnlTitle.setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 5));

        JButton btnNuovoProdotto = new JButton("Nuovo Prodotto");
        pnlTitle.add(btnNuovoProdotto);
        btnNuovoProdotto.setHorizontalAlignment(SwingConstants.RIGHT);

        JSplitPane splitPane = new JSplitPane();
        add(splitPane, BorderLayout.CENTER);

        JPanel pnlListaProdotti = new JPanel();
        splitPane.setLeftComponent(pnlListaProdotti);
        pnlListaProdotti.setLayout(new BorderLayout(0, 0));

        JLabel lblListaDeiProdotti = new JLabel("Lista dei prodotti");
        lblListaDeiProdotti.setHorizontalAlignment(SwingConstants.CENTER);
        pnlListaProdotti.add(lblListaDeiProdotti, BorderLayout.NORTH);

        BeanIMieiProdotti bean = new BeanIMieiProdotti();
        bean.setUtenteId(1);
        bean.prendiProdotti();
        List<BeanIMieiProdotti> listb = bean.getiMieiProdotti();

        DefaultListModel<BeanIMieiProdotti> model = new DefaultListModel<>();

        try {
            for (BeanIMieiProdotti b : listb)
                model.addElement(b);
        } catch (NullPointerException e) {
            Message4Debug.log(e.getMessage());
        }
        JList<BeanIMieiProdotti> list = new JList<>(model);
        list.setCellRenderer(new SingleProdotto());

        JScrollPane scrollPane = new JScrollPane(list);
        pnlListaProdotti.add(scrollPane, BorderLayout.CENTER);

        JPanel pnlDettagliProdotto = new JPanel();
        splitPane.setRightComponent(pnlDettagliProdotto);
        pnlDettagliProdotto.setLayout(new BorderLayout(0, 0));

        JLabel lblDettagliProdotto = new JLabel("Dettagli prodotto");
        lblDettagliProdotto.setHorizontalAlignment(SwingConstants.CENTER);
        pnlDettagliProdotto.add(lblDettagliProdotto, BorderLayout.NORTH);

        list.addListSelectionListener(new ListSelectionListener() {

            @Override
            public void valueChanged(ListSelectionEvent e) {
                pnlDettagliProdotto.removeAll();
                if (!e.getValueIsAdjusting()) {
                    String nome = list.getSelectedValue().getProdottoNome();
                    String descrizione = list.getSelectedValue().getProdottoDescrizione();
                    String categoria = list.getSelectedValue().getCategoria();
                    String dispon = list.getSelectedValue().isVenduto() == true ? "Venduto" : "Disponibile";
                    double prezzo = list.getSelectedValue().getProdottoPrezzo();
                    pnlDettagliProdotto.add(new DettagliProdotto(nome, descrizione, categoria, dispon, prezzo), BorderLayout.CENTER);
                }
            }
        });
    }

}
