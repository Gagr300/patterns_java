//Singleton
public class LanguageManager {
    private static LanguageManager instance;
    private static String textLanguage;
    private static String audioLanguage;

    protected LanguageManager(){}

    public static LanguageManager getInstance() {
        if (instance == null) {
            instance = new LanguageManager();
        }
        return instance;
    }
    public void setTextLang(String textLanguage) {
        this.textLanguage = textLanguage;
    }
    public void setAudioLang(String audioLanguage) {
        this.audioLanguage = audioLanguage;
    }
    public String getTextLanguage() {
        return textLanguage;
    }
    public String getAudioLanguage() {
        return audioLanguage;
    }
}
