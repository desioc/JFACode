package com.claudiodesio.io;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class InteractiveEditor {

    public static void main(String args[]) {
        File file = new File("file.txt");
        try (Scanner scanner = new Scanner(System.in);
                FileWriter fileWriter = new FileWriter(file);) {
            String string = "";
            System.out.println("Type something and type enter, or type \"end\" to terminate the program");
            while (!(string = scanner.nextLine()).equals("end")) {
                System.out.println("You typed " + string);
                fileWriter.append(string);
                fileWriter.flush();
            }

        } catch (IOException ex) {
            ex.printStackTrace();
        }
        System.out.println("Program terminated");
    }
}