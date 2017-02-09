/*
 * 
 * Created by Umberto Ferracci from urania's PC
 * email: umberto.ferracci@gmail.com
 * Project: fleaPark
 * Package: com.fleaPark.model.people
 * Type: Utente
 * Last update: 7-feb-2017 22.56.12
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

    public Utente() {}

    public Utente(String nome, String cognome, String email, String password) {
        super();
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

}
