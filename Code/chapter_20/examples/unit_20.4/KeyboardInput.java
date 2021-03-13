import java.io.*;

public class KeyboardInput {
    public static void main (String args[]) throws IOException{
        String string = null;
        System.out.println("Type something then press enter...\nType \"end\" to terminate the program.");
        try (InputStreamReader ir = new InputStreamReader(System.in);
        BufferedReader in = new BufferedReader(ir)) {
            string = in.readLine();
            while ( string != null ) {
                if (string.equals("end")) {
                    System.out.println("Program terminated");
                    break;
                }
                System.out.println("You wrote: "+ string);
                string = in.readLine();
            }
        }
    }
}