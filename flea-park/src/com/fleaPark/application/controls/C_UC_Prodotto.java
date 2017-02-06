/*
 * 
 * Created by Umberto Ferracci from urania's PC
 * email: umberto.ferracci@gmail.com
 * Project: fleaPark
 * Package: com.fleaPark.application.controls
 * Type: C_UC_Prodotto
 * Last update: 6-feb-2017 1.34.21
 * 
 */
package com.fleaPark.application.controls;

import java.util.List;

import com.fleaPark.model.DaoFactory;
import com.fleaPark.model.products.Categoria;
import com.fleaPark.model.products.Prodotto;

public class C_UC_Prodotto {

    public List<Prodotto> cerca(String ricerca) {
        DaoFactory factory = DaoFactory.getInstance();
        return factory.getProdottoDao().getProdottoLikeParolaChiave(ricerca);
    }

    public Categoria getCategoria(int idCategoria) {
        DaoFactory factory = DaoFactory.getInstance();
        return factory.getCategoriaDao().getById(idCategoria, true);

    }

    public List<Categoria> getCategorie() {
        DaoFactory factory = DaoFactory.getInstance();
        return factory.getCategoriaDao().getAll();
    }

    public void inserisciProdotto(String nome, String descrizione, int prezzo, int idCategoria) {
        DaoFactory factory = DaoFactory.getInstance();
        Categoria categoria = factory.getCategoriaDao().getById(idCategoria, true);
        Prodotto p = new Prodotto();
        p.setNome(nome);
        p.setDescrizione(descrizione);
        p.setPrezzo(prezzo);
        p.setCategoria(categoria);
        factory.getProdottoDao().insert(p);

    }

}
