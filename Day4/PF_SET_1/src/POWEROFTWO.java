import java.util.Scanner;

public class POWEROFTWO {
    public static void main(String[] args){
        int n,power=2;
        Scanner sc=new Scanner(System.in);
        n=sc.nextInt();
        if(n<=0){
            System.out.println("number is too small");
        }
        else
        {
            if(n>32767){
                System.out.println("number is too large");
            }
            else{
                int floor,ceil;
                double a = Math.log10(n) / Math.log10(power);
                ceil=(int)Math.ceil(a);
                floor=(int)Math.floor(a);
                if(ceil==floor){
                    System.out.println("Yes");
                }
                else {
                    System.out.println("No");
                }
            }

        }
    }
}
