/*
 * 
 * Created by Umberto Ferracci from urania's PC
 * email: umberto.ferracci@gmail.com
 * Project: fleaPark
 * Package: com.fleaPark.application.controls.ricerca
 * Type: BeanProdottoDettagli
 * Last update: 10-feb-2017 12.15.04
 * 
 */
package com.fleaPark.application.controls.ricerca;

public class BeanProdottoDettagli {
    public int prodottoId;
    private String prodottoNome;
    private String prodottoDescrizione;
    private double prodottoPrezzo;
    private String prodottoValuta;

    private String prodottoCategoriaNome;

    public void getDettagliProdottoById() {
        C_UC_Ricerca controller = new C_UC_Ricerca();
        BeanProdottoDettagli pbd = controller.getDettagliProdottoById(prodottoId);
        prodottoCategoriaNome = pbd.prodottoCategoriaNome;
        prodottoDescrizione = pbd.prodottoDescrizione;
        prodottoId = pbd.prodottoId;
        prodottoNome = pbd.prodottoNome;
        prodottoPrezzo = pbd.prodottoPrezzo;
        prodottoValuta = pbd.prodottoValuta;
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

    public double getProdottoPrezzo() {
        return prodottoPrezzo;
    }

    public String getProdottoValuta() {
        return prodottoValuta;
    }

    public void setProdottoCategoriaNome(String prodottoCategoriaNome) {
        this.prodottoCategoriaNome = prodottoCategoriaNome;
    }

    public void setProdottoDescrizione(String prodottoDescrizione) {
        this.prodottoDescrizione = prodottoDescrizione;
    }

    public void setProdottoId(int prodottoID) {
        prodottoId = prodottoID;
    }

    public void setProdottoNome(String prodottoNome) {
        this.prodottoNome = prodottoNome;
    }

    public void setProdottoPrezzo(double i) {
        prodottoPrezzo = i;
    }

    public void setProdottoValuta(String prodottoValura) {
        prodottoValuta = prodottoValura;
    }
}
