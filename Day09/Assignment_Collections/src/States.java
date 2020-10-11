import java.io.*;
import java.util.Arrays;
import java.util.LinkedHashSet;

public class States {
    public static void main(String[] args) throws IOException {
        File f1=new File("/home/rashwin/Project/Rashwin_Nonda_SOF/Day09/Assignment_Collections/src/States.txt");
        BufferedReader fos=new BufferedReader(new FileReader(f1));
        LinkedHashSet<String> States=new LinkedHashSet<>();
        //System.out.println(content);
        String s;
        while((s=fos.readLine())!=null){
        States.add(s);}
        System.out.println("The Total States:"+States.size());
        for(String  state:States){
            System.out.println(state);
        }
        States.remove("Delhi");
        System.out.println("*********States That Start With K********");
        for(String  state:States){
            if(state.startsWith("K"))
            System.out.println(state);
        }
        System.out.println("*********States in sorted order********");
        for(String  state:States){
            System.out.println(state);
        }
        fos.close();
    }
}
