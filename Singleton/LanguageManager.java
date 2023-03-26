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
    public void setTextLanguage(String textLanguage) {
        this.textLanguage = textLanguage;
    }
    public void setAudioLanguage(String audioLanguage) {
        this.audioLanguage = audioLanguage;
    }
    public static String getTextLanguage() {
        return textLanguage;
    }
    public static String getAudioLanguage() {
        return audioLanguage;
    }
}
