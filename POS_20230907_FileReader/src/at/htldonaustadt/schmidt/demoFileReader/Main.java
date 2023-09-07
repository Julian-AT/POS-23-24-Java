package at.htldonaustadt.schmidt.demoFileReader;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // Demo for File Reading
        try (Scanner scanner = new Scanner(new File("input.txt")))  {
            while (scanner.hasNext()) {
                if (scanner.hasNextInt()) {
                    System.out.printf(String.format("%d is a Integer.%n", scanner.nextInt()));
                }
                else if (scanner.hasNextDouble()) {
                    System.out.printf(String.format("%.2f is a Double.%n", scanner.nextDouble()));
                }
                else {
                    System.out.printf(String.format("%s is a String.%n", scanner.next()));
                }
            }
        }
        catch (FileNotFoundException e) {
            // Print localized error message + Stack Trace
            System.out.println(e.getLocalizedMessage());
            e.printStackTrace();
        }

    }
}