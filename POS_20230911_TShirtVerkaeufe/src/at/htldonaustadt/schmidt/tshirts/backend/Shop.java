package at.htldonaustadt.schmidt.tshirts.backend;

import at.htldonaustadt.schmidt.tshirts.backend.exceptions.InvalidSaleException;
import at.htldonaustadt.schmidt.tshirts.backend.helpers.MinMaxPrice;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Shop {
    // list that stores all sales
    private List<Verkauf> sales;

    public Shop() {
        sales = new ArrayList<>();
    }

    public void loadSales(String filename) {
        try {
            File file = new File(filename);
            Scanner scanner = new Scanner(file);
            System.out.println(scanner.nextLine());
            while (scanner.hasNextLine()) {
                String[] line = scanner.nextLine().split(";");
                Sizes size = Sizes.valueOf(line[0]);
                String color = line[1];
                double unitPrice = Double.parseDouble(line[2].replace(",", "."));
                int quantity = Integer.parseInt(line[3]);
                sales.add(new Verkauf(size, color, unitPrice, quantity));
            }
            scanner.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Get Sales by size
    public int getSalesBySize(Sizes size) {
        if(sales.size() == 0) throw new InvalidSaleException("No sales found");
        int counter = 0;
        for (Verkauf verkauf : sales) {
            if (verkauf.getSize() == size) {
                counter += verkauf.getQuantity();
            }
        }
        return counter;
    }

    // Get Sales by color
    public double getTotalPriceByColor (String color) {

        List<Verkauf> coloredSales = getSalesByColor(color);
        double totalPrice = 0;
        for (Verkauf verkauf : coloredSales) {
            totalPrice += verkauf.getUnitPrice() * verkauf.getQuantity();
        }
        return totalPrice;
    }


    // Get Min and Max values by helper Class
    public MinMaxPrice getMinMax() {
        if(sales.size() == 0) throw new InvalidSaleException("No sales found");

        // fetch min and max price
        double min = Double.MAX_VALUE;
        double max = Double.MIN_VALUE;
        for (Verkauf verkauf : sales) {
            if (verkauf.getUnitPrice() < min) {
                min = verkauf.getUnitPrice();
            }
            if (verkauf.getUnitPrice() > max) {
                max = verkauf.getUnitPrice();
            }
        }

        if(min == Double.MAX_VALUE || max == Double.MIN_VALUE) throw new InvalidSaleException("Invalid min or max price");
        return new MinMaxPrice(min, max);
    }

    // Get Highest quantity count
    public Verkauf getHighestQuantity() {
        if(sales.size() == 0) throw new InvalidSaleException("No sales found");

        Verkauf max = sales.get(0);
        for (Verkauf verkauf : sales) {
            if (verkauf.getQuantity() > max.getQuantity()) {
                max = verkauf;
            }
        }
        return max;
    }

    // Get Sales by Color
    public List<Verkauf> getSalesByColor(String color) {
        if(sales.size() == 0) throw new InvalidSaleException("No sales found");

        List<Verkauf> result = new ArrayList<>();
        for (Verkauf verkauf : sales) {
            if (verkauf.getColor().equals(color)) {
                result.add(verkauf);
            }
        }
        return result;
    }
}
