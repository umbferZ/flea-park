/*
 * 
 * Created by Umberto Ferracci from urania's PC
 * email: umberto.ferracci@gmail.com
 * Project: fleaPark
 * Package: com.fleaPark.model.place
 * Type: Nazione
 * Last update: 13-feb-2017 7.07.17
 * 
 */
package com.fleaPark.model.place;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Nazione {
    @Id
    private int id;
    private String nome;
    @OneToMany(mappedBy = "nazione")
    private List<Regione> regioni;

    public Nazione() {
        super();
    }

    public Nazione(int idNazione, String nome) {
        super();
        id = idNazione;
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public List<Regione> getRegioni() {
        return regioni;
    }

    public void setId(int idNazione) {
        id = idNazione;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setRegioni(List<Regione> regioni) {
        this.regioni = regioni;
    }

}
