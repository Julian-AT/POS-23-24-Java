package at.htldonaustadt.schmidt.tshirts;

import at.htldonaustadt.schmidt.tshirts.backend.Shop;
import at.htldonaustadt.schmidt.tshirts.backend.Sizes;
import at.htldonaustadt.schmidt.tshirts.backend.Verkauf;
import at.htldonaustadt.schmidt.tshirts.backend.helpers.MinMaxPrice;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Shop shop = new Shop();

        // load sales
        shop.loadSales("tshirts.csv");

        // test all methods
        int sizecount = shop.getSalesBySize(Sizes.S);
        double totalprice = shop.getTotalPriceByColor("Green");
        MinMaxPrice minmax = shop.getMinMax();
        Verkauf highestquantity = shop.getHighestQuantity();
        List<Verkauf> salesbycolor = shop.getSalesByColor("Red");

        System.out.printf("Statistics:\n\nSize count: %d\nTotal price (green): %.2f\nMin-Max: %s\nHighest Quantity: %s\nSales by color (red): %s\n", sizecount, totalprice, minmax, highestquantity, salesbycolor);
    }
}