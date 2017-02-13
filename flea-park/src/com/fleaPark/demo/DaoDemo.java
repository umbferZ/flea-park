/*
 * 
 * Created by Umberto Ferracci from urania's PC
 * email: umberto.ferracci@gmail.com
 * Project: fleaPark
 * Package: com.fleaPark.demo
 * Type: DaoDemo
 * Last update: 13-feb-2017 7.07.17
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
            info.setFotoProfilo(new Foto(profili[((int) (Math.random() * 1268)) % profili.length], ""));
            info.setFotoCopertina(new Foto("http://i.ndtvimg.com/i/2015-11/pirates-of-the-caribbean_640x480_41447300092.jpg", ""));
            u.setUtenteInfo(info);
            factory.getUtenteDao().insert(u);
        }
        utenti = factory.getUtenteDao().getAll();

        /*
         * Creazione prodotti
         */
        List<String> descrizioni = new ArrayList<>();
        descrizioni.add(
                "Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Donec quam felis, ultricies nec, pellentesque eu, pretium quis, sem. Nulla consequat massa quis enim. Donec pede justo, fringilla vel, aliquet nec, vulputate eget, arcu. In enim justo, rhoncus ut, imperdiet a, venenatis vitae, justo. Nullam dictum felis eu pede mollis pretium. Integer tincidunt. Cras dapibus. Vivamus elementum semper nisi. Aenean vulputate eleifend tellus. Aenean leo ligula, porttitor eu, consequat vitae, eleifend ac, enim. Aliquam lorem ante, dapibus in, viverra quis, feugiat a, tellus. Phasellus viverra nulla ut metus varius laoreet. Quisque rutrum. Aenean imperdiet. Etiam ultricies nisi vel augue. Curabitur ullamcorper ultricies nisi. Nam eget dui. Etiam rhoncus. Maecenas tempus, tellus eget condimentum rhoncus, sem quam semper libero, sit amet adipiscing sem neque sed ipsum. Nam quam nunc, blandit vel, luctus pulvinar, hendrerit id, lorem. Maecenas nec odio et ante tincidunt tempus. Donec vitae sapien ut libero venenatis faucibus. Nullam quis ante. Etiam sit amet orci eget eros faucibus tincidunt. Duis leo. Sed fringilla mauris sit amet nibh. Donec sodales sagittis magna. Sed consequat, leo eget bibendum sodales, augue velit cursus nunc,");
        descrizioni.add(
                "Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam, eaque ipsa quae ab illo inventore veritatis et quasi architecto beatae vitae dicta sunt explicabo. Nemo enim ipsam voluptatem quia voluptas sit aspernatur aut odit aut fugit, sed quia consequuntur magni dolores eos qui ratione voluptatem sequi nesciunt. Neque porro quisquam est, qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit, sed quia non numquam eius modi tempora incidunt ut labore et dolore magnam aliquam quaerat voluptatem. Ut enim ad minima veniam, quis nostrum exercitationem ullam corporis suscipit laboriosam, nisi ut aliquid ex ea commodi consequatur? Quis autem vel eum iure reprehenderit qui in ea voluptate velit esse quam nihil molestiae consequatur, vel illum qui dolorem eum fugiat quo voluptas nulla pariatur? At vero eos et accusamus et iusto odio dignissimos ducimus qui blanditiis praesentium voluptatum deleniti atque corrupti quos dolores et quas molestias excepturi sint occaecati cupiditate non provident, similique sunt in culpa qui officia deserunt mollitia animi, id est laborum et dolorum fuga. Et harum quidem rerum facilis est et expedita distinctio. Nam libero tempore, cum soluta nobis est eligendi optio cumque nihil impedit quo minus id quod maxime placeat facere");
        descrizioni.add(
                "But I must explain to you how all this mistaken idea of denouncing pleasure and praising pain was born and I will give you a complete account of the system, and expound the actual teachings of the great explorer of the truth, the master-builder of human happiness. No one rejects, dislikes, or avoids pleasure itself, because it is pleasure, but because those who do not know how to pursue pleasure rationally encounter consequences that are extremely painful. Nor again is there anyone who loves or pursues or desires to obtain pain of itself, because it is pain, but because occasionally circumstances occur in which toil and pain can procure him some great pleasure. To take a trivial example, which of us ever undertakes laborious physical exercise, except to obtain some advantage from it? But who has any right to find fault with a man who chooses to enjoy a pleasure that has no annoying consequences, or one who avoids a pain that produces no resultant pleasure? On the other hand, we denounce with righteous indignation and dislike men who are so beguiled and demoralized by the charms of pleasure of the moment, so blinded by desire, that they cannot foresee");
        descrizioni.add(
                "Li Europan lingues es membres del sam familie. Lor separat existentie es un myth. Por scientie, musica, sport etc, litot Europa usa li sam vocabular. Li lingues differe solmen in li grammatica, li pronunciation e li plu commun vocabules. Omnicos directe al desirabilite de un nov lingua franca: On refusa continuar payar custosi traductores. At solmen va esser necessi far uniform grammatica, pronunciation e plu sommun paroles. Ma quande lingues coalesce, li grammatica del resultant lingue es plu simplic e regulari quam ti del coalescent lingues. Li nov lingua franca va esser plu simplic e regulari quam li existent Europan lingues. It va esser tam simplic quam Occidental in fact, it va esser Occidental. A un Angleso it va semblar un simplificat Angles, quam un skeptic Cambridge amico dit me que Occidental es.Li Europan lingues es membres del sam familie. Lor separat existentie es un myth. Por scientie, musica, sport etc, litot Europa usa li sam vocabular. Li lingues differe solmen in li grammatica, li pronunciation e li plu commun vocabules. Omnicos directe al desirabilite de un nov lingua franca: On refusa continuar payar custosi traductores. At solmen va esser necessi far uniform grammatica, pronunciation e plu sommun paroles.");
        descrizioni.add(
                "The European languages are members of the same family. Their separate existence is a myth. For science, music, sport, etc, Europe uses the same vocabulary. The languages only differ in their grammar, their pronunciation and their most common words. Everyone realizes why a new common language would be desirable: one could refuse to pay expensive translators. To achieve this, it would be necessary to have uniform grammar, pronunciation and more common words. If several languages coalesce, the grammar of the resulting language is more simple and regular than that of the individual languages. The new common language will be more simple and regular than the existing European languages. It will be as simple as Occidental; in fact, it will be Occidental. To an English person, it will seem like simplified English, as a skeptical Cambridge friend of mine told me what Occidental is.The European languages are members of the same family. Their separate existence is a myth. For science, music, sport, etc, Europe uses the same vocabulary. The languages only differ in their grammar, their pronunciation and their most common words. Everyone realizes why a new common language would be desirable: one could refuse to pay expensive translators. To ");
        descrizioni.add(
                "Far far away, behind the word mountains, far from the countries Vokalia and Consonantia, there live the blind texts. Separated they live in Bookmarksgrove right at the coast of the Semantics, a large language ocean. A small river named Duden flows by their place and supplies it with the necessary regelialia. It is a paradisematic country, in which roasted parts of sentences fly into your mouth. Even the all-powerful Pointing has no control about the blind texts it is an almost unorthographic life One day however a small line of blind text by the name of Lorem Ipsum decided to leave for the far World of Grammar. The Big Oxmox advised her not to do so, because there were thousands of bad Commas, wild Question Marks and devious Semikoli, but the Little Blind Text didn’t listen. She packed her seven versalia, put her initial into the belt and made herself on the way. When she reached the first hills of the Italic Mountains, she had a last view back on the skyline of her hometown Bookmarksgrove, the headline of Alphabet Village and the subline of her own road, the Line Lane. Pityful a rethoric question ran over her cheek, then ");
        descrizioni.add(
                "A wonderful serenity has taken possession of my entire soul, like these sweet mornings of spring which I enjoy with my whole heart. I am alone, and feel the charm of existence in this spot, which was created for the bliss of souls like mine. I am so happy, my dear friend, so absorbed in the exquisite sense of mere tranquil existence, that I neglect my talents. I should be incapable of drawing a single stroke at the present moment; and yet I feel that I never was a greater artist than now. When, while the lovely valley teems with vapour around me, and the meridian sun strikes the upper surface of the impenetrable foliage of my trees, and but a few stray gleams steal into the inner sanctuary, I throw myself down among the tall grass by the trickling stream; and, as I lie close to the earth, a thousand unknown plants are noticed by me: when I hear the buzz of the little world among the stalks, and grow familiar with the countless indescribable forms of the insects and flies, then I feel the presence of the Almighty, who formed us in his own image, and the breath ");

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
                if ((((int) (Math.random() * 500)) % 7) == 3) {
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
