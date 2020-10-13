import java.io.*;
import java.util.Map;

class ProverbReverser{
    public String[] reverseWord(String s){
        String[] words=s.split(" ");
        String[] temp_words=new String[words.length];
        for(int i=0;i<words.length;i++){
            temp_words[i]=words[words.length-1-i];
            //System.out.println(temp_words[i]);
        }
        return temp_words;
    }
    public void reverseString() throws IOException {
        File TopProverb = new File("TopProverb.txt");
        TopProverb.createNewFile();
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(TopProverb));
        byte[] temp=bis.readAllBytes();
        String data=new String(temp);
        String[] proverbs=data.split("\n");
        String[] temp1=new String[proverbs.length];
        File reverseProverb=new File("ReversProverb.txt");
        BufferedOutputStream bos=new BufferedOutputStream(new FileOutputStream(reverseProverb));
        for(int i=0;i<proverbs.length;i++){
           String revers_array[]=reverseWord(proverbs[i]);
           System.out.println(revers_array[1]);
           for(int j=0;j<revers_array.length;j++){
               bos.write(revers_array[j].getBytes());
               //System.out.println(revers_array[i]);
               bos.write((byte) ' ');
           }
           bos.write((byte)'\n');
        }
        bis.close();
        Map.e

        //bos.write(temp1);
        bos.close();
    }
}
public class ReverseProverb {
    public static void main(String[] args) throws IOException {
ProverbReverser pr=new ProverbReverser();
pr.reverseString();
    }
}
