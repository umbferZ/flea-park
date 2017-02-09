package com.fleaPark.application.controls.crudProdotti;

import java.util.List;

import com.fleaPark.model.DaoFactory;
import com.fleaPark.model.people.Utente;
import com.fleaPark.model.products.Prodotto;

public class C_UC_Prodotti {

    public void insersciProdotto() {

    }

    public void cancellaProdotto() {

    }

    public void aggiornaProdotto() {

    }

    public List<Prodotto> prendiProdotti(int utenteId) {
        DaoFactory factory = DaoFactory.getInstance();
        Utente u = factory.getUtenteDao().getById(utenteId, false);
        return factory.getProdottoDao().getProdottoByIdUtente(u);
    }
}
