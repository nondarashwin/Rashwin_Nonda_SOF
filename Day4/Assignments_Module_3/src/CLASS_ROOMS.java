import java.util.Scanner;

public class CLASS_ROOMS {
    public static void main(String[] args) {
        int Class[], n, noc = 3, count = 0;
        Class = new int[noc];
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < noc; i++) {
            System.out.println("Enter the capacity of C" + (i + 1) + " Class:");
            Class[i] = sc.nextInt();

        }
        System.out.println("Enter Class Capacity");
        n = sc.nextInt();
        for (int i = 0; i < noc; i++) {
            if (n <= Class[i]) {
                count += 1;
            }
        }
        if (count == 0) {
            System.out.println("None Of the labs can accomdate " + n + " students");
        } else {
            System.out.println(2 + "lab(s) can accomdate " + n + " students");
        }
    }
}
