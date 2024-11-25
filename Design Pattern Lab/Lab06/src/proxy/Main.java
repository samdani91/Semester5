package proxy;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        PhotoViewer viewer = new PhotoViewer();
        Scanner sc = new Scanner(System.in);
        String filename;
        viewer.listPhotos();

        while (true){
            System.out.print("\nSelect a photo to view: ");
            filename = sc.nextLine();
            if(filename.equalsIgnoreCase("exit")){
                break;
            }
            viewer.displayPhoto(filename);
        }
    }
}
