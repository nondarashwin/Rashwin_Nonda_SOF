import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class REPEATED_SALARY_COUNT {
    public int countRepeaters(int[] salary,int n){
        int count=0,i=0;
        Arrays.sort(salary);
        while(i<n){
            int temp=0;
          for(int j=i+1;j<n;j++){
              if(salary[i]==salary[j]){
                  temp+=1;
              }
              else
                  break;
          }
          i+=1+temp;
          count+=temp;
          if(temp>0)
              count+=1;
        }


    return  count;
}

    public static void main(String[] args){
int n;
REPEATED_SALARY_COUNT rsc=new REPEATED_SALARY_COUNT();
        Scanner sc=new Scanner(System.in);
        n=sc.nextInt();
        int[] salary=new int[1];;
        boolean flag=false;
        if(n<0)
            flag=true;
        else
            salary=new int[n];


for(int i=0;i<n;i++){
    salary[i]=sc.nextInt();
    if(salary[i]<0){
        flag=true;
        break;
    }
}
if(flag==false){
System.out.println(rsc.countRepeaters(salary,n));
}
else {
    System.out.println("Invalid input");
}
sc.close();
    }

}
