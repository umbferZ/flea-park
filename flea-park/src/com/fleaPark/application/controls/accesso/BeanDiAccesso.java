/*
 * 
 * Created by Umberto Ferracci from urania's PC
 * email: umberto.ferracci@gmail.com
 * Project: fleaPark
 * Package: com.fleaPark.application.controls.accesso
 * Type: BeanDiAccesso
 * Last update: 10-feb-2017 18.13.15
 * 
 */
package com.fleaPark.application.controls.accesso;

import com.fleaPark.model.people.Utente;

public class BeanDiAccesso {
    private String cognome;

    private String email;

    private String fotoCopertina;

    private String fotoProfilo;

    private int idUtente;
    private String nome;
    private String password;

    public boolean accedi() {
        C_UC_Access controller = new C_UC_Access();
        Utente user = controller.accedi(email, password);
        if (user != null) {
            nome = user.getNome();
            cognome = user.getCognome();
            email = user.getEmail();
            password = user.getPassword();
            idUtente = user.getIdUtente();
            fotoCopertina = user.getUtenteInfo().getCopertina().getNome();
            fotoProfilo = user.getUtenteInfo().getProfilo().getNome();
            return true;
        }
        return false;
    }

    public String getCognome() {
        return cognome;
    }

    public String getEmail() {
        return email;
    }

    public String getFotoCopertina() {
        return fotoCopertina;
    }

    public String getFotoProfilo() {
        return fotoProfilo;
    }

    public int getIdUtente() {
        return idUtente;
    }

    public String getNome() {
        return nome;
    }

    public String getPassword() {
        return password;
    }

    public void registrati() {
        C_UC_Access controller = new C_UC_Access();
        controller.registrati(nome, cognome, email, password);
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setFotoCopertina(String fotoCopertina) {
        this.fotoCopertina = fotoCopertina;
    }

    public void setFotoProfilo(String fotoProfilo) {
        this.fotoProfilo = fotoProfilo;
    }

    public void setIdUtente(int idUtente) {
        this.idUtente = idUtente;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
