import java.util.Scanner;

class putBrackets extends Thread {
    String brack;
    public putBrackets(String brack){
        this.brack=brack;
    }
    public synchronized void run() {
        System.out.println('[');
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
System.out.println(']');
    }
}

class CoverWords extends Thread {
    String word;
    public CoverWords(String word){
        this.word=word;
    }
    public synchronized void run() {
        System.out.println(word);
    }
}

public class TestCoverWords extends Thread{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String word=sc.nextLine();
        putBrackets p = new putBrackets("[");
        p.start();
        CoverWords c1 = new CoverWords(word);

        c1.start();
       // putBrackets p1 = new putBrackets("]");
       // p1.start();

    }
    public void run() {

    }
}
