/*
 * 
 * Created by Umberto Ferracci from urania's PC
 * email: umberto.ferracci@gmail.com
 * Project: fleaPark
 * Package: com.fleaPark.application.standAlone.view.observer
 * Type: Observer
 * Last update: 25-feb-2017 0.47.44
 * 
 */
package com.fleaPark.application.standAlone.view.observer;

import org.umbZfer.debug.Message4Debug;

public abstract class Observer implements Runnable {
    protected long timeout;
    protected boolean isAlive;

    protected Observer(int timeout) {
        this.timeout = timeout;
        isAlive = false;
    }

    public void notifySubjectStatus() {

    }

    @Override
    public void run() {
        isAlive = true;
        while (isAlive) {
            update();
            try {
                Thread.sleep(timeout);
            } catch (InterruptedException e) {
                Message4Debug.log(e.getMessage());
            }
        }
    }

    public void stopObservation() {
        isAlive = false;
    }

    public abstract void update();
}
