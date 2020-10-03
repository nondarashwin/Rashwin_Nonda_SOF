import java.util.Scanner;

public class DIGITFACTORIAL {
    public void factorial(int n) {
        int fact = 1;
        for (int i = 1; i <= n; i++) {
            fact *= i;
        }
        System.out.println(fact);
    }

    public void digits(int n) {
        //System.out.println(n);
        if (n == 0)
            return;

        //System.out.println(n!=0);
        //System.out.println("after while loop"+n);
        digits(n / 10);

        factorial(n % 10);


    }

    public static void main(String[] args) {
        int n;
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        if (n > 0 && n < 32767) {
            DIGITFACTORIAL df = new DIGITFACTORIAL();
            df.digits(n);
        } else
            System.out.println("Invalid input");
        sc.close();
    }
}
