import java.util.Scanner;

public class Cricket_Run_Rate {
    public static void main(String[] args) {
        int Total_over = 50, Bowled_over, Target_score;
        float CRR;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of overs bowled so far");
        Bowled_over = sc.nextInt();
        System.out.println("Enter the current run rate");
        CRR = sc.nextFloat();
        System.out.println("Enter the Target Score");
        Target_score = sc.nextInt();
        if (Total_over > Bowled_over)
            System.out.format("the Required Run rate is  %.2f", (Target_score - CRR * Bowled_over) / (Total_over - Bowled_over));
            //System.out.println("The Required Run rate is " + String.format("%.3f%", (Target_score - CRR * Bowled_over) / (Total_over - Bowled_over)));
        else
            System.out.println("can't bowl more then Total over");

        sc.close();
    }
}
