/*
 * 
 * Created by Umberto Ferracci from urania's PC
 * email: umberto.ferracci@gmail.com
 * Project: fleaPark
 * Package: com.fleaPark.application.standAlone.view
 * Type: Login
 * Last update: 25-feb-2017 18.25.43
 * 
 */
package com.fleaPark.application.standAlone.view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.fleaPark.application.controls.accesso.C_UC_Access;
import com.fleaPark.model.people.Utente;

public class Login extends JPanel {
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private JPasswordField pfPassword;
    private JTextField tfEmail;

    /**
     * Create the panel.
     */
    public Login() {
        setLayout(new BorderLayout(0, 0));

        JPanel panel = new JPanel();
        add(panel);
        JPanel pnlEmail = new JPanel();
        pnlEmail.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

        JLabel lblEmail = new JLabel("email");
        pnlEmail.add(lblEmail);

        tfEmail = new JTextField();
        tfEmail.setColumns(10);
        pnlEmail.add(tfEmail);

        JPanel pnlPassword = new JPanel();
        pnlPassword.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

        JLabel lblPassword = new JLabel("password");
        pnlPassword.add(lblPassword);

        pfPassword = new JPasswordField();
        pfPassword.setColumns(10);
        pnlPassword.add(pfPassword);

        JPanel pnlButton = new JPanel();
        pnlButton.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

        JButton btnAccedi = new JButton("Accedi");
        pnlButton.add(btnAccedi);
        panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
        panel.add(pnlEmail);
        panel.add(pnlPassword);
        panel.add(pnlButton);
        btnAccedi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                C_UC_Access controller = new C_UC_Access();
                Utente u = controller.accedi(tfEmail.getText(), pfPassword.getText());
                String message = "";
                try {
                    Sess.getInstance().setUtenet(u);
                    message = "ciao " + u.getNome() + " " + u.getCognome();
                    panel.setVisible(false);
                } catch (NullPointerException e1) {
                    message = "email o password errati";
                } finally {
                    JOptionPane.showMessageDialog(null, message);
                }

            }
        });

    }
}
