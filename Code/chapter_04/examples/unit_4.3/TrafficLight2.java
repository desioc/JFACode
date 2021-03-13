public class TrafficLight2 {
    public String state;
    public void changeColor(Color2 lightColor) {
        state = switch(lightColor) {
            case GREEN-> "The light is green";
            case YELLOW -> "The light is yellow";
            case RED -> "The light is red";
            default -> "The light is off";
        };
    }
    
    public void printState() {
        System.out.println(state);
    }
}