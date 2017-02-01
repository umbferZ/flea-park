/*
 * 
 * Created by Umberto Ferracci from urania's PC
 * email: umberto.ferracci@gmail.com
 * Project: fleaPark
 * Package: com.fleaPark.model
 * Type: DaoFactory
 * Last update: 31-gen-2017 18.10.48
 * 
 */
package com.fleaPark.model;

import com.fleaPark.model.people.Utente;
import com.fleaPark.model.people.dao.UtenteDao;
import com.fleaPark.tools.debug.Message4Debug;

public class DaoFactory {
    public static DaoFactory instance = null;

    public static DaoFactory getInstance() {
        if (DaoFactory.instance == null)
            DaoFactory.instance = new DaoFactory();
        return DaoFactory.instance;
    }

    private DaoFactory() {
        // TODO Auto-generated constructor stub
    }

    public UtenteDao getUtenteDao() {
        return new UtenteDao.UtenteDaoHibernate();
    }
    public static void main(String[] args) {
        DaoFactory factory = DaoFactory.getInstance();
        UtenteDao utenteDao = factory.getUtenteDao();
        Utente utente=null;
        try {
            utente=utenteDao.getUtenteByEmailAndPassword("email@email", "password");
            Message4Debug.log("id utente "+utente.getIdUtente());
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
