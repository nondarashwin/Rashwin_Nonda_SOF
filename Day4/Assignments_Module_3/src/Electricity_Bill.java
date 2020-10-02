import java.util.Scanner;

public class Electricity_Bill {
    public static void main(String[] args) {
        int Previous_Reading, Current_Reading;
        Scanner sc = new Scanner(System.in);
        int[] W_slab = {30, 70, 100};
        double cost = 0;
        double[] W_rate = {2.30, 3.50, 4.60};
        if (W_slab.length == W_rate.length) {
            System.out.println("Enter the Previous reading");
            Previous_Reading = sc.nextInt();
            System.out.println("Enter the Current Reading");
            Current_Reading = sc.nextInt();
            int diff_reading = Current_Reading - Previous_Reading, total = 0;
            for (int i = 0; i < W_slab.length; i++) {
                if (i == W_slab.length - 1) {
                    cost += diff_reading * W_rate[i];
                    break;
                }
                if (diff_reading < W_slab[i]) {
                    cost += (diff_reading * W_rate[i]);
                    break;
                } else {
                    cost += (W_slab[i] * W_rate[i]);
                    diff_reading -= W_slab[i];
                    if (diff_reading == 0)
                        break;
                }

            }
            System.out.println("The Bill Amount is " + cost);


        } else {
            System.out.println("Length of Watt slab and Length of Watt Rate Doesn't match");
        }
        sc.close();

    }
}
