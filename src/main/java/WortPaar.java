import org.apache.commons.validator.routines.UrlValidator;

public class WortPaar {
    private String wort;
    private String url;

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

    public void setWort(String wort) {
        UrlValidator urlValidator = new UrlValidator();
        if(wort != null) {
            this.wort = wort;
        }else{
            this.wort = "";
        }
    }

    public void setUrl(String url) {
        UrlValidator urlValidator = new UrlValidator();
        if(url != null && urlValidator.isValid(url)) {
            this.url = url;
        }else {
            this.url = "";
        }
    }

    public String getWort() {
        return this.wort;
    }

    public String getUrl() {
        return this.url;
    }


}
