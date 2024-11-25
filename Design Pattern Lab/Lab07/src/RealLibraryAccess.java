import java.util.Map;

public class RealLibraryAccess implements LibraryAccess {
    private Map<String, LibraryItem> items;

    public RealLibraryAccess(Map<String, LibraryItem> items) {
        this.items = items;
    }

    @Override
    public void accessItem(String itemID, User user) {
        if (items.containsKey(itemID)) {
            LibraryItem item = items.get(itemID);
            System.out.println(user.getName() + " is accessing: " + item.getDetails());
        } else {
            System.out.println("Item not found.");
        }
    }
}
