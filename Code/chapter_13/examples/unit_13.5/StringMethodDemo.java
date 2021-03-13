public class StringMethodDemo {
    public static void main(String args[]) {
        //charAt
        System.out.println("It is not logical, but it is often true.".charAt(3));
        //concat
        String string1 ="Mc";
        String string2 ="Guffin";
        String string3 = string1.concat(string2);
        System.out.println("string1 = "+ string1);
        System.out.println("string2 = "+ string2);
        System.out.println("string3 = "+ string3);
        //compareTo
        System.out.println("A".compareTo("B"));
        System.out.println("C".compareTo("B"));
        System.out.println("D".compareTo("D"));
        //endsWith
        String name ="Viola";
        System.out.println(name.endsWith("a"));
        //equals
        System.out.println("Equals: " + new String("sapore").equals("Sapore"));
        //equalsIgnoreCase
        System.out.println("EqualsIgnoreCase: " + new String("battista").equalsIgnoreCase("Battista"));
        //format
        System.out.println("Format: " + String.format("String = %s,  boolean = %b", "a",  1==1));
        //indexOf
        System.out.println("IndexOf: " + "Ligeia".indexOf("i"));
        System.out.println("IndexOf: " + "Ligeia".indexOf("i", 2));        
        //join
        String message = String.join("\\", "C:", "Examples", "Java");
        System.out.println(message);
        //lastIndexOf
        System.out.println("LastIndexOf: " + "Rosalia".lastIndexOf("a"));
        //trim
        String stringToTrim = "     Emanuele     ";
        final String STAR= "*";
        System.out.println(STAR+stringToTrim.trim()+STAR);
        //length
        System.out.println("Claudio".length());
        //repeat
        System.out.println("01".repeat(4));
        //replaceFirst
        String newString = "aomame".replaceFirst("a", "A");
        System.out.println(newString);
        //Split
        String deepPurple = "Gillan-Glover-Paice-Blackmore-Lord";
        String[] components = deepPurple.split("-");
        for (String component: components) {
            System.out.println(component);
        }
        //startsWith
        String cantoPrimo = "When half way through the journey of our life I found that I was in a gloomy wood, because the path which led aright was lost.";
        System.out.println(cantoPrimo.startsWith("hal"));
        System.out.println(cantoPrimo.startsWith("hal",5));
    }
}