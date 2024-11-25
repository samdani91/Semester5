public class Magazine implements LibraryItem{
    private String title;
    private String issue;

    public Magazine(String title, String issue) {
        this.title = title;
        this.issue = issue;
    }

    @Override
    public String getDetails() {
        return "Magazine: " + title + ", Issue: " + issue;
    }

    @Override
    public void borrowItem(String userID) {
        System.out.println(userID + " borrowed the magazine: " + title);
    }
}
