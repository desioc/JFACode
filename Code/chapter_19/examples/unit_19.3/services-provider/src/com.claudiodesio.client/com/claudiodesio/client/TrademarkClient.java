package com.claudiodesio.client;

import com.claudiodesio.handlers.Trademarker;
import java.util.Scanner;

public class TrademarkClient {
    public static void main(String args[]) {
        System.out.println("To add the trademark type:"
                + "\n'C + enter' for a certificate"
                + "\n'I + enter' for an invoice"
                + "\n To end the program type 'E + enter'");
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String command = scanner.nextLine();
            try {
                if (command.equals("I") ||  command.equals("C")) {
                    Trademarker trademarker = new Trademarker();
                    trademarker.addTrademark(command,"Claudio De Sio Cesari");
                } else if (command.equals("E")) {
                    System.out.println("Ciao, see you soon!");
                    System.exit(0);
                } else {
                    System.out.println("Ignored command!");
                }
            } catch (IllegalArgumentException exception) {
                System.out.println(exception.getMessage());
            }
        }
    }
}