/*
 * 
 * Created by Umberto Ferracci from urania's PC
 * email: umberto.ferracci@gmail.com
 * Project: fleaPark
 * Package: com.fleaPark.application.controls.accesso
 * Type: C_UC_Access
 * Last update: 13-feb-2017 7.07.17
 * 
 */
package com.fleaPark.application.controls.accesso;

import org.umbZfer.debug.Message4Debug;

import com.fleaPark.model.DaoFactory;
import com.fleaPark.model.people.Utente;
import com.fleaPark.model.people.dao.UtenteDao;

public class C_UC_Access {

    public Utente accedi(String email, String password) {
        DaoFactory factory = DaoFactory.getInstance();
        UtenteDao utenteDao = factory.getUtenteDao();
        try {
            Utente utenteRegistrato = utenteDao.getUtenteByEmailAndPassword(email, password);
            return utenteRegistrato;
        } catch (Exception e) {
            Message4Debug.addTrace(e.getMessage());
        }
        return null;
    }

    public void registrati(String nome, String cognome, String email, String password) {
        Utente nuovoUtente = new Utente();
        nuovoUtente.setNome(nome);
        nuovoUtente.setCognome(cognome);
        nuovoUtente.setEmail(email);
        nuovoUtente.setPassword(password);
        DaoFactory factory = DaoFactory.getInstance();
        UtenteDao utenteDao = factory.getUtenteDao();
        utenteDao.insert(nuovoUtente);
    }
}
