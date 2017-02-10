/*
 * 
 * Created by Umberto Ferracci from urania's PC
 * email: umberto.ferracci@gmail.com
 * Project: fleaPark
 * Package: com.fleaPark.application.controls.crudProdotti
 * Type: BeanIMieiProdotti
 * Last update: 10-feb-2017 12.15.04
 * 
 */
package com.fleaPark.application.controls.crudProdotti;

import java.util.ArrayList;
import java.util.List;

import com.fleaPark.model.products.Prodotto;
import com.fleaPark.tools.debug.Message4Debug;

public class BeanIMieiProdotti {
    private List<BeanIMieiProdotti> iMieiProdotti = new ArrayList<>();

    private String prodottoDescrizione;

    private int prodottoId;

    private String prodottoNome;
    private double prodottoPrezzo;
    private String prodottoValuta;

    private int utenteId;

    public static void main(String[] args) {
        BeanIMieiProdotti iMiei = new BeanIMieiProdotti();
        iMiei.setUtenteId(3);
        iMiei.prendiProdotti();
        List<BeanIMieiProdotti> list = iMiei.getiMieiProdotti();
        for (BeanIMieiProdotti b : list)
            Message4Debug.log("" + b.getProdottoNome() + " ");
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
            b.prodottoValuta = p.getPrezzo().getValuta().name();
            iMieiProdotti.add(b);
        }

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

}
