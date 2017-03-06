/*
 * 
 * Created by Umberto Ferracci from urania's PC
 * email: umberto.ferracci@gmail.com
 * Project: fleaPark
 * Package: com.fleaPark.application.controls.crudProdotti
 * Type: BeanIMieiProdotti
 * Last update: 25-feb-2017 18.25.43
 * 
 */
package com.fleaPark.application.controls.crudProdotti;

import java.util.ArrayList;
import java.util.List;

import org.umbZfer.debug.Message4Debug;

import com.fleaPark.model.products.Prodotto;

public class BeanIMieiProdotti {
    
    private List<BeanIMieiProdotti> iMieiProdotti = new ArrayList<>();

    private String prodottoDescrizione;
    private int prodottoId;

    private String prodottoNome;

    private double prodottoPrezzo;

    private String prodottoValuta;
    private int utenteId;
    private boolean venduto;
    private String categoria;

    public String getCategoria() {
        return categoria;
    }

    public List<BeanIMieiProdotti> getiMieiProdotti() {
        return iMieiProdotti;
    }

    public String getProdottoDescrizione() {
        return prodottoDescrizione;
    }

    public int getProdottoId() {
        return prodottoId;
    }

    public String getProdottoNome() {
        return prodottoNome;
    }

    public double getProdottoPrezzo() {
        return prodottoPrezzo;
    }

    public String getProdottoValuta() {
        return prodottoValuta;
    }

    public int getUtenteId() {
        return utenteId;
    }

    public boolean isVenduto() {
        return venduto;
    }

    public void prendiProdotti() {
        Message4Debug.log("idUtente \t\t\t" + utenteId);
        C_UC_GestioneProdotto controller = new C_UC_GestioneProdotto();
        List<Prodotto> prodotti = controller.prendiProdotti(utenteId);
        for (Prodotto p : prodotti) {
            BeanIMieiProdotti b = new BeanIMieiProdotti();
            b.utenteId = utenteId;
            b.prodottoDescrizione = p.getDescrizione();
            b.prodottoId = p.getId();
            b.prodottoPrezzo = p.getPrezzo().getValore();
            b.prodottoNome = p.getNome();
            b.prodottoValuta = p.getPrezzo().getValuta().toString();
            b.venduto = p.getAcquirente() == null ? false : true;
            b.categoria = p.getCategoria().getNome();
            iMieiProdotti.add(b);
        }

    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public void setiMieiProdotti(List<BeanIMieiProdotti> iMieiProdotti) {
        this.iMieiProdotti = iMieiProdotti;
    }

    public void setProdottoDescrizione(String prodottoDescrizione) {
        this.prodottoDescrizione = prodottoDescrizione;
    }

    public void setProdottoId(int prodottoId) {
        this.prodottoId = prodottoId;
    }

    public void setProdottoNome(String prodottoNome) {
        this.prodottoNome = prodottoNome;
    }

    public void setProdottoPrezzo(double prodottoPrezzo) {
        this.prodottoPrezzo = prodottoPrezzo;
    }

    public void setProdottoValuta(String prodottoValuta) {
        this.prodottoValuta = prodottoValuta;
    }

    public void setUtenteId(int utenteId) {
        this.utenteId = utenteId;
    }

    public void setVenduto(boolean venduto) {
        this.venduto = venduto;
    }

}
