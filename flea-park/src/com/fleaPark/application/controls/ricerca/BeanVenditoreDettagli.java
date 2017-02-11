/*
 * 
 * Created by Umberto Ferracci from urania's PC
 * email: umberto.ferracci@gmail.com
 * Project: fleaPark
 * Package: com.fleaPark.application.controls.ricerca
 * Type: BeanVenditoreDettagli
 * Last update: 10-feb-2017 18.13.15
 * 
 */
package com.fleaPark.application.controls.ricerca;

import com.fleaPark.tools.debug.Message4Debug;

public class BeanVenditoreDettagli {
    private int prodottoId;
    private String venditoreCognome;
    private String venditoreFoto;
    private int venditoreId;
    private String venditoreNome;

    public int getProdottoId() {
        return prodottoId;
    }

    public String getVenditoreCognome() {
        return venditoreCognome;
    }

    public String getVenditoreFoto() {
        return venditoreFoto;
    }

    public int getVenditoreId() {
        return venditoreId;
    }

    public String getVenditoreNome() {
        return venditoreNome;
    }

    public void setProdottoId(int prodottoId) {
        this.prodottoId = prodottoId;
    }

    public void setVenditoreCognome(String venditoreCognome) {
        this.venditoreCognome = venditoreCognome;
    }

    public void setVenditoreFoto(String venditoreFoto) {
        this.venditoreFoto = venditoreFoto;
    }

    public void setVenditoreId(int venditoreId) {
        this.venditoreId = venditoreId;
    }

    public void setVenditoreNome(String venditoreNome) {
        this.venditoreNome = venditoreNome;
    }

    public void validate() {
        C_UC_Ricerca controller = new C_UC_Ricerca();
        BeanVenditoreDettagli beanVD = controller.getVenditoreByProdottoId(prodottoId);
        venditoreCognome = beanVD.venditoreCognome;
        venditoreId = beanVD.prodottoId;
        venditoreNome = beanVD.venditoreNome;
        venditoreFoto = beanVD.venditoreFoto;
    }
}
