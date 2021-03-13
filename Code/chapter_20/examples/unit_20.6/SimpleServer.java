import java.io.*;
import java.net.*;

public class SimpleServer {

    public static void main(String args[]) {
        try (ServerSocket serverSocket = new ServerSocket(9999);) {
            System.out.println("Server started, listeining on " 
                    + "port 9999");
            while (true) {
                try (Socket clientSocket = serverSocket.accept();
                        OutputStream clientOutputStream = clientSocket.getOutputStream();
                        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(clientOutputStream));) {
                    bufferedWriter.write("Welcome client, I'm the server!");
                    System.out.println("Message sent to " + clientSocket.getInetAddress());
                } catch (ConnectException connExc) {
                    System.err.println("This client cannot connect with the server : " + connExc.getMessage());
                } catch (IOException e) {
                    System.err.println("There's a problem: " + e.getMessage());
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}