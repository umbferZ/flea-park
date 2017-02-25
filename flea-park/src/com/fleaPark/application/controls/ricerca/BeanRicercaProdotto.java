/*
 * 
 * Created by Umberto Ferracci from urania's PC
 * email: umberto.ferracci@gmail.com
 * Project: fleaPark
 * Package: com.fleaPark.application.controls.ricerca
 * Type: BeanRicercaProdotto
 * Last update: 25-feb-2017 18.25.43
 * 
 */
package com.fleaPark.application.controls.ricerca;

public class BeanRicercaProdotto {
    private String categoriaNome;
    private String prdottoValuta;
    private String prodottoFoto;
    private int prodottoId;
    private String prodottoNome;
    private double prodottoPrezzo;

    public BeanRicercaProdotto() {
        super();
    }

    public String getCategoriaNome() {
        return categoriaNome;
    }

    public String getPrdottoValuta() {
        return prdottoValuta;
    }

    public String getProdottoFoto() {
        return prodottoFoto;
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

    public void setCategoriaNome(String categoriaNome) {
        this.categoriaNome = categoriaNome;
    }

    public void setPrdottoValuta(String prdottoValuta) {
        this.prdottoValuta = prdottoValuta;
    }

    public void setProdottoFoto(String prodottoFoto) {
        this.prodottoFoto = prodottoFoto;
    }

    public void setProdottoId(int prodottoId) {
        this.prodottoId = prodottoId;
    }

    public void setProdottoNome(String prodottoNome) {
        this.prodottoNome = prodottoNome;
    }

    public void setProdottoPrezzo(double prodottoPrezzo) {
        this.prodottoPrezzo = prodottoPrezzo;
    }
}
