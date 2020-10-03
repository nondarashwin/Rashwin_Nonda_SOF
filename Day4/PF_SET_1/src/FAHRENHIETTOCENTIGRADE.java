import java.util.Scanner;

public class FAHRENHIETTOCENTIGRADE {
    public float convertToCentigrade(int f){
        return (float) 5*(f-32)/9;
    }
    public static void main(String[] args){
        int f;
        Scanner sc=new Scanner(System.in);
        f=sc.nextInt();
        FAHRENHIETTOCENTIGRADE ftc=new FAHRENHIETTOCENTIGRADE();
if(f>=0){
        System.out.format("%.2f",ftc.convertToCentigrade(f));

    }
else {
  System.out.println("Invalid Input");
}}
}
