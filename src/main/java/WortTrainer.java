import java.util.Random;


/**
 * Diese klasse ist ein Worttrainer für Volksschulkinder
 * @author Julian Neuwirth
 * @version 2024-09-09
 */
public class WortTrainer {
    private WortPaar[] wortPaar;
    private int index;
    private int falsch;
    private int richtig;
    private boolean voriges_ergebniss;
    private WortTrainerSpeichern speichern;



    /**
     * Standard Konstruktor fürs Speichern
     */
    public WortTrainer() {
        this.index = -1;
        this.falsch = 0;
        this.richtig = 0;
        this.voriges_ergebniss = false;
        this.speichern = new JOSNSpeichern();
    }

    /**
     * Das ist der Konstruktor
     * @param wortPaar
     */
    public WortTrainer(WortPaar[] wortPaar) {
        this.wortPaar = wortPaar;
        this.index = -1;
        this.falsch = 0;
        this.richtig = 0;
        this.voriges_ergebniss = false;
        this.speichern = new JOSNSpeichern();
    }

    /**
     * Hier wird ein Random index von der liste ausgewählt
     * @return den index
     */
    public int randomIndex() {
        Random random = new Random();
        int zahl = this.index;
        int i = random.nextInt(this.wortPaar.length);
        while(zahl == i) {
            i = random.nextInt(this.wortPaar.length);
        }
        this.index = i;
        return i;
    }

    /**
     * In dieser Methode wird die Angabe der Wörte überprüft
     * @param i der eingebene Text
     * @return ob es richtig oder falsch war
     */
    public boolean eingabe(String i) {
        if(this.index == -1) {
            this.index = 0;
        }
        boolean wahr = false;
        if(this.wortPaar[this.index].getWort().equals(i)) {
            wahr = true;
            this.richtig++;
            this.voriges_ergebniss = true;
        }else {
            this.falsch++;
            this.voriges_ergebniss = false;
        }
        this.randomIndex();
        return wahr;
    }

    public String bildbekommen() {
        if(this.index >= 0) {
            return this.wortPaar[this.index].getUrl();
        }else {
            return this.wortPaar[0].getUrl();
        }

    }

    /**
     * Das ist die getter für WortPaare
     * @return WortPaare
     */
    public WortPaar[] getWortPaar() {
        return wortPaar;
    }

    /**
     * hier stetzt man Wortpaar
     * @param wortPaar
     */
    public void setWortPaar(WortPaar[] wortPaar) {
        this.wortPaar = wortPaar;
    }

    /**
     * getter für Index
     * @return den index
     */
    public int getIndex() {
        return index;
    }

    /**
     * setter für Index
     * @param index
     */
    public void setIndex(int index) {
        this.index = index;
    }

    /**
     * getter für Falsch
     * @return flasch
     */
    public int getFalsch() {
        return falsch;
    }

    /**
     * getter für richtig
     * @return richtig
     */
    public int getRichtig() {
        return richtig;
    }

    /**
     * gibt den vorigen wert zurück
     * @return vorigen wert
     */
    public boolean isVoriges_ergebniss() {
        return voriges_ergebniss;
    }

    /**
     * Diese Methode ist zum speichern da
     */
    public void speichern() {
        this.speichern.speichern(this,"woerter.json");
    }

    /**
     * Diese Methode ist zum laden da
     */
    public void laden() {
        WortTrainer i = this.speichern.laden("woerter.json");
        this.wortPaar = i.wortPaar;
        this.index = i.index;
        this.falsch = i.falsch;
        this.richtig = i.richtig;
        this.voriges_ergebniss = i.voriges_ergebniss;
    }
}
