import java.util.*;

public class StudentMarks {
    public static void main(String[] args) {
        ArrayList<Integer> marks = new ArrayList<Integer>();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            marks.add(sc.nextInt());
        }
        int max;
        int min = max = marks.get(0);
        int avg = 0;
        int thirdperson = -1;
        for (int i = 0; i < marks.size(); i++) {
            avg += marks.get(i);
            if (min > marks.get(i)) {
                min = marks.get(i);
            }
            if (max < marks.get(i)) {
                max = marks.get(i);
            }
            if (i + 1 == 3) {
                thirdperson = marks.get(i);
            }
        }
        System.out.println("The Highest marks is" + max);
        System.out.println("The average marks is" + avg / marks.size());
        System.out.println("The third Person marks is" + thirdperson);
        Collections.sort(marks);
        Iterator it = marks.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }


    }
}
