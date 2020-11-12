import java.util.Scanner;

public class Assessment2 {
    public static void main(String[] args) {
        int n;
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        if (n > 0) {
            int avg = 0, threshold_temperature, studentVariation, count;
            int[] roomTemperature = new int[n];
            for (int i = 0; i < n; i++) {
                roomTemperature[i] = sc.nextInt();
                avg += roomTemperature[i];
            }
            avg /= n;
            //System.out.println(avg);
            threshold_temperature = sc.nextInt();
            studentVariation = sc.nextInt();
            if (studentVariation >= 0 && threshold_temperature > 0) {
                count = ((threshold_temperature - avg) / 2) * studentVariation + studentVariation - 1;
                System.out.println(count);
            } else {
                System.out.println("Invalid input");
            }
        } else {
            System.out.println("invalid input");
        }
        sc.close();
    }
}
