import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;

/**
 * Hier wird die ganze Arbeit getestet
 * @author Julian Neuwirth
 * @version 2024-09-09
 */
public class Testen {


    /**
     * Hier Teste ich das Modell
     */
    @Test
    @DisplayName("Diese Methode Testet das Model")
    void worttrainertest() {
        WortPaar paar1 = new WortPaar("Hund","https://www.kastner-oehler.at/steiff-soft+cuddly+friends+snuffy+hund+27cm-1-768_1024_75-7545093_1.jpg");
        WortPaar paar2 = new WortPaar(null,"https://www.kastner-oehler.at/steiff-soft+cuddly+friends+snuffy+hund+27cm-1-768_1024_75-7545093_1.jpg");
        WortPaar paar3 = new WortPaar("Hund","irgendwas");
        WortPaar paar4 = new WortPaar("Katze","https://pixnio.com/free-images/2017/02/09/2017-02-09-19-43-32.jpg");
        Assertions.assertTrue(paar1.getWort().equals("Hund"));
        Assertions.assertTrue(paar1.getUrl().equals("https://www.kastner-oehler.at/steiff-soft+cuddly+friends+snuffy+hund+27cm-1-768_1024_75-7545093_1.jpg"));
        Assertions.assertTrue(paar2.getWort().equals(""));
        Assertions.assertTrue(paar3.getUrl().equals(""));

        WortPaar[] liste = new WortPaar[2];
        liste[0] = paar1;
        liste[1] = paar4;
        WortTrainer trainer = new WortTrainer(liste);
        Assertions.assertTrue(trainer.eingabe("Hund"));
        Assertions.assertTrue(trainer.eingabe("Katze"));

        // speichern Testen
        WortTrainer trainer1 = new WortTrainer(liste);
        WortTrainer trainer2 = new WortTrainer();
        trainer1.speichern();
        trainer2.laden();
        Assertions.assertTrue(trainer2.getWortPaar()[0].getWort().equals("Hund"));
        Assertions.assertTrue(trainer2.getWortPaar()[1].getWort().equals("Katze"));

    }



}
