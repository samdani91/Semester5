public class LibraryAccessProxy implements LibraryAccess {
    private RealLibraryAccess realAccess;

    public LibraryAccessProxy(RealLibraryAccess realAccess) {
        this.realAccess = realAccess;
    }

    @Override
    public void accessItem(String itemID, User user) {
        if (user.hasPermission()) {
            realAccess.accessItem(itemID, user);
        } else {
            System.out.println("Access denied for user: " + user.getName());
        }
    }
}
