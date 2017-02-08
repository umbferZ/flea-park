/*
 * 
 * Created by Umberto Ferracci from urania's PC
 * email: umberto.ferracci@gmail.com
 * Project: fleaPark
 * Package: com.fleaPark.application.beans
 * Type: BeanProdottoDettagli
 * Last update: 7-feb-2017 22.56.12
 * 
 */
package com.fleaPark.application.controls.ricerca;

public class BeanProdottoDettagli {
    public int prodottoId;
    private String prodottoNome;
    private String prodottoDescrizione;
    private int prodottoPrezzo;
    private String prodottoCategoriaNome;

    public void getDettagliProdottoById() {
        C_UC_Ricerca controller = new C_UC_Ricerca();
        BeanProdottoDettagli pbd = controller.getDettagliProdottoById(prodottoId);
        prodottoCategoriaNome = pbd.prodottoCategoriaNome;
        prodottoDescrizione = pbd.prodottoDescrizione;
        prodottoId = pbd.prodottoId;
        prodottoNome = pbd.prodottoNome;
        prodottoPrezzo = pbd.prodottoPrezzo;
    }

    public String getProdottoCategoriaNome() {
        return prodottoCategoriaNome;
    }

    public String getProdottoDescrizione() {
        return prodottoDescrizione;
    }

    public int getProdottoId() {
        return prodottoId;
    }

    public String getProdottoNome() {
        return prodottoNome;
    }

    public int getProdottoPrezzo() {
        return prodottoPrezzo;
    }

    public void setProdottoCategoriaNome(String prodottoCategoriaNome) {
        this.prodottoCategoriaNome = prodottoCategoriaNome;
    }

    public void setProdottoDescrizione(String prodottoDescrizione) {
        this.prodottoDescrizione = prodottoDescrizione;
    }

    public void setProdottoId(int prodottoID) {
        this.prodottoId = prodottoID;
    }

    public void setProdottoNome(String prodottoNome) {
        this.prodottoNome = prodottoNome;
    }

    public void setProdottoPrezzo(int i) {
        prodottoPrezzo = i;
    }
}
