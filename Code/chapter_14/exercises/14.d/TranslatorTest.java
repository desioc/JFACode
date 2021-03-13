public class TranslatorTest {

    public static void main(String args[]) {
        Translator translator = new Translator(LanguageEnum.ENGLISH);
        String translatedWord = translator.translate(WordsEnum.BOOK);
        System.out.println(translatedWord);
    }

}