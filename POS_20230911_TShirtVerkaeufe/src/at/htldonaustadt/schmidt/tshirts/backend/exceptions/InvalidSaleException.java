package at.htldonaustadt.schmidt.tshirts.backend.exceptions;

public class InvalidSaleException extends RuntimeException {
    // custom exception
    public InvalidSaleException(String message) {
        super(message);
    }
}

