/*
 * 
 * Created by Umberto Ferracci from urania's PC
 * email: umberto.ferracci@gmail.com
 * Project: fleaPark
 * Package: com.fleaPark.model.place
 * Type: Comune
 * Last update: 13-feb-2017 4.41.54
 * 
 */
package com.fleaPark.model.place;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Comune {
    private String cap;
    @Id
    // @GeneratedValue
    private int id;
    private String nome;
    @ManyToOne
    private Provincia provincia;

    public Comune() {
        super();
    }

    public Comune(int id, String nome, Provincia provincia) {
        super();
        this.id = id;
        this.nome = nome;
        this.provincia = provincia;
    }

    public String getCap() {
        return cap;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public Provincia getProvincia() {
        return provincia;
    }

    public void setCap(String cap) {
        this.cap = cap;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setProvincia(Provincia provincia) {
        this.provincia = provincia;
    }

}
