/*
 * 
 * Created by Umberto Ferracci from urania's PC
 * email: umberto.ferracci@gmail.com
 * Project: fleaPark
 * Package: com.fleaPark.model.products
 * Type: Valuta
 * Last update: 10-feb-2017 18.13.15
 * 
 */
package com.fleaPark.model.products;

public enum Valuta {
    DOLLAR("$"), EUR("€"), FJD("¥"), GBP("£");
    private String valuta;

    Valuta(String code) {
        valuta = code;
    }

    @Override
    public String toString() {
        return valuta;
    }

}