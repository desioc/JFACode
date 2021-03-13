public enum LanguageEnum {

    ITALIAN("it", "Italian"), ENGLISH("en", "eNGLISH");

    String key;

    String description;

    LanguageEnum(String key, String description) {
        this.key = key;
        this.description = description;
    }

    public String getKey() {
        return key;
    }
    
    public String toString() {
        return description;
    }

}