import java.util.Scanner;

public class KARPEKAR_NUMBER {
    public static void main(String[] args) {
        int k, n = 1, s, p = 0, q = 0;
        Scanner sc = new Scanner(System.in);
        k = sc.nextInt();
        s = k * k;
        for (int temp = k; temp != 0; temp /= 10) {
            n *= 10;
        }
        p = s % n;
        q = s / n;
        if (k == (p + q)) {
            System.out.println("Kaprekar Number");
        } else {
            System.out.println("Not a Kaprekar Number");
        }
    }
}
