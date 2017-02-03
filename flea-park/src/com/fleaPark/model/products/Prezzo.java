/*
 * 
 * Created by Umberto Ferracci from urania's PC
 * email: umberto.ferracci@gmail.com
 * Project: fleaPark
 * Package: com.fleaPark.model.products
 * Type: Prezzo
 * Last update: 2-feb-2017 22.26.55
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
