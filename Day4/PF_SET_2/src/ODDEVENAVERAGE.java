import java.util.Scanner;

public class ODDEVENAVERAGE {
    public float oddevenaverage(int[] array, int size) {
        int avg = 0;
        for (int i = 0; i < size; i++) {
            avg += array[i];
        }
        return (float) avg / 2;
    }

    public static void main(String[] args) {
        int n;
        int[] numbers;
        boolean flag = true;
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        if (n < 0) {
            System.out.println("Invalid input");
        } else {
            numbers = new int[n];
            for (int i = 0; i < n; i++) {
                numbers[i] = sc.nextInt();
                if (numbers[i] < 0) {
                    System.out.println("invalid input");
                    flag = false;
                    break;
                }

            }
            if (flag) {
                ODDEVENAVERAGE oea = new ODDEVENAVERAGE();
                System.out.format("%.2f", oea.oddevenaverage(numbers, n));
            }
        }
        sc.close();
    }
}
