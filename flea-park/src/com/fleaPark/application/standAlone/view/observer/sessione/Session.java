/*
 * 
 * Created by Umberto Ferracci from urania's PC
 * email: umberto.ferracci@gmail.com
 * Project: fleaPark
 * Package: com.fleaPark.application.standAlone.view.observer.sessione
 * Type: Session
 * Last update: 25-feb-2017 1.02.57
 * 
 */
package com.fleaPark.application.standAlone.view.observer.sessione;

import com.fleaPark.application.standAlone.view.observer.Subject;
import com.fleaPark.model.people.Utente;

public class Session extends Subject {
    private Utente utente = null;
    private SessionStatus sessionStatus;

    public Session() {
        this(SessionStatus.NotAvailable);
    }

    public Session(SessionStatus status) {
        sessionStatus = status;
    }

    public SessionStatus getSessionStatus() {
        return sessionStatus;
    }

    public void setSessionStatus(SessionStatus sessionStatus) {
        this.sessionStatus = sessionStatus;
    }

    @Override
    protected void doSomething() {}

    @Override
    protected boolean hasChanged() {
        return false;
    }

}
