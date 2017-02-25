/*
 * 
 * Created by Umberto Ferracci from urania's PC
 * email: umberto.ferracci@gmail.com
 * Project: fleaPark
 * Package: com.fleaPark.model.products
 * Type: Prodotto
 * Last update: 25-feb-2017 18.25.43
 * 
 */
package com.fleaPark.model.products;

import java.util.Calendar;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fleaPark.model.media.Foto;
import com.fleaPark.model.people.Utente;

/**
 * The Class Prodotto.
 */

@Entity
public class Prodotto {
    @ManyToOne
    private Utente acquirente;

    @ManyToOne
    private Categoria categoria;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "data_acquisto")
    private Calendar dataAcquisto;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "data_inserimento")
    private Calendar dataInserimento;

    @Column(length = 10000)
    private String descrizione;

    @OneToMany(targetEntity = Foto.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Foto> foto;

    @Id
    @GeneratedValue
    private int id;

    private String nome;

    @Embedded
    private Prezzo prezzo;

    @ManyToOne
    private Utente venditore;

    public Prodotto() {}

    public Utente getAcquirente() {
        return acquirente;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public Calendar getDataAcquisto() {
        return dataAcquisto;
    }

    public Calendar getDataInserimento() {
        return dataInserimento;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public List<Foto> getFoto() {
        return foto;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

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

    public void setDataAcquisto(Calendar dataAcquisto) {
        this.dataAcquisto = dataAcquisto;
    }

    public void setDataInserimento(Calendar dataInserimento) {
        this.dataInserimento = dataInserimento;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public void setFoto(List<Foto> foto) {
        this.foto = foto;
    }

    public void setId(int id) {
        this.id = id;
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
