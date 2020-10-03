import java.util.Scanner;

public class CALCULATESAL {
    public static void main(String[] args) {
        int salary, shift, take_care_percent = 2, total_percent = 100;
        int[] expense_in_percent = {20, 30};
        Scanner sc = new Scanner(System.in);
        salary = sc.nextInt();
        shift = sc.nextInt();
        if (shift < 0)
            System.out.println("Shift is too small");
        else {
            if (salary > 8000)
                System.out.println("Salary too large");
            else if (salary <= 0)
                System.out.println("Salary is too small");
            else {
                for (int i = 0; i < expense_in_percent.length; i++) {
                    total_percent -= expense_in_percent[i];
                }
                total_percent += (shift * take_care_percent);
                System.out.println((salary * total_percent) / 100);
            }

        }
        sc.close();
    }
}
