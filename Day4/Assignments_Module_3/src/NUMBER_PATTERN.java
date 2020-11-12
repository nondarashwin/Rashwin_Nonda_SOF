import java.util.Scanner;

public class NUMBER_PATTERN {
    public static void main(String[] args) {
        int n, ommit = 3;
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        for (int i = 1; i <= n; i++) {
            if (i % ommit == 0)
                continue;
            for (int j = 0; j < i; j++) {
                System.out.print(i);
                if (j != i - 1)
                    System.out.print(' ');
            }
            System.out.println();
        }
        sc.close();

    }
}
