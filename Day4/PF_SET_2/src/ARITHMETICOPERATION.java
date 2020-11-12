import java.util.Scanner;

/*As instuction were followed according to the assignment
 * this program fails for every condition where the output the operation will result in -1
 * ex 1 2 2 it will give output as -1 as -1 is set for error code it will show as error
 * but it can be changed into 2 methods to one to check the validity of the input another for output produce
 * */
public class ARITHMETICOPERATION {
    public int performArithmeticOperation(int a, int b, int c) {
        if (a < 0 || a > 32767) {
            return -1;
        }
        if (b < 0 || b > 32767) {
            return -1;
        }
        if (c < 0 || c > 4) {
            return -1;
        }
        if (c == 1) {
            return a + b;
        }
        if (c == 2) {
            return a - b;
        }
        if (c == 3) {
            return a * b;
        }
        return a / b;
    }

    public static void main(String[] args) {
        int a, b, c;
        Scanner sc = new Scanner(System.in);
        a = sc.nextInt();
        b = sc.nextInt();
        c = sc.nextInt();
        ARITHMETICOPERATION ao = new ARITHMETICOPERATION();
        int output = ao.performArithmeticOperation(a, b, c);
        if (output == -1)
            System.out.println("Invalid input");
        else
            System.out.println(output);
        sc.close();
    }
}
