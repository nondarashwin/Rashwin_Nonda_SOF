class PrintTables extends Thread {
    int n;

    public PrintTables(int n) {
        this.n = n;
    }

    public synchronized void run() {
        for (int i = 1; i <= 10; i++) {
            System.out.println("" + n + "*" + i + "=" + (i * n));

        }
    }
}

public class TestPrintTables {
    public static void main(String[] args) {
        PrintTables p1 = new PrintTables(5);
        p1.start();
        PrintTables p2 = new PrintTables(100);
        p2.start();
    }
}
