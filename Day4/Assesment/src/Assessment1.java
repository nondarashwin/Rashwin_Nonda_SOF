import java.util.Scanner;

public class Assessment1 {

    /*public static void main(String[] args){
        int a,i,number=0;
        Scanner sc=new Scanner(System.in);
        a=sc.nextInt();
        i=sc.nextByte();
        if(a<i && a>0 && i>0){
            String s="";
            for(int j=a;j<=i;j++){
               // System.out.println(number);
                String s1=s.concat(""+j);
                s=s1;
            }

            System.out.println(s);
        }
        else {
            System.out.println("Invalid input");
        }
        sc.close();
    }*/
    public static void main(String[] args){
        int a,i,number=0;
        Scanner sc=new Scanner(System.in);
        a=sc.nextInt();
        i=sc.nextByte();
        if(a<i && a>0 && i>0){
            for(int j=a;j<=i;j++){
                // System.out.println(number);
                int digit=1,temp=j;
                while(temp!=0){
                    digit*=10;
                    temp/=10;
                }
                number=number*digit+j;
            }
            System.out.println(number);
        }
        else {
            System.out.println("Invalid input");
        }
        sc.close();
    }
}
