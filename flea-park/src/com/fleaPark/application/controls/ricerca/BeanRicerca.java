/*
 * 
 * Created by Umberto Ferracci from urania's PC
 * email: umberto.ferracci@gmail.com
 * Project: fleaPark
 * Package: com.fleaPark.application.controls.ricerca
 * Type: BeanRicerca
 * Last update: 11-feb-2017 17.10.28
 * 
 */
package com.fleaPark.application.controls.ricerca;

import java.util.ArrayList;
import java.util.List;

import com.fleaPark.model.products.Prodotto;

public class BeanRicerca {

    private List<BeanRicercaProdotto> prodotti;
    private String ricerca;

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
            bp.setProdottoPrezzo(p.getPrezzo().getValore());
            bp.setPrdottoValuta(p.getPrezzo().getValuta().name());
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
