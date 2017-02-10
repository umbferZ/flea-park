/*
 * 
 * Created by Umberto Ferracci from urania's PC
 * email: umberto.ferracci@gmail.com
 * Project: fleaPark
 * Package: com.fleaPark.model.products
 * Type: Prodotto
 * Last update: 10-feb-2017 12.15.04
 * 
 */
package com.fleaPark.model.products;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fleaPark.model.people.Utente;

/**
 * The Class Prodotto.
 */

@Entity
public class Prodotto {
    @ManyToOne
    @JoinColumn(name = "acquirente")
    private Utente acquirente;

    @ManyToOne
    @JoinColumn(name = "categoria")
    private Categoria categoria;

    @Column(name = "descrizione")
    private String descrizione;

    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;

    @Column(name = "nome")
    private String nome;

    private Prezzo prezzo;

    @ManyToOne
    @JoinColumn(name = "venditore")
    private Utente venditore;

    public Prodotto() {}

    public Utente getAcquirente() {
        return acquirente;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    @Embedded
    public Prezzo getPrezzo() {
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

    public void setId(int idProdotto) {
        id = idProdotto;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setPrezzo(Prezzo prezzo) {
        this.prezzo = prezzo;
    }

    public void setVenditore(Utente venditore) {
        this.venditore = venditore;
    }

}
