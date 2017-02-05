/*
 * 
 * Created by Umberto Ferracci from urania's PC
 * email: umberto.ferracci@gmail.com
 * Project: fleaPark
 * Package: com.fleaPark.model.products
 * Type: Prodotto
 * Last update: 3-feb-2017 23.55.06
 * 
 */
package com.fleaPark.model.products;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;

import com.fleaPark.model.people.Utente;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

/**
 * The Class Prodotto.
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

     @ManyToOne
     public Utente getAcquirente() {
     return acquirente;
     }

    @ManyToOne
    public Categoria getCategoria() {
        return categoria;
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

    public int getPrezzo() {
        return prezzo;
    }

    @ManyToOne(targetEntity = Utente.class)
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
