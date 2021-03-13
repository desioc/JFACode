package com.claudiodesio.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class More {

    private final static int numberOfLines = 10;
    private static final String QUIT_COMMAND = "q";
    private static final String NEXT_COMMAND = "n";

    public static void main(String args[]) {
        String character;
        System.out.println("Type the name of a file and type enter, or "
                + "type \"" + QUIT_COMMAND + "\" to terminate the program");
        try (Scanner in = new Scanner(System.in);) {
            String fileName;
            if (!(fileName = in.nextLine()).equals(QUIT_COMMAND)) {
                File file = new File(fileName);
                try (Scanner fileScanner = new Scanner(file)) {
                    System.out.println("File found! \"" + fileName + 
                        "\" , press \"n\" to see the next 10 lines");
                    while (!(character = in.nextLine()).equals(QUIT_COMMAND)) {
                        if (character.equals(NEXT_COMMAND)) {
                            for (int i = 0; fileScanner.hasNext() && 
                                                       i < numberOfLines; i++) {
                                System.out.println(fileScanner.nextLine());
                            }
                        }
                    }
                } catch (FileNotFoundException exc) {
                    System.out.println("File not found!");
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        System.out.println("Program terminated!");
    }

} 