import java.util.Scanner;

public class PARTICIPANT_ID {
    public static void main(String[] args){
        int n,choice=0;
        boolean flag=false;
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter no of Participant");
        n=sc.nextInt();
        int Particpant[]=new int[n];
        System.out.println("Enter the IDs");
        for(int i=0;i<n;i++){
            Particpant[i]=sc.nextInt();
        }
        System.out.println("Enter the Search ID");
        choice=sc.nextInt();
        while(choice!=0){
            for(int i=0;i<n;i++){
                if(Particpant[i]==choice){
                    flag=true;
                    break;
                }
            }
            if(flag==true){
                System.out.println("the Participant ID "+choice+" Exists");
            }
            else
            {
                System.out.println("the Participant ID "+choice+" Doesn't Exists");
            }
            System.out.println("Enter the Search ID");
            choice=sc.nextInt();
        }
        sc.close();
    }
}
