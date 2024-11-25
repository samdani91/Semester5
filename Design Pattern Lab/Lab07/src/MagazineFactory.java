public class MagazineFactory extends LibraryItemFactory{

    @Override
    public LibraryItem createLibraryItem(String title, String detail) {
        return new Magazine(title,detail);
    }
}
