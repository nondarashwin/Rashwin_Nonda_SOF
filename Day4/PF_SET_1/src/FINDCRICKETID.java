import java.util.Scanner;

public class FINDCRICKETID {
    int[] Cricket;
    int n=0;
    public void findCricketId(int[] array,int size,int score){
        Cricket=new int[size];
        for(int i=1;i<size;i+=2){
            if(array[i]>score){
            this.Cricket[this.n]=array[i-1];
            //System.out.println(this.Cricket);
            this.n+=1;
            }
        }
    }
    public static void main(String[] args) {
        int size, score;
        int[] array;
        boolean flag=true;
        Scanner sc = new Scanner(System.in);
        size = sc.nextInt();
        if (size >= 0 || size%2==1) {
            array = new int[size];
            for (int i = 0; i < size; i++) {
                array[i] = sc.nextInt();
                if(array[i]<0){
                    System.out.println("Invalid Input");
                    flag=false;
                    break;
                }

            }
            if(flag==true){
            score=sc.nextInt();
            if(score<0){
                System.out.println("Invalid Score");
            }
            else
            {
                FINDCRICKETID fci=new FINDCRICKETID();
                fci.findCricketId(array,size,score);
                for(int i=0;i< fci.n;i++){
                    System.out.println(fci.Cricket[i]);
                }

            }}
        } else {
            System.out.println("Invalid array size");
        }
    }
}
