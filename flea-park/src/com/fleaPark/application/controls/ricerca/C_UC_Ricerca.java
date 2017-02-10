/*
 * 
 * Created by Umberto Ferracci from urania's PC
 * email: umberto.ferracci@gmail.com
 * Project: fleaPark
 * Package: com.fleaPark.application.controls.ricerca
 * Type: C_UC_Ricerca
 * Last update: 10-feb-2017 12.15.04
 * 
 */
package com.fleaPark.application.controls.ricerca;

import java.util.List;

import com.fleaPark.model.DaoFactory;
import com.fleaPark.model.products.Categoria;
import com.fleaPark.model.products.Prezzo;
import com.fleaPark.model.products.Prodotto;
import com.fleaPark.model.products.Valuta;

public class C_UC_Ricerca {

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

    public BeanProdottoDettagli getDettagliProdottoById(int idProdotto) {

        Prodotto p = DaoFactory.getInstance().getProdottoDao().getById(idProdotto, false);
        BeanProdottoDettagli beanPrDe = new BeanProdottoDettagli();
        beanPrDe.setProdottoNome(p.getNome());
        beanPrDe.setProdottoDescrizione(p.getDescrizione());
        beanPrDe.setProdottoCategoriaNome(p.getCategoria().getNome());
        beanPrDe.setProdottoPrezzo(p.getPrezzo().getValore());
        beanPrDe.setProdottoValuta(p.getPrezzo().getValuta().name());
        return beanPrDe;
    }

    public BeanVenditoreDettagli getVenditoreByProdottoId(int idProdotto) {
        Prodotto p = DaoFactory.getInstance().getProdottoDao().getById(idProdotto, false);
        BeanVenditoreDettagli beanVD = new BeanVenditoreDettagli();
        beanVD.setVenditoreCognome(p.getVenditore().getCognome());
        beanVD.setVenditoreNome(p.getVenditore().getNome());
        beanVD.setVenditoreId(p.getVenditore().getIdUtente());
        return beanVD;
    }

    public void inserisciProdotto(String nome, String descrizione, int prezzo, int idCategoria) {
        DaoFactory factory = DaoFactory.getInstance();
        Categoria categoria = factory.getCategoriaDao().getById(idCategoria, true);
        Prodotto p = new Prodotto();
        p.setNome(nome);
        p.setDescrizione(descrizione);
        p.setPrezzo(new Prezzo(prezzo, Valuta.EUR));
        p.setCategoria(categoria);
        factory.getProdottoDao().insert(p);

    }

}
