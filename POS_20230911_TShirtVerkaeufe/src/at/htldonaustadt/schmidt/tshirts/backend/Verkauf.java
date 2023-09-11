package at.htldonaustadt.schmidt.tshirts.backend;

public class Verkauf {
    // Instance variables
    private Sizes size;

    private String color;

    private double unitPrice;

    private int quantity;

    // constructor
    public Verkauf(Sizes size, String color, double unitPrice, int quantity) {
        try {
            this.size = size;
            this.color = color;
            setUnitPrice(unitPrice);
            setQuantity(quantity);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
            System.exit(1);
        }
    }

    // getters
    public Sizes getSize() {
        return size;
    }

    public String getColor() {
        return color;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    // setters
    private void setUnitPrice(double unitPrice) {
        if(unitPrice < 0) throw new IllegalArgumentException("Please provide a valid unit price (positive number or 0)");
        this.unitPrice = unitPrice;
    }

    private void setQuantity(int quantity) {
        if(quantity < 0) throw new IllegalArgumentException("Please provide a valid quantity (positive number or 0)");
        this.quantity = quantity;
    }

    private void setColor(String color) {
        this.color = color;
    }

    private  void setSize(Sizes size) {
       try {
            this.size = size;
       } catch (IllegalArgumentException e) {
           throw new IllegalArgumentException("Please provide a valid size.");
       }
    }

    // toString override
    @Override
    public String toString() {
        return String.format("\n\nSale:\n\nSize: %s\nColor: %s\nUnit price: %.2f\nQuantity: %d", size, color, unitPrice, quantity);
    }

}


