import java.util.Scanner;

public class MAXIMUMSUM {
    public static void main(String[] args){
        int n,odd=0,even=0;
        Scanner sc=new Scanner(System.in);
        n=sc.nextInt();
        if(n>=0) {
            int[] numbers = new int[n];
            for(int i=0;i<n;i++){
                numbers[i]=sc.nextInt();
                if(numbers[i]<0){
                    System.out.println("Invalid input");
                    break;
                }
                if(numbers[i]%2==0){
                    even+=numbers[i];
                }
                else{
                    odd+=numbers[i];
                }
            }
            if(odd>even){
                System.out.println(odd);
            }
            else
                System.out.println(even);
        }
        else {
            System.out.println("Invalid array size");
        }
        sc.close();
    }
}
