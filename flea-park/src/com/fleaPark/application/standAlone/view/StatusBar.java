/*
 * 
 * Created by Umberto Ferracci from urania's PC
 * email: umberto.ferracci@gmail.com
 * Project: fleaPark
 * Package: com.fleaPark.application.standAlone.view
 * Type: StatusBar
 * Last update: 25-feb-2017 18.25.43
 * 
 */
package com.fleaPark.application.standAlone.view;

import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class StatusBar extends JPanel {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    /**
     * Create the panel.
     */
    JLabel lblMessage;

    public StatusBar() {
        lblMessage = new JLabel("Message");
        lblMessage.setFont(new Font("Dialog", Font.PLAIN, 11));
        setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
        add(lblMessage);
    }

    public String getMessage() {
        return lblMessage.getText();
    }

    public void setMessage(String message) {
        lblMessage.setText(message);
    }
}
