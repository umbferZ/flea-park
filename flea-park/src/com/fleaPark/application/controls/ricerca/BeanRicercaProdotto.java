/*
 * 
 * Created by Umberto Ferracci from urania's PC
 * email: umberto.ferracci@gmail.com
 * Project: fleaPark
 * Package: com.fleaPark.application.controls.ricerca
 * Type: BeanRicercaProdotto
 * Last update: 8-feb-2017 3.24.26
 * 
 */
package com.fleaPark.application.controls.ricerca;

public class BeanRicercaProdotto {
    private int prodottoId;
    private String prodottoNome;
    private int prodottoPrezzo;
    private String categoriaNome;

    public BeanRicercaProdotto() {
        super();
    }

    public String getCategoriaNome() {
        return categoriaNome;
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

    public void setCategoriaNome(String categoriaNome) {
        this.categoriaNome = categoriaNome;
    }

    public void setProdottoId(int prodottoId) {
        this.prodottoId = prodottoId;
    }

    public void setProdottoNome(String prodottoNome) {
        this.prodottoNome = prodottoNome;
    }

    public void setProdottoPrezzo(int prodottoPrezzo) {
        this.prodottoPrezzo = prodottoPrezzo;
    }
}
