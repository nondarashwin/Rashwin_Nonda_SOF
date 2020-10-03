import java.util.Scanner;

public class COUNTS_OF_3MULTIPLES {
    public int divisibleBy3(int[] array, int size) {
        int count = 0;
        for (int i = 0; i < size; i++) {
            if (array[i] % 3 == 0) {
                count += 1;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int size;
        int[] number;
        boolean flag = true;
        Scanner sc = new Scanner(System.in);
        size = sc.nextInt();
        if (size < 0) {
            System.out.println("invalid array size");
        } else {
            number = new int[size];
            for (int i = 0; i < size; i++) {
                number[i] = sc.nextInt();
                if (number[i] < 0) {
                    flag = false;
                    break;
                }
            }
            if (!flag) {
                System.out.println("Invalid input");
            } else {
                COUNTS_OF_3MULTIPLES c03m = new COUNTS_OF_3MULTIPLES();
                System.out.println(c03m.divisibleBy3(number, size));
            }
        }
        sc.close();
    }
}
