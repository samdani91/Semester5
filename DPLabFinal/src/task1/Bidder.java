package task1;

public class Bidder implements  Observer{
    private int currentBid;

    @Override
    public void updateBidPrice(int bid) {
        this.currentBid = bid;
        System.out.println("Current Bid is: " + currentBid);
        raiseNumberPaddle();
    }

    public void raiseNumberPaddle(){
        System.out.println("Raise a Number Paddle for the current bid");
    }

}
