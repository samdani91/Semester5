package task1;

public class Main {
    public static void main(String[] args) {
        Auctioneer auctioneer = new Auctioneer();
        Observer bidder = new Bidder();

        auctioneer.registerObserver(bidder);

        auctioneer.setBidPrice(100);
    }
}
