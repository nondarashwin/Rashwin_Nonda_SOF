import java.io.File;

class FolderInfo {
    public static void printDirectory(String path) {
        File dir = new File(path);
        if (dir.exists() && dir.isDirectory()) {
            File[] contents = dir.listFiles();
            for (File content : contents) {
                if (content.isDirectory()) {
                    System.out.println("Directory:" + content.getName());
                    System.out.println("Path:" + content.getParent());
                }
                if (content.isFile()) {
                    System.out.println("File :" + content.getName());
                    System.out.println("Absolute Path:" + content.getAbsolutePath());
                    System.out.println("Folder Path:" + content.getParent());
                }
            }
        } else {
            System.out.println("No Folder exists with a name");
        }
    }
}

public class GetDirectoryDetails {
    public static void main(String[] args) {
        FolderInfo fi = new FolderInfo();
        fi.printDirectory("/home/rashwin/Project/Rashwin_Nonda_SOF/Day08/Assignment_8/Badminton");
    }

}
