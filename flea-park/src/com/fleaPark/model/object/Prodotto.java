/*
 * 
 * Created by Umberto Ferracci from urania's PC
 * email: umberto.ferracci@gmail.com
 * Project: fleaPark
 * Package: com.fleaPark.model.object
 * Type: Prodotto
 * Last update: 31-gen-2017 18.10.48
 * 
 */
package com.fleaPark.model.object;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

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

    private Prezzo prezzo;
    private Utente venditore;

    public Prodotto() {
        super();
    }

    @ManyToOne
    public Utente getAcquirente() {
        return acquirente;
    }

    public String getDescrizione() {
        return descrizione;
    }

    @Id
    @GeneratedValue
    public int getIdProdotto() {
        return idProdotto;
    }

    public String getNome() {
        return nome;
    }

    @ManyToOne
    public Prezzo getPrezzo() {
        return prezzo;
    }

    @ManyToOne
    public Utente getVenditore() {
        return venditore;
    }

    public void setAcquirente(Utente acquirente) {
        this.acquirente = acquirente;
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

    public void setPrezzo(Prezzo prezzo) {
        this.prezzo = prezzo;
    }

    public void setVenditore(Utente venditore) {
        this.venditore = venditore;
    }
}
