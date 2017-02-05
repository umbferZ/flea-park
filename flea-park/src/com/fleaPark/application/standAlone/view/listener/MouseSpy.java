/*
 * 
 * Created by Umberto Ferracci from urania's PC
 * email: umberto.ferracci@gmail.com
 * Project: fleaPark
 * Package: com.fleaPark.application.standAlone.view.listener
 * Type: MouseSpy
 * Last update: 3-feb-2017 23.55.05
 * 
 */
package com.fleaPark.application.standAlone.view.listener;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouseSpy implements MouseListener {

    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println("\nClick on\t" + e.getX() + "\t" + e.getY() + "");

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseExited(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mousePressed(MouseEvent e) {
        System.out.println("\nPressed on\t" + e.getX() + "\t" + e.getY() + "");
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        System.out.println("\nReleased on\t" + e.getX() + "\t" + e.getY() + "");

    }

}
