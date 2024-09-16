/**
 * Das ist das Interface WortTrainerSpeichern
 * @author Julian Neuwrith
 * @version 2024-09-16
 */
public interface WortTrainerSpeichern {
    /**
     * Diese methode ist zum Speichern der KlasseWortTrainer da
     * @param wort
     * @param i name des Files
     */
    void speichern(WortTrainer wort, String i);

    /**
     * Diese methode läd den Worttrainer
     * @param i
     * @return Worttrainer
     */
    WortTrainer laden(String i);

}
