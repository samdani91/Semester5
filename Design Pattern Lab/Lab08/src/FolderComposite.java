import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class FolderComposite extends FileSystemObject {
    private List<FileSystemObject> children = new ArrayList<>();

    public FolderComposite(String path) {
        super(path);
        loadChildren();
    }

    private void loadChildren() {
        File folder = new File(path);
        if (folder.exists() && folder.isDirectory()) {
            for (File file : Objects.requireNonNull(folder.listFiles())) {
                if (file.isFile()) {
                    children.add(new FileLeaf(file.getPath()));
                } else if (file.isDirectory()) {
                    children.add(new FolderComposite(file.getPath()));
                }
            }
        }
    }

    @Override
    public boolean search(String keyword) {
        System.out.println("Searching in Folder: " + path);
        for (FileSystemObject child : children) {
            if (child.search(keyword)) {
                return true;
            }
        }
        return false;
    }
}
