import java.util.LinkedList;
import java.util.Scanner;

class CricketScoreAnalyser{
    private LinkedList<Integer> runsData=new LinkedList<>();

    public void addRunsToList(int score){
        runsData.add(score);
    }
    public double calcRunRate(){
        int over=50,avg=0;
        for(int i=0;i<runsData.size();i++){
            avg+=runsData.get(i);
        }
        return (double)avg/over;
    }
    public int lowestRuns(){
        int min=runsData.get(0);
        for(int i=0;i<runsData.size();i++){
            if(min>runsData.get(i)){
                min=runsData.get(i);
            }
        }
        return min;
    }
    public void displayRuns(){
        for(int runs:runsData){
            System.out.println(runs);
        }
    }
}
public class TestScoreAnalyser {
    public static void main(String[] args) {
CricketScoreAnalyser CSA=new CricketScoreAnalyser();
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter runs");
        String runs_line=sc.nextLine();
        String[] runs=runs_line.split(" ");
        for(String i:runs) CSA.addRunsToList(Integer.parseInt(i));
        System.out.println("Runs Scored");
        CSA.displayRuns();
        System.out.println("runrate"+CSA.calcRunRate());
        System.out.println("Lowest"+CSA.lowestRuns());
        System.out.println("totalPayer"+runs.length);
    }
}
