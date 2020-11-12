import java.util.Scanner;

public class VEHICLE_NUMBER {

    public static void main(String[] args) {
        int m, n;
        Scanner sc = new Scanner(System.in);
        m = sc.nextInt();
        n = sc.nextInt();
        for (int i = m; i <= n; i++) {
            int sum = 0;
            int count = 0;
            for (int temp = i; temp != 0; temp /= 10) {
                sum += temp % 10;
                count++;
                if (count > 4) {
                    break;
                }
            }
            if (count > 4 || count < 4)
                break;

            if (sum == 9) {
                System.out.println(i);
            }
        }
        sc.close();
    }
}
