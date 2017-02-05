/*
 * 
 * Created by Umberto Ferracci from urania's PC
 * email: umberto.ferracci@gmail.com
 * Project: fleaPark
 * Package: com.fleaPark.model.products
 * Type: Categoria
 * Last update: 3-feb-2017 23.55.06
 * 
 */
package com.fleaPark.model.products;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Categoria {
    @Id
    @GeneratedValue
    private int id;
    @Column(unique = true)
    private String nome;
    @ManyToOne
    private Categoria parent;
    @OneToMany(mappedBy = "parent", cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Categoria> sottocategorie;

    public Categoria() {
        super();
    }

    public Categoria(String nome) {
        this(nome, null);
    }

    public Categoria(String nome, Categoria parent) {
        super();
        this.nome = nome;
        this.parent = parent;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public Categoria getParent() {
        return parent;
    }

    public List<Categoria> getSottocategorie() {
        return sottocategorie;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setParent(Categoria parent) {
        this.parent = parent;
    }

    public void setSottocategorie(List<Categoria> sottocategorie) {
        this.sottocategorie = sottocategorie;
    }

}
