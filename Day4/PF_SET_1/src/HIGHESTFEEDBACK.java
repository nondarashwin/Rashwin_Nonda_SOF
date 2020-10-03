import java.util.Scanner;

public class HIGHESTFEEDBACK {
    int[] feedback;
    public void highestFeedback(int[] Metlife, int[] hardfort, int size) {
    int[] temp=new int[size*2];
    //boolean flag=false
    int count=0;
    for(int i=0;i<size;i++){
        temp[i]=Metlife[i];
        count+=1;
    }
    for(int i=0;i<size;i+=2){
        boolean flag=true;
        int j=0;
        for(j=0;j<count;j+=2){
            if(temp[j]==hardfort[i]){
                if(temp[j+1]<hardfort[i+1]){
                temp[j+1]=hardfort[i+1];}
                flag=false;
                break;

            }
        }
        if(flag){
            temp[j]=hardfort[i];
            temp[j+1]=hardfort[i+1];
            count+=2;
        }

    }
    feedback=new int[count];
    for(int i=0;i<count;i++){
        feedback[i]=temp[i];
    }
    }

    public static void main(String[] args) {
        int n;
        boolean flag = false;
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        if (n < 0 || n%2==1) {
            System.out.println("invalid array size");
        } else {
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
                if (a[i] < 0) {
                    flag = true;
                    break;
                }
            }
            if (flag == false) {
                int[] b = new int[n];
                for (int i = 0; i < n; i++) {
                    b[i] = sc.nextInt();
                    if (b[i] < 0) {
                        flag = true;
                        break;
                    }

                }
                if (flag == false) {
                    HIGHESTFEEDBACK hfb=new HIGHESTFEEDBACK();
                    hfb.highestFeedback(a,b,n);
                    for(int i=0;i<hfb.feedback.length;i++){
                        System.out.println(hfb.feedback[i]);
                    }

                } else {
                    System.out.println("Invalid Input");
                }
            } else {
                System.out.println("Invalid input");
            }
        }
    }
}
