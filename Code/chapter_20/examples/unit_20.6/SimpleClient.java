import java.io.*;
import java.net.*;

public class SimpleClient {

    public static void main(String args[]) {
        String host = getServerHost(args);
        try (Socket serverSocket= new Socket(host, 9999);
               BufferedReader br = new BufferedReader(
                 new InputStreamReader(serverSocket.getInputStream()));) {
            System.out.println(br.readLine());
        } catch (ConnectException connExc) {
            System.err.println("Cannot connect to the server " +
                               connExc.getMessage());
        } catch (IOException e) {
            System.err.println("Problems... " + e.getMessage());
        }
    }

    public static String getServerHost(String[] args) {
        String host = "127.0.0.1";
        if (args.length != 0) {
            host = args[0];
        }
        return host;
    }
}
