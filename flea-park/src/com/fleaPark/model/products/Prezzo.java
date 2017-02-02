/*
 * 
 * Created by Umberto Ferracci from urania's PC
 * email: umberto.ferracci@gmail.com
 * Project: fleaPark
 * Package: com.fleaPark.model.object
 * Type: Prezzo
 * Last update: 31-gen-2017 18.10.48
 * 
 */
package com.fleaPark.model.products;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * The Class Price.
 */
@Entity
public class Prezzo {
    private char currency;
    private int value;

    public Prezzo() {
        super();
    }

    public Prezzo(int value, char c) {
        this.value = value;
        currency = c;
    }

    @Id
    public char getCurrency() {
        return currency;
    }

    @Id
    public int getValue() {
        return value;
    }

    public void setCurrency(char currency) {
        this.currency = currency;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
