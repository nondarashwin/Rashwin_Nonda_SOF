import java.util.Scanner;

public class PRODUCTOFDIGITS {
    public int productDigits(int n) {
        int result = 1;
        if (n < 0 || n > 32767) {
            return -1;
        }
        while (n != 0) {
            result *= (n % 10);
            n /= 10;
        }
        return result;
    }

    public static void main(String[] args) {
        int n;
        PRODUCTOFDIGITS pod = new PRODUCTOFDIGITS();
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int result = pod.productDigits(n);
        if (result == -1) {
            System.out.println("Invalid input");
        } else
            System.out.println(result);
        sc.close();
    }
}
