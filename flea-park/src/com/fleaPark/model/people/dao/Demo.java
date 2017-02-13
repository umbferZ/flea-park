/*
 * 
 * Created by Umberto Ferracci from urania's PC
 * email: umberto.ferracci@gmail.com
 * Project: fleaPark
 * Package: com.fleaPark.model.people.dao
 * Type: Demo
 * Last update: 13-feb-2017 4.41.54
 * 
 */
package com.fleaPark.model.people.dao;

import com.fleaPark.model.people.Utente;

public class Demo {
    public static void main(String[] args) {
        Utente user = new Utente();
        user.setNome("firstName");
        user.setCognome("lastName");
        user.setEmail("email@email");
        user.setPassword("password");
        UtenteDao userDao = new UtenteDao.UtenteDaoHibernate();
        userDao.insert(user);

        // Prodotto prodotto = new Prodotto();
        // prodotto.setAcquirente(user);
        // prodotto.setVenditore(user);
        // prodotto.setNome("prodotto1");
        // prodotto.setDescrizione("descrizione prodotto 1");
        // prodotto.setPrezzo(new Prezzo(15,'€'));
        //
        // ProdottoDao prodottoDao = new ProdottoDao.ProdottoDaoHibernate();
        // prodottoDao.insert(prodotto);

    }
}
