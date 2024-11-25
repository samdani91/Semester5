import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        LibraryConfigManager config = LibraryConfigManager.getInstance();
        System.out.println("Late Fee: " + config.getLateFee());

        LibraryItemFactory bookFactory = new BookFactory();
        LibraryItemFactory magazineFactory = new MagazineFactory();


        LibraryItem book = bookFactory.createLibraryItem("The Great Gatsby", "F. Scott Fitzgerald");
        LibraryItem magazine = magazineFactory.createLibraryItem("National Geographic", "August 2024");


        Map<String, LibraryItem> items = new HashMap<>();
        items.put("B001", book);
        items.put("M001", magazine);


        LibraryAccess access = new LibraryAccessProxy(new RealLibraryAccess(items));
        User user = new User("Alice", true);
        access.accessItem("B001", user);

        User guest = new User("Bob", false);
        access.accessItem("M001", guest);
    }
}
