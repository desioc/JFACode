public class TrafficLight {
    public String changeColor(Color lightColor) {
        switch(lightColor) {
            case GREEN ->  System.out.println("The light is green");
            case YELLOW ->  System.out.println("The light is yellow");
            case RED ->  System.out.println("The light is red");
        }

    //a switch as statement cannot return values
        /*switch(lightColor) {
            case GREEN-> {
                String message ="The light is green";
                System.out.println(message);
                break message;
            }
            case YELLOW -> {
                String message ="The light is yellow";
                System.out.println(message);
                break message;
            }
            case RED -> {
                String message ="The light is red";
                System.out.println(message);
                break message;
            }
        }*/
        //uno switch come espressione non può utilizzare la parola return, ma switch come statement lo può fare
       /* switch(lightColor) {
            case GREEN-> {
                String message ="The light is green";
                System.out.println(message);
                return message;
            }
            case YELLOW -> {
                String message ="The light is yellow";
                System.out.println(message);
                return message;
            }
            case RED -> {
                String message ="The light is red";
                System.out.println(message);
                return message;
            }
        }*/
        return"";
    }
}