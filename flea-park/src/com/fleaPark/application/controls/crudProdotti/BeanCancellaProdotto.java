/*
 * 
 * Created by Umberto Ferracci from urania's PC
 * email: umberto.ferracci@gmail.com
 * Project: fleaPark
 * Package: com.fleaPark.application.controls.crudProdotti
 * Type: BeanCancellaProdotto
 * Last update: 25-feb-2017 18.25.43
 * 
 */
package com.fleaPark.application.controls.crudProdotti;

public class BeanCancellaProdotto {
    private int prodottoId;

    public int getProdottoId() {
        return prodottoId;
    }

    public void setProdottoId(int prodottoId) {
        this.prodottoId = prodottoId;
    }

    public void validate() {
        C_UC_GestioneProdotto controller = new C_UC_GestioneProdotto();
        controller.cancellaProdotto(prodottoId);
    }
}
