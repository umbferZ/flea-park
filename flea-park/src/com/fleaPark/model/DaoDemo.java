/*
 * 
 * Created by Umberto Ferracci from urania's PC
 * email: umberto.ferracci@gmail.com
 * Project: fleaPark
 * Package: com.fleaPark.model
 * Type: DaoDemo
 * Last update: 3-feb-2017 23.55.05
 * 
 */
package com.fleaPark.model;

import java.util.ArrayList;
import java.util.List;

import com.fleaPark.model.people.Utente;
import com.fleaPark.model.products.Categoria;
import com.fleaPark.model.products.Prodotto;

public class DaoDemo {
    public static void main(String[] args) {
        DaoFactory factory = DaoFactory.getInstance();
        /*
         * Creazioni categorie base
         */
        String[] catName = { "Motori", "Immobili", "Elettronica", "Per la casa", "Sports e hobby" };

        for (String ss : catName)
            factory.getCategoriaDao().insert(new Categoria(ss));

        List<Categoria> list = factory.getCategoriaDao().getAll();
        String nomeCategoria = "";
        for (Categoria c : list)
            for (int i = 0; i < 10; i++) {
                nomeCategoria = c.getNome() + " - " + i;
                factory.getCategoriaDao().insert(new Categoria(nomeCategoria, c));
            }
        list = factory.getCategoriaDao().getAll();
        /*
         * Creazione utenti
         */
        List<Utente> utenti = new ArrayList<Utente>();
        utenti.add(new Utente("Jack", "Sparrow", "jack@sparrow", "js"));
        utenti.add(new Utente("Hector", "Barbossa", "hector@barbossa", "p"));
        utenti.add(new Utente("Will", "Turner", "will@turner", "p"));
        utenti.add(new Utente("Elizabeth", "Swann", "elizabeth@swann", "p"));
        utenti.add(new Utente("Tia", "Dalma", "tia@dalma", "p"));
        utenti.add(new Utente("Sao", "Feng", "sao@feng", "p"));
        for (Utente u : utenti) {
            factory.getUtenteDao().insert(u);
        }
        utenti = factory.getUtenteDao().getAll();

        for (Categoria c : list)
            for (int i = 0; i < 10; i++) {
                Prodotto p = new Prodotto();
                p.setNome("prodotto - " + i + " di " + c.getNome());
                p.setCategoria(c);
                p.setVenditore(utenti.get(i % utenti.size()));
                p.setAcquirente(utenti.get((i * i + 519) % utenti.size()));
                p.setDescrizione("descizione del prodotto " + i + " di " + c.getNome());
                factory.getProdottoDao().insert(p);
            }
    }
}
