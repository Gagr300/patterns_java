public class Program {
    public static void main(String[] args){
        LanguageManager languageManager = LanguageManager.getInstance();
        System.out.println(languageManager);
        languageManager.setTextLanguage("RUS");
        languageManager.setAudioLanguage("ENG");

        System.out.println(languageManager.getTextLanguage());
        System.out.println(languageManager.getAudioLanguage());

        LanguageManager languageManager2 = LanguageManager.getInstance();
        System.out.println(languageManager2);

        System.out.println(languageManager2.getTextLanguage());
        System.out.println(languageManager2.getAudioLanguage());
    }
}

