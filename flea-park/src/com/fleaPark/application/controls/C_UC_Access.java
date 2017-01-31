/*
 * 
 * Created by Umberto Ferracci from urania's PC
 * email: umberto.ferracci@gmail.com
 * Project: fleaPark
 * Package: com.fleaPark.application.controls
 * Type: C_UC_Access
 * Last update: 31-gen-2017 18.10.48
 * 
 */
package com.fleaPark.application.controls;

import com.fleaPark.model.DaoFactory;
import com.fleaPark.model.people.Utente;
import com.fleaPark.model.people.dao.UtenteDao;
import com.fleaPark.tools.debug.Message4Debug;

public class C_UC_Access {

    public static void main(String[] args) {
        C_UC_Access access = new C_UC_Access();
        // access.registrati("nome", "cognome", "email@email", "password");
        // Message4Debug.log("nuovo utente inserito");
        Message4Debug.log("idutente: " + access.accedi("email@email", "password").getIdUtente());
    }

    public Utente accedi(String email, String password) {
        DaoFactory factory = DaoFactory.getInstance();
        UtenteDao utenteDao = factory.getUtenteDao();
        try {
            Utente utenteRegistrato = utenteDao.getUserByEmailAndPassword(email, password);
            return utenteRegistrato;
        } catch (Exception e) {
            Message4Debug.addTrace(e.getMessage());
        }
        return null;
    }

    public void registrati(String nome, String cognome, String email, String password) {
        DaoFactory factory = DaoFactory.getInstance();
        UtenteDao utenteDao = factory.getUtenteDao();
        Utente nuovoUtente = new Utente();
        nuovoUtente.setNome(nome);
        nuovoUtente.setCognome(cognome);
        nuovoUtente.setEmail(email);
        nuovoUtente.setPassword(password);
        utenteDao.insert(nuovoUtente);
    }
}
