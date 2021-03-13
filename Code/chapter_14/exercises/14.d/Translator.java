import java.util.Locale;
import java.util.ResourceBundle;

public class Translator {

    private LanguageEnum language;
    
    private ResourceBundle resources;
    
    public Translator (LanguageEnum language){
        this.language = language;
        String keyLanguage = language.getKey();
        Locale locale = new Locale(keyLanguage);
        resources = ResourceBundle.getBundle("resources.vocabulary", locale);
    }

    public String translate(WordsEnum text) {
        String translation = resources.getString(text.getKey());
        return translation;
    }

    public void setLanguage(LanguageEnum language) {
        this.language = language;
    }

    public LanguageEnum getLanguage() {
        return language;
    }
}