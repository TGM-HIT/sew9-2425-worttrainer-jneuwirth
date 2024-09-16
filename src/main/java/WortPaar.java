import org.apache.commons.validator.routines.UrlValidator;

/**
 * Diese Klasse bildet die Wortpaare mit denen der Worttrainer arbeitet
 * @author Julian Neuwirth
 * @version 2024-09-09
 */
public class WortPaar {
    private String wort;
    private String url;

    /**
     * Standard Konstruktor fürs Speichern
     */
    public WortPaar() {

    }

    /**
     * Das ist der Konstruktor
     * @param wort
     * @param url
     */
    public WortPaar(String wort, String url) {
        UrlValidator urlValidator = new UrlValidator();
        if(wort != null) {
            this.wort = wort;
        }else{
            this.wort = "";
        }
        if(url != null && urlValidator.isValid(url)) {
            this.url = url;
        }else {
            this.url = "";
        }

    }

    /**
     * Hier kann ich das Wort setzen
     * @param wort
     */
    public void setWort(String wort) {
        UrlValidator urlValidator = new UrlValidator();
        if(wort != null) {
            this.wort = wort;
        }else{
            this.wort = "";
        }
    }

    /**
     * Hier kann ich die Url zurück geben
     * @param url
     */
    public void setUrl(String url) {
        UrlValidator urlValidator = new UrlValidator();
        if(url != null && urlValidator.isValid(url)) {
            this.url = url;
        }else {
            this.url = "";
        }
    }

    /**
     * getter für wort
     * @return wort
     */
    public String getWort() {
        return this.wort;
    }

    /**
     * getter für url
     * @return url
     */
    public String getUrl() {
        return this.url;
    }


}
