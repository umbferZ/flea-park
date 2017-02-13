/*
 * 
 * Created by Umberto Ferracci from urania's PC
 * email: umberto.ferracci@gmail.com
 * Project: fleaPark
 * Package: com.fleaPark.model.media
 * Type: Foto
 * Last update: 13-feb-2017 7.07.17
 * 
 */
package com.fleaPark.model.media;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Foto {
    @Id
    @GeneratedValue
    private int id;

    private String nome;

    private String percorso;

    public Foto() {}

    public Foto(String nome, String percorso) {
        this.nome = nome;
        this.percorso = percorso;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getPercorso() {
        return percorso;
    }

    public void setId(int idFoto) {
        id = idFoto;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setPercorso(String percorso) {
        this.percorso = percorso;
    }
}
