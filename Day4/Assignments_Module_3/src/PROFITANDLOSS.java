import java.util.Scanner;

public class PROFITANDLOSS {
    public static void main(String[] args){
        int x,y,z,dozen=12;
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the number of dozens of eggs purchased");
        x=sc.nextInt();
        System.out.println("Enter the price per dozen");
        y=sc.nextInt();
        System.out.println("Enter the selling price of one egg");
        x=sc.nextInt();
        System.out.format("Harish's Profit Percentage is %.2f percent",(float)(x*dozen-y)*100/y);
        sc.close();
    }
}
