public class BookFactory extends LibraryItemFactory{
    @Override
    public LibraryItem createLibraryItem(String title, String detail) {
        return new Book(title,detail);
    }
}
