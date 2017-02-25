/*
 * 
 * Created by Umberto Ferracci from urania's PC
 * email: umberto.ferracci@gmail.com
 * Project: fleaPark
 * Package: com.fleaPark.model.place
 * Type: Provincia
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
public class Provincia {
    @OneToMany(mappedBy = "provincia")
    private List<Comune> comuni;
    @Id
    private int id;
    private String nome;
    @ManyToOne
    private Regione regione;

    public Provincia() {
        super();
    }

    public Provincia(int id, String nome, Regione regione) {
        super();
        this.id = id;
        this.nome = nome;
        this.regione = regione;
    }

    public List<Comune> getComuni() {
        return comuni;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public Regione getRegione() {
        return regione;
    }

    public void setComuni(List<Comune> comuni) {
        this.comuni = comuni;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setRegione(Regione regione) {
        this.regione = regione;
    }
}
