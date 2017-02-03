/*
 * 
 * Created by Umberto Ferracci from urania's PC
 * email: umberto.ferracci@gmail.com
 * Project: fleaPark
 * Package: com.fleaPark.model.products
 * Type: Prodotto
 * Last update: 2-feb-2017 22.26.55
 * 
 */
package com.fleaPark.model.products;

import javax.persistence.Entity;

import com.fleaPark.model.people.Utente;

/**
 * The Class Oggetti.
 */
@Entity
public class Prodotto {
    private int idProdotto;

    private Utente acquirente;

    private String descrizione;

    private String nome;

    private int prezzo;
    private Utente venditore;

    private Categoria categoria;

    public Prodotto() {
        super();
    }

    public Utente getAcquirente() {
        return acquirente;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public int getIdProdotto() {
        return idProdotto;
    }

    public String getNome() {
        return nome;
    }

    public int getPrezzo() {
        return prezzo;
    }

    public Utente getVenditore() {
        return venditore;
    }

    public void setAcquirente(Utente acquirente) {
        this.acquirente = acquirente;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public void setIdProdotto(int idProdotto) {
        this.idProdotto = idProdotto;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setPrezzo(int prezzo) {
        this.prezzo = prezzo;
    }

    public void setVenditore(Utente venditore) {
        this.venditore = venditore;
    }

}
