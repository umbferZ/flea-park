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
import com.fleaPark.model.products.dao.CategoriaDao;
import com.fleaPark.model.products.dao.ProdottoDao;

public class DaoFactory {
    private static DaoFactory instance = null;

    public synchronized static DaoFactory getInstance() {
        if (instance == null)
            instance = new DaoFactory();
        return instance;
    }

    private DaoFactory() {
        // TODO Auto-generated constructor stub
    }

    public UtenteDao getUtenteDao() {
        return new UtenteDao.UtenteDaoHibernate();
    }

    public ProdottoDao getProdottoDao() {
        return new ProdottoDao.ProdottoDaoHibernate();
    }

    public CategoriaDao getCategoriaDao() {
        return new CategoriaDao.CategoriaDaoHibernate();
    }

}
