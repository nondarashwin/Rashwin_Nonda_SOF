import java.util.Scanner;

public class SEARCHKEYS {
    int[] found;
    int count = 0;

    public void getFound() {
        if (count == 0) {
            System.out.println("Key not found");
            return;
        }
        for (int i = 0; i < count; i++) {
            System.out.println(found[i]);
        }
    }

    public void searchKeys(int[] array, int key) {
        found = new int[array.length / 2];
        for (int i = 1; i < array.length; i += 2) {
            if (array[i] == key) {
                found[count++] = array[i - 1];
            }
        }
    }

    public static void main(String[] args) {
        int n;
        int[] a;
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        if (n < 0 || n % 2 == 1) {
            System.out.println("Invalid input");
        } else {
            a = new int[n];
            boolean flag = true;
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
                if (a[i] < 0) {
                    System.out.println("invalid input");
                    flag = false;
                    break;
                }

            }
            if (flag) {
                int c = sc.nextInt();
                SEARCHKEYS sk = new SEARCHKEYS();
                sk.searchKeys(a, c);
                sk.getFound();
            }
        }
        sc.close();
    }
}
