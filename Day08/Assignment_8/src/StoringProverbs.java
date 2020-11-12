import java.io.*;
import java.util.Scanner;

class ProverbCollection {
    public static void storeProverb(String proverb) throws IOException {
        File TopProverb = new File("TopProverb.txt");
        TopProverb.createNewFile();
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(TopProverb));
        byte[] temp = bis.readAllBytes();
        bis.close();
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(TopProverb));
        bos.write(temp);
        bos.write(proverb.getBytes());
        bos.close();
    }
}

public class StoringProverbs {
    public static void main(String[] args) throws IOException {
        ProverbCollection p1 = new ProverbCollection();
        Scanner sc = new Scanner(System.in);

        p1.storeProverb(sc.nextLine());
        p1.storeProverb("\n");
        sc.close();

    }
}
