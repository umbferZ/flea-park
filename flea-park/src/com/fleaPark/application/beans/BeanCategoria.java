package com.fleaPark.application.beans;

import java.util.ArrayList;
import java.util.List;

import com.fleaPark.application.controls.C_UC_Prodotto;
import com.fleaPark.model.products.Categoria;

public class BeanCategoria {
    private int idCategoria;
    private String nome;

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public BeanCategoria() {
        super();
    }

    public BeanCategoria getBeanCategoria(int id) {
        C_UC_Prodotto controller = new C_UC_Prodotto();
        Categoria c = controller.getCategoria(id);
        idCategoria = c.getId();
        nome = c.getNome();
        return this;
    }

    public List<BeanCategoria> getCategorie() {
        C_UC_Prodotto controller = new C_UC_Prodotto();
        List<Categoria> list = controller.getCategorie();
        List<BeanCategoria> result = new ArrayList<>();
        for (Categoria c : list) {
            BeanCategoria b = new BeanCategoria();
            b.setIdCategoria(c.getId());
            b.setNome(c.getNome());
            result.add(b);
        }
        return result;
    }
}
