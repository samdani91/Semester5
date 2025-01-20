public abstract class FileSystemObject {
    String path;

    public FileSystemObject(String path) {
        this.path = path;
    }

    public abstract boolean search(String keyword);
}
