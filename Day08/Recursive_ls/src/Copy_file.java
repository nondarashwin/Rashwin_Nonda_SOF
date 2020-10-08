import java.io.*;

public class Copy_file {
    public static void main(String[] args)  {
        FileInputStream f1=null;
        FileOutputStream f2=null;
        try{
         f1=new FileInputStream(new File("thejourney.txt"));
        f2=new FileOutputStream(new File("copy.txt"));
        int i;
        while ((i=f1.read())!=-1){
            f2.write(i);
        }}  catch (IOException e) {
            e.printStackTrace();
        } finally {


            try {
                f1.close();
                f2.close();
            } catch (NullPointerException | IOException e) {
                e.printStackTrace();
            }

        }
        int i;
        FileInputStream check=null;
                try{
        check=new FileInputStream(new File("copy.txt"));
        while ((i=check.read())!=-1){
            System.out.print((char)i);
        }} catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    try {
                        check.close();
                    }catch (NullPointerException |IOException e){
                        e.printStackTrace();
                    }

                }
    }
}
