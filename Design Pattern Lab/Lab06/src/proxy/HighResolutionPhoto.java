package proxy;

public class HighResolutionPhoto implements Photo {
    private final String filename;

    public HighResolutionPhoto(String filename) {
        this.filename = filename;
        loadImageFromDisk();
    }

    private void loadImageFromDisk() {
        System.out.println("Loading high-resolution photo from disk: " + filename);
    }

    @Override
    public void display() {
        System.out.println("Displaying photo: " + filename);
    }
}
