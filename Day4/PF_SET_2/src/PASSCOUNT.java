import java.util.Scanner;

public class PASSCOUNT {
    int pass_marks=70;
    public int passCount(int[] array,int size){
        int count=0;
        for(int i=1;i<size;i+=2){
            if(array[i]>=pass_marks){
                count+=1;
            }
        }
        return count;
    }
    public static void main(String[] args){
int size;
        Scanner sc=new Scanner(System.in);
        size=sc.nextInt();
        boolean flag=true;
        if(size<0||size%2==1){
            System.out.println("Invalid array size");
        }
        else
        {
            int[] array=new int[size];
            for(int i=0;i<size;i++){
                array[i]=sc.nextInt();
                if(array[i]<0){
                    System.out.println("Invalid input");
                    flag=false;
                    break;
                }
            }
            if(flag){
              PASSCOUNT pc=new PASSCOUNT();
              System.out.println(pc.passCount(array,size));
            }
        }
    }
}
