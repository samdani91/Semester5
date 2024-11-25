package proxy;

public class PhotoProxy implements Photo {
    private final String filename;
    private HighResolutionPhoto highResolutionPhoto;

    public PhotoProxy(String filename) {
        this.filename = filename;
    }

    @Override
    public void display() {
        if (highResolutionPhoto == null) {
            highResolutionPhoto = new HighResolutionPhoto(filename);
        }
        highResolutionPhoto.display();
    }

    public String getFilename() {
        return filename;
    }
}
