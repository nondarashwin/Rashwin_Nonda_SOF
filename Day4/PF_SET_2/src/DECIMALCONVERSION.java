import java.util.Scanner;

public class DECIMALCONVERSION {
    public int convertToDecimal(int binary){
        int decimal=0,base=1;
        if(binary<0 || binary>11111)
            return -1;
        while(binary!=0){
            if(binary%10>1)
                return -1;
            decimal+=(base*(binary%10));
            binary/=10;
            base*=2;
        }
        return decimal;
    }
    public static void main(String[] args){
        int number;
        Scanner sc=new Scanner(System.in);
        number=sc.nextInt();
        DECIMALCONVERSION dc=new DECIMALCONVERSION();
        int output=dc.convertToDecimal(number);
        if(output==-1)
            System.out.println("Invalid input");
        else
            System.out.println(output);
        sc.close();
    }
}
