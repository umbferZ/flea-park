/*
 * 
 * Created by Umberto Ferracci from urania's PC
 * email: umberto.ferracci@gmail.com
 * Project: fleaPark
 * Package: com.fleaPark.model.people
 * Type: User
 * Last update: 31-gen-2017 0.03.10
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
public class User {
    private int idUser;

    private String email;
    private String password;

    private String lastName;

    private String firstName;

    public User() {
        super();
    }

    public User(String firstName, String lastName, String email, String password) {
        super();
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
    }

    @Column(unique = true)
    public String getEmail() {
        return email;
    }

    public String getFirstName() {
        return firstName;
    }

    @Id
    @GeneratedValue
    public int getIdUser() {
        return idUser;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
