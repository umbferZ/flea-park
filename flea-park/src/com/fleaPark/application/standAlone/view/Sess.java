/*
 * 
 * Created by Umberto Ferracci from urania's PC
 * email: umberto.ferracci@gmail.com
 * Project: fleaPark
 * Package: com.fleaPark.application.standAlone.view
 * Type: Sess
 * Last update: 25-feb-2017 2.08.38
 * 
 */
package com.fleaPark.application.standAlone.view;

import com.fleaPark.model.people.Utente;

public class Sess {
    private static Sess instance = null;

    private Utente utente = null;

    public synchronized static Sess getInstance() {
        if (instance == null)
            instance = new Sess();
        return instance;
    }

    protected Utente getUtente() {
        return utente;
    }

    protected void setUtenet(Utente utente) {
        this.utente = utente;
    }
}
