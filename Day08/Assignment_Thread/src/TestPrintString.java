class PrintString extends Thread{
    String s;
    public PrintString(String s){
        this.s=s;
    }
    public void run() {

        System.out.println(s);
    }
}
public class TestPrintString {
    public static void main(String[] args){
        PrintString p=new PrintString("Hi Iam Thread");
        PrintString p1=new PrintString("Mee Too");
        p.start();
        p1.start();
    }
}
