import java.util.Scanner;

public class MyUtil {
    int a;

    static int throwDice() {
        int temp;
        do {
            temp = (int) (Math.random() * 100) % 7;
        } while (temp == 0);
        return temp;
    }

    static double findAvg(int[] array) {
        int avg = 0;
        for (int a : array) {
            avg += a;
        }
        return (double) avg / array.length;
    }

    public static void main(String[] args) {
        System.out.println(throwDice());
        int n;
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int[] a = new int[n];

        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        n = sc.nextInt();
        int[] b = new int[n];
        for (int i = 0; i < n; i++) {
            b[i] = sc.nextInt();
        }
        System.out.println("The average of array a is " + findAvg(a));
        System.out.println("The Average of array b is " + findAvg(b));
        System.out.println(Math.floor(12.34));
        System.out.println(Math.ceil(12.34));
        System.out.println(Math.max(13.9, 12.8));
        System.out.println(Math.min(13.9, 12.8));
        System.out.println(Math.round(12.3444));
    }
}
