public class LibraryConfigManager {
    private static LibraryConfigManager instance;
    private double lateFee;
    private int borrowingLimit;

    private LibraryConfigManager() {
        // Default settings
        this.lateFee = 0.50;
        this.borrowingLimit = 5;
    }

    public static LibraryConfigManager getInstance() {
        if (instance == null) {
            instance = new LibraryConfigManager();
        }
        return instance;
    }

    public double getLateFee() {
        return lateFee;
    }

    public void setLateFee(double lateFee) {
        this.lateFee = lateFee;
    }

    public int getBorrowingLimit() {
        return borrowingLimit;
    }

    public void setBorrowingLimit(int borrowingLimit) {
        this.borrowingLimit = borrowingLimit;
    }
}
