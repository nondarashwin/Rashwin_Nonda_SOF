import java.util.Comparator;
import java.util.HashMap;
import java.util.Scanner;

public class ScoreCard {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashMap<String, Integer> player = new HashMap<>();
        String s1 = sc.nextLine();
        String[] scores = s1.split(" ");
        for (String score : scores) {
            String[] temp = score.split("-");
            player.put(temp[0], Integer.parseInt(temp[1]));
        }
        for (String i : player.keySet()) {
            System.out.println(i);
        }
        for (String i : player.keySet()) {
            System.out.println(i + "-" + player.get(i));
        }
        int total = 0, highest_score = 0;
        String Highest_Scorer = "";
        String Scored_by = "Dhoni";
        for (String i : player.keySet()) {
            total += player.get(i);
            if (highest_score < player.get(i)) {
                highest_score = player.get(i);
                Highest_Scorer = i;
            }


        }
        System.out.println("Total_score=" + total);
        System.out.println("The Highest Score =" + Highest_Scorer);
        if (player.containsKey(Scored_by))
            System.out.println(Scored_by + " scored" + player.get(Scored_by));
    }
}
