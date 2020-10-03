import java.util.Scanner;

public class PRIMEINDEXSUM {
    private boolean isPrime(int n){
        if(n==1){
            return false;
        }
        if(n==2){
            return true;
        }
        for(int i=2;i<=(int) Math.sqrt(n);i++)
            if(n%i==0)
                return false;
        return true;
    }
    public int primeIndexSum(int[] array,int size){
        int sum=0;
        for(int i=0;i<size;i++){
            if(isPrime(i+1)){
                sum+=array[i];
            }
        }
        return sum;
    }
    public static void main(String[] args){
        int n;
        boolean flag=false;
        Scanner sc=new Scanner(System.in);
        n=sc.nextInt();
        if(n>=0){
            int[] a=new int[n];
            for(int i=0;i<n;i++){
                a[i]=sc.nextInt();
                if(a[i]<0){
                    flag=true;
                    break;
                }
            }
            if(flag==true){
                System.out.println("Invalid input");
            }
            else{
                PRIMEINDEXSUM pis=new PRIMEINDEXSUM();
                System.out.println(pis.primeIndexSum(a,n));
            }
        }
        else {
            System.out.println("Invalid Array Size");
        }
    }
}
