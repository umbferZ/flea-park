/*
 * 
 * Created by Umberto Ferracci from urania's PC
 * email: umberto.ferracci@gmail.com
 * Project: fleaPark
 * Package: com.fleaPark.model.products
 * Type: Prezzo
 * Last update: 10-feb-2017 12.15.04
 * 
 */
package com.fleaPark.model.products;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Embeddable
public class Prezzo {
    @Column(name = "valore")
    private double valore;
    @Enumerated(EnumType.STRING)
    private Valuta valuta;

    public Prezzo() {

    }

    public Prezzo(double valore, Valuta valuta) {
        this.valore = valore;
        this.valuta = valuta;
    }

    public double getValore() {
        return valore;
    }

    public Valuta getValuta() {
        return valuta;
    }

    public void setValore(double valore) {
        this.valore = valore;
    }

    public void setValuta(Valuta valuta) {
        this.valuta = valuta;
    }
}
