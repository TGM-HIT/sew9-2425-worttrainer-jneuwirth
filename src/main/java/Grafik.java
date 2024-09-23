import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Diese Klasse setzt die Grafik für das Programm um
 * @author Julian Neuwirth
 * @version 2024-09-17
 */
public class Grafik {
    /**
     * Das ist die Main Methode
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        WortTrainer trainer = new WortTrainer(DataFormat.JSON);
        trainer.laden();
        trainer.randomIndex();
        boolean wahr = true;
        while(wahr) {
            String statistik = "";
            if((trainer.getRichtig() + trainer.getFalsch()) == 0) {
                statistik = "Richtig: " + trainer.getRichtig() + " Falsch: " + trainer.getFalsch() + " Gesamt: " + (trainer.getFalsch() + trainer.getRichtig());
            }else {
                statistik = "Richtig: " + trainer.getRichtig() + " Falsch: " + trainer.getFalsch() + " Gesamt: " + (trainer.getFalsch() + trainer.getRichtig()) + " Wert voriges: " + trainer.isVoriges_ergebniss();
            }

            URL url = new URL(trainer.bildbekommen());
            BufferedImage originalBild = ImageIO.read(url);
            Image skalierteBild = originalBild.getScaledInstance(200, 200, Image.SCALE_SMOOTH);
            ImageIcon bild = new ImageIcon(skalierteBild);
            String wert = (String) JOptionPane.showInputDialog(null, statistik, "Schreibe das Wort",JOptionPane.QUESTION_MESSAGE,bild,null,"");
            trainer.eingabe(wert);
            if(wert.equals("")) {
                wahr = false;
            }
        }
        WortPaar paar1 = new WortPaar("Hund","https://www.kastner-oehler.at/steiff-soft+cuddly+friends+snuffy+hund+27cm-1-768_1024_75-7545093_1.jpg");
        WortPaar paar2 = new WortPaar("Katze","https://pixnio.com/free-images/2017/02/09/2017-02-09-19-43-32.jpg");
        WortPaar paar3 = new WortPaar("Adler","https://hintergrundbild.org/wallpaper/full/6/8/a/93703-beautiful-adler-hintergrundbilder-3840x2160-ipad-pro.jpg");
        WortPaar[] liste = new WortPaar[3];
        liste[0] = paar1;
        liste[1] = paar2;
        liste[2] = paar3;
        trainer.setWortPaar(liste);
        trainer.speichern();

    }
}
