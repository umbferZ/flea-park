/*
 * 
 * Created by Umberto Ferracci from urania's PC
 * email: umberto.ferracci@gmail.com
 * Project: fleaPark
 * Package: com.fleaPark.application.beans
 * Type: BeanRicerca
 * Last update: 6-feb-2017 1.34.20
 * 
 */
package com.fleaPark.application.beans;

import java.util.ArrayList;
import java.util.List;

import com.fleaPark.application.controls.C_UC_Prodotto;
import com.fleaPark.model.products.Prodotto;

public class BeanRicerca {

    private String ricerca;
    private List<BeanProdotto> prodotti;

    public BeanRicerca() {
        prodotti = new ArrayList<>();
    }

    public void cerca(String ricerca) {
        C_UC_Prodotto controller = new C_UC_Prodotto();
        List<Prodotto> result = controller.cerca(ricerca);
        for (Prodotto p : result) {
            BeanProdotto bp = new BeanProdotto();
            bp.setCategoriaId(p.getCategoria().getId());
            bp.setCategoriaNome(p.getCategoria().getNome());
            bp.setProdottoDescrizione(p.getDescrizione());
            bp.setProdottoId(p.getIdProdotto());
            bp.setProdottoNome(p.getNome());
            bp.setProdottoPrezzo(p.getPrezzo());
            prodotti.add(bp);
        }
    }

    public List<BeanProdotto> getProdotti() {
        return prodotti;
    }

    public String getRicerca() {
        return ricerca;
    }

    public void setProdotti(List<BeanProdotto> prodotti) {
        this.prodotti = prodotti;
    }

    public void setRicerca(String ricerca) {
        this.ricerca = ricerca;
    }
}
