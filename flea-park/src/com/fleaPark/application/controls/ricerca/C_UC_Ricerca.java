/*
 * 
 * Created by Umberto Ferracci from urania's PC
 * email: umberto.ferracci@gmail.com
 * Project: fleaPark
 * Package: com.fleaPark.application.controls.ricerca
 * Type: C_UC_Ricerca
 * Last update: 10-feb-2017 18.13.15
 * 
 */
package com.fleaPark.application.controls.ricerca;

import java.util.ArrayList;
import java.util.List;

import com.fleaPark.model.DaoFactory;
import com.fleaPark.model.media.Foto;
import com.fleaPark.model.products.Categoria;
import com.fleaPark.model.products.Prodotto;

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
        List<String> gallery = new ArrayList<>();
        for (Foto f : p.getFoto())
            gallery.add(f.getPercorso() + f.getNome());
        beanPrDe.setProdottoGallery(gallery);
        return beanPrDe;
    }

    public BeanVenditoreDettagli getVenditoreByProdottoId(int idProdotto) {
        Prodotto p = DaoFactory.getInstance().getProdottoDao().getById(idProdotto, false);
        BeanVenditoreDettagli beanVD = new BeanVenditoreDettagli();
        beanVD.setVenditoreCognome(p.getVenditore().getCognome());
        beanVD.setVenditoreNome(p.getVenditore().getNome());
        beanVD.setVenditoreId(p.getVenditore().getIdUtente());
        beanVD.setVenditoreFoto(p.getVenditore().getUtenteInfo().getProfilo().getNome());
        return beanVD;
    }

}
