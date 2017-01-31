/*
 * 
 * Created by Umberto Ferracci from urania's PC
 * email: umberto.ferracci@gmail.com
 * Project: fleaPark
 * Package: com.fleaPark.application.beans
 * Type: BeanDiAccesso
 * Last update: 31-gen-2017 18.10.48
 * 
 */
package com.fleaPark.application.beans;

import com.fleaPark.application.controls.C_UC_Access;
import com.fleaPark.model.people.Utente;
import com.fleaPark.tools.debug.Message4Debug;

public class BeanDiAccesso {
    private int idUtente;

    private String nome;

    private String cognome;

    private String password;

    private String email;

    public boolean accedi() {
        C_UC_Access controller = new C_UC_Access();
        Utente user = controller.accedi(email, password);
        if (user != null) {
            nome = user.getNome();
            cognome = user.getCognome();
            email = user.getEmail();
            password = user.getPassword();
            idUtente = user.getIdUtente();
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
        Message4Debug.log("registrazione in corso...");
        C_UC_Access controller = new C_UC_Access();
        controller.registrati(nome, cognome, email, password);
        Message4Debug.log("registrato");
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public void setEmail(String email) {
        this.email = email;
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
