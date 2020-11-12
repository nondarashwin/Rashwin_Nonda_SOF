import java.io.*;

public class DocumentFormatter {
    public static void main(String[] args) throws IOException {
        File f1 = new File("TopProverb.txt");
        File f2 = new File("corrected_document.txt");
        f2.createNewFile();
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(f1));
        String s = "";
        int i;
        while ((i = bis.read()) != -1) {
            s = s.concat(new String(String.valueOf((char) i)));
        }
        bis.close();
        System.out.println(s);

        s = s.replaceAll("( )+", " ");
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(f2));
        bos.write(s.getBytes());
        bos.close();
    }
}
