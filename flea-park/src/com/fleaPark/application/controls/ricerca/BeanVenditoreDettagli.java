package com.fleaPark.application.controls.ricerca;

import com.fleaPark.tools.debug.Message4Debug;

public class BeanVenditoreDettagli {
    private int prodottoId;
    private int venditoreId;
    private String venditoreNome;
    private String venditoreCognome;

    public String getVenditoreCognome() {
        return venditoreCognome;
    }

    public void setVenditoreCognome(String venditoreCognome) {
        this.venditoreCognome = venditoreCognome;
    }

    public int getProdottoId() {
        return prodottoId;
    }

    public void setProdottoId(int prodottoId) {
        this.prodottoId = prodottoId;
    }

    public int getVenditoreId() {
        return venditoreId;
    }

    public void setVenditoreId(int venditoreId) {
        this.venditoreId = venditoreId;
    }

    public String getVenditoreNome() {
        return venditoreNome;
    }

    public void setVenditoreNome(String venditoreNome) {
        this.venditoreNome = venditoreNome;
    }

    public void validate() {
        Message4Debug.log("\t\t\t\t\tprodottoID by bean: " + prodottoId);
        C_UC_Ricerca controller = new C_UC_Ricerca();
        BeanVenditoreDettagli beanVD = controller.getVenditoreByProdottoId(prodottoId);
        this.venditoreCognome = beanVD.venditoreCognome;
        this.venditoreId = beanVD.prodottoId;
        this.venditoreNome = beanVD.venditoreNome;

    }
}
