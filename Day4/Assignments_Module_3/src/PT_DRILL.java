import java.util.Arrays;
import java.util.Scanner;

public class PT_DRILL {
    public static void main(String[] args) {
        int n;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter No of Students");
        n = sc.nextInt();
        if (Math.sqrt(n) * Math.sqrt(n) == n) {
            int k = (int) Math.sqrt(n);
            String[] lines = new String[n];
            for (int i = 0; i < n; i++) {
                lines[i] = sc.next();
            }
            Arrays.sort(lines);
            String[][] arranged = new String[k][k];
            for (int i = 0; i < k; i++)
                for (int j = 0; j < k; j++) {
                    arranged[i][j] = lines[i * k + j];
                }
            System.out.print("Middle Column :");
            for (int i = 0; i < k; i++)
                System.out.print(arranged[i][k / 2] + ' ');
            System.out.println();
            System.out.println("Middle Row :");
            for (int i = 0; i < k; i++)
                System.out.print(arranged[k / 2][i] + ' ');
            System.out.println();

        }
    }
}
