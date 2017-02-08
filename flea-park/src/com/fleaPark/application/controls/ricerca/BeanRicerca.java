/*
 * 
 * Created by Umberto Ferracci from urania's PC
 * email: umberto.ferracci@gmail.com
 * Project: fleaPark
 * Package: com.fleaPark.application.beans
 * Type: BeanRicerca
 * Last update: 7-feb-2017 22.56.12
 * 
 */
package com.fleaPark.application.controls.ricerca;

import java.util.ArrayList;
import java.util.List;

import com.fleaPark.model.products.Prodotto;

public class BeanRicerca {

    private String ricerca;
    private List<BeanRicercaProdotto> prodotti;

    public BeanRicerca() {
        prodotti = new ArrayList<>();
    }

    public void cerca(String ricerca) {
        C_UC_Ricerca controller = new C_UC_Ricerca();
        List<Prodotto> result = controller.cerca(ricerca);
        for (Prodotto p : result) {
            BeanRicercaProdotto bp = new BeanRicercaProdotto();
            bp.setCategoriaNome(p.getCategoria().getNome());
            bp.setProdottoId(p.getIdProdotto());
            bp.setProdottoNome(p.getNome());
            bp.setProdottoPrezzo(p.getPrezzo());
            prodotti.add(bp);
        }
    }

    public List<BeanRicercaProdotto> getProdotti() {
        return prodotti;
    }

    public String getRicerca() {
        return ricerca;
    }

    public void setProdotti(List<BeanRicercaProdotto> prodotti) {
        this.prodotti = prodotti;
    }

    public void setRicerca(String ricerca) {
        this.ricerca = ricerca;
    }
}
