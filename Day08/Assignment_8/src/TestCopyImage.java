import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Scanner;
class ImageCopy{
    public static void copyImage(File f) throws IOException {
        String path=f.getParent()+"/"+f.getName().replaceAll(".jpeg","")+"_copy.jpeg";
        File f1=new File(path);
        Files.copy(f.toPath(),f1.toPath());
    }
}
public class TestCopyImage {
    public static void main(String[] args) throws IOException {
        Scanner sc=new Scanner(System.in);
        String path=sc.nextLine();
        File f1=new File(path);
        if(f1.exists()){
            if(!f1.isDirectory()&&path.endsWith(".jpeg")){
                ImageCopy ic=new ImageCopy();
                ic.copyImage(f1);
            }
            else {
                System.out.println("File format Doesn't Support");
            }
        }
        else {
            System.out.println("File Doesn't exists");
        }
    }
}
