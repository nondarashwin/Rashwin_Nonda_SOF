import java.io.*;

public class ReadingProverbs {
    public static void main(String[] args) throws IOException {
        File f1=new File("TopProverb.txt");
        if(f1.exists()){
            BufferedInputStream bis=new BufferedInputStream(new FileInputStream(f1));
            byte b[]= bis.readAllBytes();
            for(int i=0;i<b.length;i++)
            System.out.print((char) b[i]);
        }
    }
}
