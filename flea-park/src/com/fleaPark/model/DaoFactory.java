/*
 * 
 * Created by Umberto Ferracci from urania's PC
 * email: umberto.ferracci@gmail.com
 * Project: fleaPark
 * Package: com.fleaPark.model
 * Type: DaoFactory
 * Last update: 11-feb-2017 17.10.28
 * 
 */
package com.fleaPark.model;

import com.fleaPark.model.people.dao.UtenteDao;
import com.fleaPark.model.products.dao.CategoriaDao;
import com.fleaPark.model.products.dao.ProdottoDao;

public class DaoFactory {
    private static DaoFactory instance = null;

    public static DaoFactory getInstance() {
        if (instance == null)
            instance = new DaoFactory();
        return instance;
    }

    private DaoFactory() {}

    public CategoriaDao getCategoriaDao() {
        return new CategoriaDao.CategoriaDaoHibernate();
    }

    public ProdottoDao getProdottoDao() {
        return new ProdottoDao.ProdottoDaoHibernate();
    }

    public UtenteDao getUtenteDao() {
        return new UtenteDao.UtenteDaoHibernate();
    }

}
