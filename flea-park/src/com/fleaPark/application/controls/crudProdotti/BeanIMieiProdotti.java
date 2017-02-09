/*
 * 
 * Created by Umberto Ferracci from urania's PC
 * email: umberto.ferracci@gmail.com
 * Project: fleaPark
 * Package: com.fleaPark.application.controls.crudProdotti
 * Type: BeanIMieiProdotti
 * Last update: 9-feb-2017 0.19.40
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

    private int utenteId;

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

    public int getUtenteId() {
        return utenteId;
    }

    public void prendiProdotti() {
        Message4Debug.log("idUtente \t\t\t" + utenteId);
        C_UC_Prodotti controller = new C_UC_Prodotti();
        List<Prodotto> prodotti = controller.prendiProdotti(1);
        for (Prodotto p : prodotti) {
            BeanIMieiProdotti b = new BeanIMieiProdotti();
            b.utenteId = utenteId;
            b.prodottoDescrizione = p.getDescrizione();
            b.prodottoId = p.getIdProdotto();
            b.prodottoPrezzo = p.getPrezzo();
            b.prodottoNome = p.getNome();
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

    public void setUtenteId(int utenteId) {
        this.utenteId = utenteId;
    }

    public static void main(String[] args) {
        BeanIMieiProdotti iMiei = new BeanIMieiProdotti();
        iMiei.setUtenteId(3);
        iMiei.prendiProdotti();
        List<BeanIMieiProdotti> list = iMiei.getiMieiProdotti();
        for (BeanIMieiProdotti b : list) {
            Message4Debug.log("" + b.getProdottoNome() + " ");
        }
    }

}
