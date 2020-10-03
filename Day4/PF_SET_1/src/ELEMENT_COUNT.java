import java.util.Scanner;

public class ELEMENT_COUNT {
    public int findElementCount(int[] array, int size, int ele) {
        int count = 0;
        for (int i = 0; i < size; i++) {
            if (array[i] == ele) {
                count += 1;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int size, ele;
        boolean flag = true;
        Scanner sc = new Scanner(System.in);
        size = sc.nextInt();
        if (size >= 0) {
            int[] array = new int[size];
            for (int i = 0; i < size; i++) {
                array[i] = sc.nextInt();
                if (array[i] < 0) {
                    flag = false;
                    break;
                }
            }
            if (flag == false) {
                System.out.println("invalid input");
            } else {
                ele = sc.nextInt();
                if (ele < 0)
                    System.out.println("Invalid input");
                else {
                    ELEMENT_COUNT ec = new ELEMENT_COUNT();
                    System.out.println(ec.findElementCount(array, size, ele));
                }
            }
        } else {
            System.out.println("Invalid array size");
        }
        sc.close();
    }
}
