import java.util.Scanner;

public class LARGEST_ARRAYS {
    int[] output1;
    public void getoutput1(){
        for(int i=0;i<output1.length;i++)
            System.out.println(output1[i]);
    }
    public void largestArrays(int[] array,int[] array2,int size){
        output1=new int[size];
for(int i=0;i<size;i++){
    if(array[i]>array2[i])
        output1[i]=array[i];
    else
        output1[i]=array2[i];
}
    }
   public static void main(String[] args){
       int n;
       int[] a,b;
       boolean flag=true;
       Scanner sc=new Scanner(System.in);
       n=sc.nextInt();
       if(n<0){
           flag=false;
       }
       if(flag){
           a=new int[n];
           b=new int[n];
           for(int i=0;i<n;i++){
               a[i]=sc.nextInt();
               if(a[i]<0){
                   System.out.println("Invalid input");
                   flag=false;
                   break;
               }
           }
           if(flag){
               for(int i=0;i<n;i++){
                   b[i]=sc.nextInt();
                   if(b[i]<0){
                       System.out.println("Invalid input");
                       flag=false;
                       break;
                   }
               }
               if(flag){
LARGEST_ARRAYS la=new LARGEST_ARRAYS();
la.largestArrays(a,b,n);
la.getoutput1();
               }
           }
       }
       else
           System.out.println("Invalid input");
       sc.close();
   }
}

