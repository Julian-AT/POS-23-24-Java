package at.htldonaustadt.schmidt.areacalc;

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        // fetch circle data from the console
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the radius of the circle: ");
        double radius = sc.nextDouble();

        // calculate the area of the circle
        float area = (float)(Math.PI * (radius * radius));
        float circumfence = (float)(2 * Math.PI * radius);


        // print the area and circumference
        System.out.println(String.format("The area of the circle is: %.2f\nThe circumfence of the circle is: %.2f", area, circumfence));
    }
}