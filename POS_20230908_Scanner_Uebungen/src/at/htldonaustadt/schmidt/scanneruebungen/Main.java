package at.htldonaustadt.schmidt.scanneruebungen;

import at.htldonaustadt.schmidt.scanneruebungen.backend.ColorScanner;

public class Main {
    public static void main(String[] args) {
        ColorScanner scanner = new ColorScanner("mixed1.dat");
        scanner.scanFile();
    
        scanner.printMap();

        float sum = scanner.getSum();
        float deviation = scanner.getDeviation();
        float average = scanner.getAverage();

        int trueCount = scanner.getBooleansLength(true);
        int falseCount = scanner.getBooleansLength(false);

        int greenCount = scanner.getColorsLength("green");
        int redCount = scanner.getColorsLength("red");
        int orangeCount = scanner.getColorsLength("orange");
        int yellowCount = scanner.getColorsLength("yellow");

        System.out.println(String.format("Statistics:\n\nFloat appearances:\n\nSum: %.2f\nDeviation: %.2f\nAverage: %.2f\n\nBoolean appearances:\nTruthy: %d\nFalsy: %d\n\nColor appearances:\nGreen: %d\nRed: %d\nOrange: %d\nYellow: %d", sum, deviation, average, trueCount, falseCount, greenCount, redCount, orangeCount, yellowCount));

    }
}