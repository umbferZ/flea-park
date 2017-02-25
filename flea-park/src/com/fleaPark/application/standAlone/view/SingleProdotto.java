/*
 * 
 * Created by Umberto Ferracci from urania's PC
 * email: umberto.ferracci@gmail.com
 * Project: fleaPark
 * Package: com.fleaPark.application.standAlone.view
 * Type: SingleProdotto
 * Last update: 25-feb-2017 18.25.43
 * 
 */
package com.fleaPark.application.standAlone.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListCellRenderer;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

import com.fleaPark.application.controls.crudProdotti.BeanIMieiProdotti;

public class SingleProdotto extends JPanel implements ListCellRenderer<BeanIMieiProdotti> {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    /**
     * Create the panel.
     */
    private static final Border SAFE_NO_FOCUS_BORDER = new LineBorder(new Color(0, 0, 0));
    private static final Border DEFAULT_NO_FOCUS_BORDER = new LineBorder(new Color(0, 0, 0));

    protected static Border noFocusBorder = DEFAULT_NO_FOCUS_BORDER;

    private JLabel lblNomeprodotto = new JLabel("Nome ");
    private JLabel lblCategoriaprodotto = new JLabel("Categoria ");
    private JLabel lblPrezzoprodotto = new JLabel("prezzo ");
    private JLabel lblVenduto = new JLabel("Disponibilità");

    public SingleProdotto() {
        // setBorder();
        setLayout(new BorderLayout(5, 5));
        lblNomeprodotto.setFont(new Font("Dialog", Font.BOLD, 12));
        add(lblNomeprodotto, BorderLayout.NORTH);
        lblPrezzoprodotto.setHorizontalAlignment(SwingConstants.TRAILING);
        add(lblPrezzoprodotto, BorderLayout.CENTER);
        add(lblVenduto, BorderLayout.WEST);
        lblVenduto.setHorizontalAlignment(SwingConstants.CENTER);
        lblVenduto.setFont(new Font("Dialog", Font.PLAIN, 11));
        add(lblCategoriaprodotto, BorderLayout.SOUTH);
        lblCategoriaprodotto.setHorizontalAlignment(SwingConstants.RIGHT);
        lblCategoriaprodotto.setFont(new Font("Dialog", Font.PLAIN, 11));

    }

    @Override
    public Component getListCellRendererComponent(JList<? extends BeanIMieiProdotti> list, BeanIMieiProdotti value, int index, boolean isSelected, boolean cellHasFocus) {
        Color bg = null;
        Color fg = null;
        JList.DropLocation dropLocation = list.getDropLocation();
        if ((dropLocation != null) && !dropLocation.isInsert() && (dropLocation.getIndex() == index)) {

            bg = UIManager.getColor("Panel.background");
            fg = UIManager.getColor("Panel.foreground");

            isSelected = true;
        }

        if (isSelected) {
            setBackground(bg == null ? list.getSelectionBackground() : bg);
            setForeground(fg == null ? list.getSelectionForeground() : fg);
        } else {
            setBackground(list.getBackground());
            setForeground(list.getForeground());
        }

        lblNomeprodotto.setText(value.getProdottoNome());
        lblCategoriaprodotto.setText(value.getCategoria());
        lblPrezzoprodotto.setText(value.getProdottoPrezzo() + "€");
        lblVenduto.setText(value.isVenduto() == true ? "Venduto" : "Disponibile");

        Border border = null;
        if (cellHasFocus) {
            if (isSelected)
                border = UIManager.getBorder("List.focusSelectedCellHighlightBorder");
            if (border == null)
                border = UIManager.getBorder("List.focusCellHighlightBorder");

        }
        setBorder(border);
        return this;
    }
}
