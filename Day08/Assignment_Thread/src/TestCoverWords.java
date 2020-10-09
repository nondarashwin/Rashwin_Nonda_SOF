import java.util.Scanner;

class putBrackets extends Thread {

    public synchronized void run() {
        System.out.println("[");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("]");
    }
}

class CoverWords extends Thread {
    public synchronized void run(String s) {
        System.out.println(s);
    }
}

public class TestCoverWords extends Thread{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String word=sc.nextLine();
        putBrackets p = new putBrackets();
        p.start();
        CoverWords c1 = new CoverWords();

        c1.run(word);


    }
    public void run() {

    }
}
