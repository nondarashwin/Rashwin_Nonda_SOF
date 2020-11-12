import java.util.Scanner;

public class EvenOdd {
    public String[] strinngConcat(String[] a, String[] b) {
        String[] ab = new String[a.length + b.length];
        for (int i = 0; i < a.length; i++) {
            ab[i] = a[i];
        }
        for (int i = 0; i < b.length; i++) {
            ab[a.length + i] = b[i];
        }


        return ab;

    }

    public String evenOdd(int a) {
        if (a < 0) {
            return "Impossible";
        }
        if (a % 2 == 0) {
            return "Even";

        } else {
            return "Odd";
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        EvenOdd eO = new EvenOdd();
        System.out.println("Enter number");
        int n = sc.nextInt();
        System.out.println("Number is " + eO.evenOdd(n));
    }
}
