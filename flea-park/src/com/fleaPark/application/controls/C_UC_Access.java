/*
 * 
 * Created by Umberto Ferracci from urania's PC
 * email: umberto.ferracci@gmail.com
 * Project: fleaPark
 * Package: com.fleaPark.application.controls
 * Type: C_UC_Access
 * Last update: 6-feb-2017 1.34.21
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
        access.registrati("nome", "cognome", "email@email", "password");
    }

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
