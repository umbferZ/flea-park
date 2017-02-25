/*
 * 
 * Created by Umberto Ferracci from urania's PC
 * email: umberto.ferracci@gmail.com
 * Project: fleaPark
 * Package: com.fleaPark.application.controls.ricerca
 * Type: BeanProdottoDettagli
 * Last update: 25-feb-2017 18.25.43
 * 
 */
package com.fleaPark.application.controls.ricerca;

import java.util.List;

public class BeanProdottoDettagli {
    public int prodottoId;
    private String prodottoCategoriaNome;
    private String prodottoDescrizione;
    private List<String> prodottoGallery;
    private String prodottoNome;
    private double prodottoPrezzo;

    private String prodottoValuta;

    public void getDettagliProdottoById() {
        C_UC_Ricerca controller = new C_UC_Ricerca();
        BeanProdottoDettagli pbd = controller.getDettagliProdottoById(prodottoId);
        prodottoCategoriaNome = pbd.prodottoCategoriaNome;
        prodottoDescrizione = pbd.prodottoDescrizione;
        prodottoId = pbd.prodottoId;
        prodottoNome = pbd.prodottoNome;
        prodottoPrezzo = pbd.prodottoPrezzo;
        prodottoValuta = pbd.prodottoValuta;
        prodottoGallery = pbd.prodottoGallery;
    }

    public String getProdottoCategoriaNome() {
        return prodottoCategoriaNome;
    }

    public String getProdottoDescrizione() {
        return prodottoDescrizione;
    }

    public List<String> getProdottoGallery() {
        return prodottoGallery;
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

    public void setProdottoGallery(List<String> prodottoGallery) {
        this.prodottoGallery = prodottoGallery;
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
