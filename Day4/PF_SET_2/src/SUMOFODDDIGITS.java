import java.util.Scanner;

public class SUMOFODDDIGITS {
    public int sumOddDigits(int n) {
        int sum = 0;
        if (n < 0 || n > 32767) {
            return -1;
        }
        while (n != 0) {
            int temp = n % 10;
            if (temp % 2 == 1) {
                sum += temp;
            }
            n /= 10;
        }
        return sum;
    }

    public static void main(String[] args) {
        int n;
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        SUMOFODDDIGITS sodd = new SUMOFODDDIGITS();
        int output = sodd.sumOddDigits(n);
        if (output == -1)
            System.out.println("Invalid input");
        else
            System.out.println(output);
        sc.close();
    }
}
