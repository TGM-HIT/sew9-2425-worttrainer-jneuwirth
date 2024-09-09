import java.util.Random;

public class WortTrainer {
    private WortPaar[] wortPaar;
    private int index;
    private int falsch;
    private int richtig;
    private boolean voriges_ergebniss;

    public WortTrainer(WortPaar[] wortPaar) {
        this.wortPaar = wortPaar;
        this.index = -1;
        this.falsch = 0;
        this.richtig = 0;
        this.voriges_ergebniss = false;
    }

    public int randomIndex() {
        Random random = new Random();
        int i = random.nextInt(this.wortPaar.length);
        this.index = i;
        return i;
    }

    public boolean raten(String i) {
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
        int zahl = this.index;
        int zahl1 = this.randomIndex();
        while(zahl == zahl1) {
            zahl1 = this.randomIndex();
        }
        return wahr;
    }

    public WortPaar[] getWortPaar() {
        return wortPaar;
    }

    public void setWortPaar(WortPaar[] wortPaar) {
        this.wortPaar = wortPaar;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public int getFalsch() {
        return falsch;
    }


    public int getRichtig() {
        return richtig;
    }

    public boolean isVoriges_ergebniss() {
        return voriges_ergebniss;
    }

}
