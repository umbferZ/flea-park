/*
 * 
 * Created by Umberto Ferracci from urania's PC
 * email: umberto.ferracci@gmail.com
 * Project: fleaPark
 * Package: com.fleaPark.demo
 * Type: DaoDemo
 * Last update: 13-feb-2017 4.41.54
 * 
 */
package com.fleaPark.demo;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import com.fleaPark.model.DaoFactory;
import com.fleaPark.model.media.Foto;
import com.fleaPark.model.people.Utente;
import com.fleaPark.model.people.UtenteInfo;
import com.fleaPark.model.products.Categoria;
import com.fleaPark.model.products.Prezzo;
import com.fleaPark.model.products.Prodotto;
import com.fleaPark.model.products.Valuta;

public class DaoDemo {
    public static void main(String[] args) {
        DaoFactory factory = DaoFactory.getInstance();
        /*
         * Import Nazione, Regione, Province, Comuni, Categorie
         */
        factory.getNazioneDao().importDump();
        factory.getRegioneDao().importDump();
        factory.getProvinciaDao().importDump();
        factory.getComuneDao().importDump();
        factory.getCategoriaDao().importDump();
        List<Categoria> list = factory.getCategoriaDao().getAll();
        list = factory.getCategoriaDao().getAll();
        /*
         * Creazione utenti
         */
        String[] profili = { "http://www.memic.net/sfondi/images/desktop/natura/01950_palmontheleft_1680x1050.jpg", "http://i.skyrock.net/0249/86600249/pics/3140944750_1_2_CTqUfNme.jpg", "http://biografieonline.it/img/bio/box/o/Otis_Redding.jpg",
                "https://dailybestecn.nohup.it/wp-content/uploads/2012/04/ditoVendola.jpeg", "http://1.bp.blogspot.com/_7WHkz6KpLkk/TEx0OP9288I/AAAAAAAAAHg/LmqOLfx04L8/s1600/Checco+Zalone.jpg" };
        List<Utente> utenti = new ArrayList<>();
        utenti.add(new Utente("Jack", "Sparrow", "jack@sparrow", "js"));
        utenti.add(new Utente("Hector", "Barbossa", "hector@barbossa", "p"));
        utenti.add(new Utente("Will", "Turner", "will@turner", "p"));
        utenti.add(new Utente("Elizabeth", "Swann", "elizabeth@swann", "p"));
        utenti.add(new Utente("Tia", "Dalma", "tia@dalma", "p"));
        utenti.add(new Utente("Sao", "Feng", "sao@feng", "p"));
        for (Utente u : utenti) {
            UtenteInfo info = new UtenteInfo();
            info.setProfilo(new Foto(profili[((int) (Math.random() * 1268)) % profili.length], ""));
            info.setCopertina(new Foto("http://i.ndtvimg.com/i/2015-11/pirates-of-the-caribbean_640x480_41447300092.jpg", ""));
            u.setUtenteInfo(info);
            factory.getUtenteDao().insert(u);
        }
        utenti = factory.getUtenteDao().getAll();

        /*
         * Creazione prodotti
         */
        List<String> descrizioni = new ArrayList<>();
        descrizioni.add("");
        descrizioni.add("");
        descrizioni.add("");
        descrizioni.add("");
        descrizioni.add("");
        descrizioni.add("");
        double d;
        Prezzo pr;
        for (Categoria c : list)
            for (int i = 0; i < 10; i++) {
                d = ((double) ((i * 112722) % 473) + (int) (Math.random() * 1489)) + 0.29;
                switch (i % 4) {
                    case 0:
                        pr = new Prezzo(d, Valuta.EUR);
                        break;
                    case 1:
                        pr = new Prezzo(d, Valuta.GBP);
                        break;
                    case 2:
                        pr = new Prezzo(d, Valuta.FJD);
                        break;
                    default:
                        pr = new Prezzo(d, Valuta.DOLLAR);

                }
                List<Foto> gallery = new ArrayList<>();
                gallery.add(new Foto("https://upload.wikimedia.org/wikipedia/commons/0/08/Gran_Torino.jpg", ""));
                gallery.add(new Foto("https://ccpublic.blob.core.windows.net/cc-temp/listing/91/574/3348923-1973-ford-gran-torino-std.jpg", ""));
                gallery.add(new Foto("http://www.fordcarsinfo.com/wp-content/uploads/2016/01/1967-ford-mustang-gt-500.jpg", ""));
                gallery.add(new Foto("http://roa.h-cdn.co/assets/cm/14/47/980x551/546b4f041be7b_-_2015-mustang-gt-010-lg.jpg", ""));
                gallery.add(new Foto("http://pictures.topspeed.com/IMG/crop/201604/ford-mustang-gt-820--13_800x0w.jpg", ""));
                gallery.add(new Foto("http://assets.nydailynews.com/polopoly_fs/1.1948350.1411403259!/img/httpImage/image.jpg_gen/derivatives/article_750/2015-ford-mustang-gt-front-3-4.jpg", ""));

                Prodotto p = new Prodotto();
                p.setNome("prodotto " + i + " di " + c.getNome());
                p.setCategoria(c);
                p.setVenditore(utenti.get(i % utenti.size()));
                if ((((int) (Math.random() * 1547)) % 159) == 7) {
                    p.setAcquirente(utenti.get(((i * i) + 519) % utenti.size()));
                    p.setDataAcquisto(Calendar.getInstance());
                }
                p.setDataInserimento(Calendar.getInstance());
                p.setDescrizione(descrizioni.get(((i * i) + 235) % descrizioni.size()));
                p.setPrezzo(pr);
                p.setFoto(gallery);
                factory.getProdottoDao().insert(p);
            }
    }
}
