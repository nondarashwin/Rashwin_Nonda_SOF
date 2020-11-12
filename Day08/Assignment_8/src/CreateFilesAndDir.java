import java.io.File;
import java.io.IOException;

public class CreateFilesAndDir {
    public static void main(String[] args) throws IOException {
        File f1 = new File("Badminton");
        f1.mkdir();
        File f2 = new File(f1, "singles.txt");
        f2.createNewFile();
        File f3 = new File(f1, "dubbles.txt");
        f3.createNewFile();
        File f4 = new File(f1, "courts");
        f4.mkdir();
        File f5 = new File(f4, "sample.dat");
        f5.createNewFile();
        f3.renameTo(new File(f1, "doubles.txt"));
    }
}
