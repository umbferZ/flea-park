package com.fleaPark.application.standAlone.view;

import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class StatusBar extends JPanel {

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

    public void setMessage(String message) {
        lblMessage.setText(message);
    }

    public String getMessage() {
        return lblMessage.getText();
    }
}
