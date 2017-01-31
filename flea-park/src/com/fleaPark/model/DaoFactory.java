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

import com.fleaPark.model.people.dao.UtenteDao;

public class DaoFactory {
    public static DaoFactory instance = null;

    public static synchronized DaoFactory getInstance() {
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
}
