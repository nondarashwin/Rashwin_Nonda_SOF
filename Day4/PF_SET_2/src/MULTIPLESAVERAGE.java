import java.util.Scanner;

public class MULTIPLESAVERAGE {
public static void main(String[] args){
    int multiple=5,n;
    Scanner sc=new Scanner(System.in);
    n=sc.nextInt();
    if(n>0 && n<32767){
        int count=n/multiple;
        System.out.format("%.2f",(float) (count+1)*5/2);
    }
    else
        System.out.println("Invalid input");
}
}
