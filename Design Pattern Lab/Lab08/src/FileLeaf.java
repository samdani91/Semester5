import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class FileLeaf extends FileSystemObject {

    public FileLeaf(String path) {
        super(path);
    }

    @Override
    public boolean search(String keyword) {
        System.out.println("Searching in File: " + path);
        try {
            String content = Files.readString(new File(path).toPath());
            return content.contains(keyword);
        } catch (IOException e) {
            System.err.println("Error reading file: " + path);
            return false;
        }
    }
}
