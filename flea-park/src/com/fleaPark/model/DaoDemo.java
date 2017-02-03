package com.fleaPark.model;

import com.fleaPark.model.people.Utente;
import com.fleaPark.model.products.Categoria;

public class DaoDemo {
    public static void main(String[] args) {
        DaoFactory factory = DaoFactory.getInstance();
        // creazione utente
        Utente u1 = new Utente();
        u1.setNome("Jack");
        u1.setCognome("Sparrows");
        u1.setEmail("j@s");
        u1.setPassword("js");
        factory.getUtenteDao().insert(u1);

        // creazione categorie

        String[] catName = { "Motori", "Immobili", "Elettronica", "Per la casa", "Sports e hobby" };

        for (String ss : catName) {
            factory.getCategoriaDao().insert(new Categoria(ss));
        }
    }
}
