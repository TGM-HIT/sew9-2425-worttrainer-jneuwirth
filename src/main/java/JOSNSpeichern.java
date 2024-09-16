import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class JOSNSpeichern implements WortTrainerSpeichern{

    @Override
    public void speichern(WortTrainer wort, String i) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            // Objekt in JSON speichern
            objectMapper.writeValue(new File(i), wort);
            System.out.println("Der WortTrainer wurde erfolgreich in JSON gespeichert.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public WortTrainer laden(String i) {
        ObjectMapper objectMapper = new ObjectMapper();
        WortPaar paar1 = new WortPaar("Hund","https://www.kastner-oehler.at/steiff-soft+cuddly+friends+snuffy+hund+27cm-1-768_1024_75-7545093_1.jpg");
        WortPaar paar2 = new WortPaar(null,"https://www.kastner-oehler.at/steiff-soft+cuddly+friends+snuffy+hund+27cm-1-768_1024_75-7545093_1.jpg");
        WortPaar[] liste = new WortPaar[2];
        liste[0] = paar1;
        liste[1] = paar2;
        WortTrainer trainer = new WortTrainer(liste);
        try {
            // JSON in ein Person-Objekt umwandeln
            trainer = objectMapper.readValue(new File(i), WortTrainer.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return trainer;
    }
}
