/*
 * 
 * Created by Umberto Ferracci from urania's PC
 * email: umberto.ferracci@gmail.com
 * Project: fleaPark
 * Package: com.fleaPark.model.people
 * Type: Utente
 * Last update: 31-gen-2017 18.10.48
 * 
 */
package com.fleaPark.model.people;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * The Class User.
 */
@Entity
public class Utente {

    private String cognome;
    private String email;

    private int idUtente;

    private String nome;

    private String password;

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

    public String getCognome() {
        return nome;
    }

    @Column(unique = true)
    public String getEmail() {
        return email;
    }

    @Id
    @GeneratedValue
    public int getIdUtente() {
        return idUtente;
    }

    public String getNome() {
        return cognome;
    }

    public String getPassword() {
        return password;
    }

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

}
