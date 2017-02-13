/*
 * 
 * Created by Umberto Ferracci from urania's PC
 * email: umberto.ferracci@gmail.com
 * Project: fleaPark
 * Package: com.fleaPark.model
 * Type: DaoFactory
 * Last update: 13-feb-2017 4.41.54
 * 
 */
package com.fleaPark.model;

import com.fleaPark.model.people.dao.UtenteDao;
import com.fleaPark.model.place.dao.ComuneDao;
import com.fleaPark.model.place.dao.NazioneDao;
import com.fleaPark.model.place.dao.ProvinciaDao;
import com.fleaPark.model.place.dao.RegioneDao;
import com.fleaPark.model.products.dao.CategoriaDao;
import com.fleaPark.model.products.dao.ProdottoDao;

public class DaoFactory {
    private static DaoFactory instance = null;
    private DaoType type;

    public static DaoFactory getInstance() {
        return getInstance(DaoType.Hibernate);

    }

    public static DaoFactory getInstance(DaoType type) {
        // if (instance == null)
        instance = new DaoFactory(type);
        return instance;
    }

    private DaoFactory(DaoType type) {
        this.type = type;
    }

    public CategoriaDao getCategoriaDao() {
        return new CategoriaDao.CategoriaDaoHibernate();

    }

    public ComuneDao getComuneDao() {
        if (type == DaoType.CSV)
            return new ComuneDao.ComuneDaoCSV();
        else
            return new ComuneDao.ComuneDaoHibernate();
    }

    public NazioneDao getNazioneDao() {
        if (type == DaoType.CSV)
            return new NazioneDao.NazioneDaoCSV();
        else
            return new NazioneDao.NazioneDaoHibernate();
    }

    public ProdottoDao getProdottoDao() {
        return new ProdottoDao.ProdottoDaoHibernate();
    }

    public ProvinciaDao getProvinciaDao() {
        if (type == DaoType.CSV)
            return new ProvinciaDao.ProvinciaDaoCSV();
        return new ProvinciaDao.ProvinciaDaoHibernate();
    }

    public RegioneDao getRegioneDao() {
        if (type == DaoType.CSV)
            return new RegioneDao.RegioneDaoCSV();
        return new RegioneDao.RegioneDaoHibernate();
    }

    public UtenteDao getUtenteDao() {
        return new UtenteDao.UtenteDaoHibernate();
    }
}
