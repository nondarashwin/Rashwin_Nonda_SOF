import java.io.File;

class FileExplorer {
    public static int count = 0;

    public void listAll(String path) {
        File f0 = new File(path);
        File[] content = f0.listFiles();
        if (count == 0) {
            System.out.println(f0.getName());
            count++;
        }
        if (content.length == 0) {
            for (int i = 0; i < count; i++) {
                System.out.print("        ");
            }
            System.out.println(f0.getName());
        } else {
            for (File f1 : content) {
                if (f1.exists()) {
                    if (f1.isDirectory()) {
                        for (int i = 0; i < count; i++) {
                            System.out.print("        ");
                        }
                        System.out.println(f1.getName());
                        count++;
                        listAll(f1.getAbsolutePath());
                        count--;
                    }
                    if (f1.isFile()) {
                        for (int i = 0; i < count; i++) {
                            System.out.print("        ");
                        }
                        System.out.println(f1.getName());
                    }
                }
            }
        }
    }
}

public class TestFileExplorer {
    public static void main(String[] args) {
        FileExplorer fe = new FileExplorer();
        fe.listAll("/home/rashwin/Project/Rashwin_Nonda_SOF/Day08/Assignment_8");

    }
}
