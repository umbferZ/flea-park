/*
 * 
 * Created by Umberto Ferracci from urania's PC
 * email: umberto.ferracci@gmail.com
 * Project: fleaPark
 * Package: com.fleaPark.application.standAlone.view.observer
 * Type: Subject
 * Last update: 25-feb-2017 18.25.43
 * 
 */
package com.fleaPark.application.standAlone.view.observer;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

public abstract class Subject implements Runnable {
    private List<Observer> observers;
    private final Object MUTEX = new Object();
    protected boolean isAlive;

    public Subject() {
        this((Observer) null);
    }

    public Subject(List<Observer> observers) {
        this.observers = observers;
        isAlive = false;
    }

    public Subject(Observer observer) {
        this(new Vector<Observer>());
        if (observer != null)
            observers.add(observer);
    }

    public void attach(Observer observer) {
        synchronized (MUTEX) {
            observers.add(observer);
        }
    }

    public void detach(Observer observer) {
        synchronized (MUTEX) {
            observers.remove(observer);
        }
    }

    public void notifyObservers() {
        List<Observer> observersLocal = null;
        synchronized (MUTEX) {
            if (hasChanged())
                observersLocal = new ArrayList<>(observers);
        }
        if (observersLocal != null) {
            Iterator<Observer> i = observersLocal.iterator();
            while (i.hasNext())
                i.next().update();
        }
    }

    @Override
    public void run() {
        isAlive = true;
        while (isAlive) {
            doSomething();
            notifyObservers();
        }

    }

    protected abstract void doSomething();

    protected abstract boolean hasChanged();
}
