package proxy;

import java.util.ArrayList;
import java.util.List;

public class PhotoViewer {
    private final List<Photo> photoList = new ArrayList<>();

    public PhotoViewer(){
        addPhoto(new PhotoProxy("beach.jpg"));
        addPhoto(new PhotoProxy("mountains.jpg"));
        addPhoto(new PhotoProxy("cityscape.jpg"));
    }

    public void addPhoto(Photo photo) {
        photoList.add(photo);
    }

    public void displayPhoto(String filename) {
        for (Photo photo : photoList) {
            if (photo instanceof PhotoProxy && ((PhotoProxy) photo).getFilename().equals(filename)) {
                photo.display();
                return;
            }
        }
        System.out.println("Photo not found.");
    }

    public void listPhotos() {
        for (Photo photo : photoList) {
            if (photo instanceof PhotoProxy) {
                System.out.println("Photo: " + ((PhotoProxy) photo).getFilename());
            }
        }
    }
}
