public class User {
    private String name;
    private boolean hasPermission;

    public User(String name, boolean hasPermission) {
        this.name = name;
        this.hasPermission = hasPermission;
    }

    public String getName() {
        return name;
    }

    public boolean hasPermission() {
        return hasPermission;
    }
}
