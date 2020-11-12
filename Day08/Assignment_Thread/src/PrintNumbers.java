class PNumbers extends Thread {
    int i;

    public PNumbers(int i) {
        this.i = i;
    }

    public void run() {

        System.out.println(i);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}

public class PrintNumbers {
    public static void main(String[] args) {
        for (int i = 1; i < 11; i++) {
            PNumbers pn = new PNumbers(i);
            pn.start();
        }
    }
}
