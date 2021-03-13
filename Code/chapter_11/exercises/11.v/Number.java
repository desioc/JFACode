public enum Number {
    
    ONE("Ace"), 
    TWO("Two"), 
    THREE("Three"), 
    FOUR("Four"), 
    FIVE("Five"), 
    SIX("Six"), 
    SEVEN("Seven"), 
    EIGHT("Eight"),  
    NINE("Nine"), 
    TEN("Ten");
    
    String representation;
    
    Number(String representation){
        this.representation = representation;
    }
    
    @Override
    public String toString(){
        return representation;
    }
}