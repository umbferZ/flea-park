/*
 * 
 * Created by Umberto Ferracci from urania's PC
 * email: umberto.ferracci@gmail.com
 * Project: fleaPark
 * Package: com.fleaPark.model.products
 * Type: Categoria
 * Last update: 13-feb-2017 7.07.17
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
    // @JoinColumn(name = "parent")
    private Categoria parent;

    @OneToMany(mappedBy = "parent", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Categoria> sons;

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
        return sons;
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
        sons = sottocategorie;
    }

}
