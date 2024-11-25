public class Book implements LibraryItem {
    private String title;
    private String author;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    @Override
    public String getDetails() {
        return "Book: " + title + " by " + author;
    }

    @Override
    public void borrowItem(String userID) {
        System.out.println(userID + " borrowed the book: " + title);
    }
}