/*
 * 
 * Created by Umberto Ferracci from urania's PC
 * email: umberto.ferracci@gmail.com
 * Project: fleaPark
 * Package: com.fleaPark.model.people
 * Type: Utente
 * Last update: 3-feb-2017 23.55.06
 * 
 */
package com.fleaPark.model.people;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * The Class Utente.
 */
@Entity
public class Utente {

    private String cognome;
    @Column(unique = true)
    private String email;

    @Id
    @GeneratedValue
    private int idUtente;

    private String nome;

    private String password;
//    @OneToMany(mappedBy = "venditore", cascade = CascadeType.ALL)
//    private List<Prodotto> acquisti;
//    @OneToMany(mappedBy = "acquirente", cascade = CascadeType.ALL)
//    private List<Prodotto> prodotti;

    public Utente() {
        super();
    }

    public Utente(String firstName, String lastName, String email, String password) {
        super();
        cognome = firstName;
        nome = lastName;
        this.email = email;
        this.password = password;
    }

//    public List<Prodotto> getAcquisti() {
//        return acquisti;
//    }

    public String getCognome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public int getIdUtente() {
        return idUtente;
    }

    public String getNome() {
        return cognome;
    }

    public String getPassword() {
        return password;
    }

//    public List<Prodotto> getProdotti() {
//        return prodotti;
//    }

//    public void setAcquisti(List<Prodotto> acquisti) {
//        this.acquisti = acquisti;
//    }

    public void setCognome(String lastName) {
        nome = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setIdUtente(int idUser) {
        idUtente = idUser;
    }

    public void setNome(String firstName) {
        cognome = firstName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

//    public void setProdotti(List<Prodotto> prodotti) {
//        this.prodotti = prodotti;
//    }

}
