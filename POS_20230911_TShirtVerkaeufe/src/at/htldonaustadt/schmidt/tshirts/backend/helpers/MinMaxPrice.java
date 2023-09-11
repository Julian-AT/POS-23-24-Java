package at.htldonaustadt.schmidt.tshirts.backend.helpers;

public class MinMaxPrice {
    // helper class to store min and max prices
    public double min;
    public double max;

    public MinMaxPrice(double min, double max) {
        this.min = min;
        this.max = max;
    }

    // toString overr
    @Override
    public String toString() {
        return String.format("Min=%.2f Max=%.2f", min, max);
    }
}
