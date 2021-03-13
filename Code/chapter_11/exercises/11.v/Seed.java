public enum Seed {
    CUPS,
    STICKS,
    COINS,
    SWORDS;
    
    String representation;
        
    public String toString() {
        return doCapitalization(this.name());
    }
    
    private String doCapitalization(String string) {
        //make the string lowercase
        String lowerCaseString = string.toLowerCase();
        //retrieve the first character of the string
        String initialCharacter = lowerCaseString.substring(0,1);
        //make uppercase the first character
        String initialCharacterUpperCase = initialCharacter.toUpperCase();
        //retrieve the concatenation between the capital letter
        // and the rest of the lowercase string
        return  initialCharacterUpperCase + lowerCaseString.substring(1);
    }
}