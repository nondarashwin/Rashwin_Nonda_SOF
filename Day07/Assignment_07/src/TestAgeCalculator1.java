import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

class FormatNotMatching extends Exception {
    public FormatNotMatching(String message) {
        super(message);
    }
}

class AgeCalculator1 {
    private String Date;

    public String getDate() {
        return Date;
    }

    public void calculateAge() {
        DateFormat df1 = new SimpleDateFormat("dd/mm/yyyy");
        java.util.Date d1 = new Date();
        int year = Integer.parseInt(df1.format(d1).substring(6));
        //System.out.println(year);
        //System.out.println(Integer.parseInt(this.Date.substring(6)));
        System.out.println(year - Integer.parseInt(this.Date.substring(6)));

    }

    public void setDate(String date) throws FormatNotMatching {

        if (date.matches("../../....")) {
            this.Date = date;
        } else {
            throw new FormatNotMatching("date should be in dd/mm/yyyy format");
        }

    }
}

public class TestAgeCalculator1 {
    public static void main(String[] args) throws FormatNotMatching {
        AgeCalculator1 age = new AgeCalculator1();
        try {
            Scanner sc = new Scanner(System.in);
            String sdate1 = sc.nextLine();
            age.setDate(sdate1);
            age.calculateAge();


        } finally {

        }
    }
}
