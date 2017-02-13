/*
 * 
 * Created by Umberto Ferracci from urania's PC
 * email: umberto.ferracci@gmail.com
 * Project: fleaPark
 * Package: com.fleaPark.model.people
 * Type: Utente
 * Last update: 13-feb-2017 4.41.54
 * 
 */
package com.fleaPark.model.people;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fleaPark.model.DaoFactory;
import com.fleaPark.model.media.Foto;
import com.fleaPark.model.products.Prodotto;

/**
 * The Class Utente.
 */
@Entity
public class Utente {
    @OneToOne(fetch = FetchType.LAZY, mappedBy = "utente", cascade = CascadeType.ALL)
    public UtenteInfo utenteInfo;

    @Column(name = "cognome")
    private String cognome;

    @Column(unique = true)
    private String email;

    @Id
    @GeneratedValue
    @Column(name = "idUtente")
    private int idUtente;

    @Column(name = "nome")
    private String nome;

    @Column(name = "password")
    private String password;

    @OneToMany(mappedBy = "venditore", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Prodotto> prodotti;

    public static void main(String[] args) {
        UtenteInfo uI = new UtenteInfo();
        uI.setCopertina(new Foto("nomeCopertina", "pathCopertina"));
        uI.setProfilo(new Foto("nomeProfilo", "pathProfilo"));
        Utente u = new Utente("Dao name", "Dao cognome", "Dao email", "Dao password");
        u.setUtenteInfo(uI);
        DaoFactory.getInstance().getUtenteDao().insert(u);
    }

    public Utente() {}

    public Utente(String nome, String cognome, String email, String password) {
        this.nome = nome;
        this.cognome = cognome;
        this.email = email;
        this.password = password;
    }

    public String getCognome() {
        return cognome;
    }

    public String getEmail() {
        return email;
    }

    public int getIdUtente() {
        return idUtente;
    }

    public String getNome() {
        return nome;
    }

    public String getPassword() {
        return password;
    }

    public List<Prodotto> getProdotti() {
        return prodotti;
    }

    public UtenteInfo getUtenteInfo() {
        return utenteInfo;
    }

    public void setCognome(String lastName) {
        cognome = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setIdUtente(int idUser) {
        idUtente = idUser;
    }

    public void setNome(String firstName) {
        nome = firstName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setProdotti(List<Prodotto> prodotti) {
        this.prodotti = prodotti;
    }

    public void setUtenteInfo(UtenteInfo utenteInfo) {
        this.utenteInfo = utenteInfo;
    }

}
