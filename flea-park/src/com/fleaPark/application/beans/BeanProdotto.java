/*
 * 
 * Created by Umberto Ferracci from urania's PC
 * email: umberto.ferracci@gmail.com
 * Project: fleaPark
 * Package: com.fleaPark.application.beans
 * Type: BeanProdotto
 * Last update: 6-feb-2017 1.34.21
 * 
 */
package com.fleaPark.application.beans;

import com.fleaPark.application.controls.C_UC_Prodotto;

public class BeanProdotto {
    private int prodottoId;
    private String prodottoDescrizione;
    private String prodottoNome;
    private int prodottoPrezzo;

    private int categoriaId;

    private String categoriaNome;

    public BeanProdotto() {
        super();
    }

    public int getCategoriaId() {
        return categoriaId;
    }

    public String getCategoriaNome() {
        return categoriaNome;
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

    public void inserisciProdotto() {
        C_UC_Prodotto controller = new C_UC_Prodotto();
        controller.inserisciProdotto(categoriaNome, prodottoDescrizione, prodottoPrezzo, categoriaId);
    }

    public void setCategoriaId(int categoriaId) {
        this.categoriaId = categoriaId;
    }

    public void setCategoriaNome(String categoriaNome) {
        this.categoriaNome = categoriaNome;
    }

    public void setProdottoDescrizione(String prodottoDescrizione) {
        this.prodottoDescrizione = prodottoDescrizione;
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
