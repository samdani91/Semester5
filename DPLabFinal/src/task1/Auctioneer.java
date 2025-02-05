package task1;

import java.util.ArrayList;
import java.util.List;

public class Auctioneer implements Subject {
    private List<Observer> observers = new ArrayList<>();
    private int bidPrice;

    public void setBidPrice(int bid) {
        this.bidPrice = bid;
        notifyObservers();
    }

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.updateBidPrice(this.bidPrice);
        }
    }

}

