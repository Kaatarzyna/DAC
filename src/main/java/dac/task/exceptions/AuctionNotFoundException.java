package dac.task.exceptions;

public class AuctionNotFoundException extends RuntimeException {

    @Override
    public String toString() {
        return "Auction not found";
    }
}
