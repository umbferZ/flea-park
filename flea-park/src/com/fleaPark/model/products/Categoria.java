/*
 * 
 * Created by Umberto Ferracci from urania's PC
 * email: umberto.ferracci@gmail.com
 * Project: fleaPark
 * Package: com.fleaPark.model.products
 * Type: Categoria
 * Last update: 2-feb-2017 23.43.11
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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Categoria {
    private int id;

    private String nome;
    private Categoria parent;
    private List<Categoria> sottocategorie;

    public Categoria() {
        super();
    }

    @Id
    @GeneratedValue
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(unique = true)
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @ManyToOne(cascade = { CascadeType.ALL })
    public Categoria getParent() {
        return parent;
    }

    public void setParent(Categoria parent) {
        this.parent = parent;
    }

    @OneToMany(mappedBy = "parent", fetch=FetchType.EAGER)
    public List<Categoria> getSottocategorie() {
        return sottocategorie;
    }

    public void setSottocategorie(List<Categoria> sottocategorie) {
        this.sottocategorie = sottocategorie;
    }

    public Categoria(String nome) {
        this(nome, null);
    }

    public Categoria(String nome, Categoria parent) {
        super();
        this.nome = nome;
        this.parent = parent;
    }

}
