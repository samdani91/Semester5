import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


//        System.out.print("Enter the root folder path to search: ");
//        String rootFolderPath = scanner.nextLine();
        String rootFolderPath = "/home/iit/Desktop/samdani1412/TestFolder/";

        System.out.print("Enter the keyword to search: ");
        String keyword = scanner.nextLine();

        FolderComposite rootFolder = new FolderComposite(rootFolderPath);


        boolean found = rootFolder.search(keyword);
        System.out.println("Keyword '" + keyword + "' found: " + found);

        scanner.close();
    }
}