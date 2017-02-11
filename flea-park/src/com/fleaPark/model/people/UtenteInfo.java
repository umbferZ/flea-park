/*
 * 
 * Created by Umberto Ferracci from urania's PC
 * email: umberto.ferracci@gmail.com
 * Project: fleaPark
 * Package: com.fleaPark.model.people
 * Type: UtenteInfo
 * Last update: 11-feb-2017 17.10.28
 * 
 */
package com.fleaPark.model.people;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

import com.fleaPark.model.media.Foto;

@Entity
public class UtenteInfo {

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "copertina")
    private Foto copertina;

    @Id
    @GeneratedValue
    private int idUtenteInfo;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "profilo")
    private Foto profilo;

    @OneToOne(fetch = FetchType.LAZY)
    @PrimaryKeyJoinColumn
    private Utente utente;

    public UtenteInfo() {}

    public UtenteInfo(Foto copertina, Foto profile) {
        this.copertina = copertina;
        profilo = profile;
    }

    public Foto getCopertina() {
        return copertina;
    }

    public int getIdUtenteInfo() {
        return idUtenteInfo;
    }

    public Foto getProfilo() {
        return profilo;
    }

    public Utente getUtente() {
        return utente;
    }

    public void setCopertina(Foto copertina) {
        this.copertina = copertina;
    }

    public void setIdUtenteInfo(int idUtenteInfo) {
        this.idUtenteInfo = idUtenteInfo;
    }

    public void setProfilo(Foto profile) {
        profilo = profile;
    }

    public void setUtente(Utente utente) {
        this.utente = utente;
    }

}
