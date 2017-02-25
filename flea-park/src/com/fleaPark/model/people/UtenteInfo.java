/*
 * 
 * Created by Umberto Ferracci from urania's PC
 * email: umberto.ferracci@gmail.com
 * Project: fleaPark
 * Package: com.fleaPark.model.people
 * Type: UtenteInfo
 * Last update: 25-feb-2017 18.25.43
 * 
 */
package com.fleaPark.model.people;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

import com.fleaPark.model.media.Foto;

@Entity
public class UtenteInfo {

    @OneToOne(cascade = CascadeType.ALL)
    private Foto fotoCopertina;

    @OneToOne(cascade = CascadeType.ALL)
    private Foto fotoProfilo;

    @Id
    @GeneratedValue
    private int id;

    @OneToOne(mappedBy = "utenteInfo", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private Utente utente;

    public UtenteInfo() {}

    public UtenteInfo(Foto copertina, Foto profile) {
        fotoCopertina = copertina;
        fotoProfilo = profile;
    }

    public Foto getFotoCopertina() {
        return fotoCopertina;
    }

    public Foto getFotoProfilo() {
        return fotoProfilo;
    }

    public int getId() {
        return id;
    }

    public Utente getUtente() {
        return utente;
    }

    public void setFotoCopertina(Foto fotoCopertina) {
        this.fotoCopertina = fotoCopertina;
    }

    public void setFotoProfilo(Foto fotoProfilo) {
        this.fotoProfilo = fotoProfilo;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUtente(Utente utente) {
        this.utente = utente;
    }

}
