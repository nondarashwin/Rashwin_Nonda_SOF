import java.util.Scanner;

public class MULTIPLESAVERAGE {
    int multiple=5;
    public float findAveragesBy5s(int n){

        int count=n/this.multiple;
        return (float) (count+1)*5/2;
    }
public static void main(String[] args){
    int n;
    Scanner sc=new Scanner(System.in);
    n=sc.nextInt();
    if(n>0 && n<32767){
        MULTIPLESAVERAGE ma=new MULTIPLESAVERAGE();
        System.out.format("%.2f",ma.findAveragesBy5s(n));
    }
    else
        System.out.println("Invalid input");
}
}
