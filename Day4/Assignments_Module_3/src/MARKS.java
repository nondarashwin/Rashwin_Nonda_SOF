import java.util.Scanner;

public class MARKS {
    public static void main(String[] args) {
        int n, marks[], max = 0, min = Integer.MAX_VALUE, average = 0;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter No of Students");
        n = sc.nextInt();
        marks = new int[n];
        System.out.println("Enter the marks");
        for (int i = 0; i < n; i++) {
            marks[i] = sc.nextInt();
            if (max < marks[i]) {
                max = marks[i];
            }
            if (min > marks[i]) {
                min = marks[i];
            }

            average += marks[i];
        }
        average /= n;
        System.out.println("The Maximum Marks " + max);
        System.out.println("The Minimum Marks " + min);
        System.out.println("The Average Marks " + average);
        sc.close();
    }
}
