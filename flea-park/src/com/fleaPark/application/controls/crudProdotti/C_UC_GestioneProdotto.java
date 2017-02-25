/*
 * 
 * Created by Umberto Ferracci from urania's PC
 * email: umberto.ferracci@gmail.com
 * Project: fleaPark
 * Package: com.fleaPark.application.controls.crudProdotti
 * Type: C_UC_GestioneProdotto
 * Last update: 25-feb-2017 18.25.43
 * 
 */
package com.fleaPark.application.controls.crudProdotti;

import java.util.List;

import com.fleaPark.model.DaoFactory;
import com.fleaPark.model.people.Utente;
import com.fleaPark.model.products.Prodotto;
import com.fleaPark.model.products.dao.ProdottoDao;

public class C_UC_GestioneProdotto {

    public void aggiornaProdotto() {

    }

    public void cancellaProdotto(int prodottoId) {
        DaoFactory factory = DaoFactory.getInstance();
        ProdottoDao prodottoDao = factory.getProdottoDao();
        Prodotto prodotto = prodottoDao.getById(prodottoId, false);
        prodottoDao.delete(prodotto);
    }

    public void insersciProdotto() {

    }

    public List<Prodotto> prendiProdotti(int utenteId) {
        DaoFactory factory = DaoFactory.getInstance();
        Utente u = factory.getUtenteDao().getById(utenteId, false);
        return factory.getProdottoDao().getProdottoByIdUtente(u);
    }
}
