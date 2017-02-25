/*
 * 
 * Created by Umberto Ferracci from urania's PC
 * email: umberto.ferracci@gmail.com
 * Project: fleaPark
 * Package: com.fleaPark.model.place
 * Type: Regione
 * Last update: 25-feb-2017 18.25.43
 * 
 */
package com.fleaPark.model.place;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Regione {
    @Id
    private int id;

    @ManyToOne
    private Nazione nazione;
    private String nome;
    @OneToMany(mappedBy = "regione")
    private List<Provincia> province;

    public Regione() {
        super();
    }

    public Regione(int id, String nome, Nazione nazione) {
        super();
        this.id = id;
        this.nome = nome;
        this.nazione = nazione;
    }

    public int getId() {
        return id;
    }

    public Nazione getNazione() {
        return nazione;
    }

    public String getNome() {
        return nome;
    }

    public List<Provincia> getProvince() {
        return province;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNazione(Nazione nazione) {
        this.nazione = nazione;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setProvince(List<Provincia> province) {
        this.province = province;
    }
}
