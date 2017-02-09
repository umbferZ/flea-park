/*
 * 
 * Created by Umberto Ferracci from urania's PC
 * email: umberto.ferracci@gmail.com
 * Project: fleaPark
 * Package: com.fleaPark.model.products
 * Type: Prodotto
 * Last update: 9-feb-2017 1.50.41
 * 
 */
package com.fleaPark.model.products;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "acquirente")
    private Utente acquirente;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "categoria")
    private Categoria categoria;

    @Column(name = "descrizione")
    private String descrizione;

    @Id
    @GeneratedValue
    private int idProdotto;

    @Column(name = "nome")
    private String nome;

    @Column(name = "prezzo")
    private double prezzo;

    @ManyToOne(targetEntity = Utente.class ,fetch = FetchType.LAZY)
    @JoinColumn(name = "venditore")
    private Utente venditore;

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

    public double getPrezzo() {
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

    public void setPrezzo(double prezzo) {
        this.prezzo = prezzo;
    }

    public void setVenditore(Utente venditore) {
        this.venditore = venditore;
    }

}
