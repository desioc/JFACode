public enum WordsEnum {

    BOOK("book"), TIME("time"), HOME("home");

    private String key;

    private WordsEnum(String key) {
        this.key = key;
    }

    public String getKey() {
        return key;
    }

}