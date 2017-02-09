/*
 * 
 * Created by Umberto Ferracci from urania's PC
 * email: umberto.ferracci@gmail.com
 * Project: fleaPark
 * Package: com.fleaPark.model
 * Type: DaoFactory
 * Last update: 9-feb-2017 3.03.00
 * 
 */
package com.fleaPark.model;

import com.fleaPark.model.people.dao.UtenteDao;
import com.fleaPark.model.products.dao.CategoriaDao;
import com.fleaPark.model.products.dao.ProdottoDao;
import com.fleaPark.tools.debug.Message4Debug;

public class DaoFactory {
    private static DaoFactory instance = null;
    private static int instanceCount = 0;
    private static long timer = 0;

    public static DaoFactory getInstance() {
        if (instance == null) {
            instance = new DaoFactory();
            instanceCount++;
            timer = System.currentTimeMillis();
        }
        Message4Debug.log("DaoFactory.instanceCount = " + instanceCount + " at time " + timer);
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
