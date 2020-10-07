import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

class FormatNotMatching1 extends Exception{
    public FormatNotMatching1(String message) {
        super(message);
    }
}
class AgeCalculator2{
    private String Date;

    public String getDate() {
        return Date;
    }
    public void calculateAge() throws FormatNotMatching1 {
        DateFormat df1=new SimpleDateFormat("dd/mm/yyyy");
        java.util.Date d1=new Date();
        int year=Integer.parseInt(df1.format(d1).substring(6));
        String das= df1.format(d1);
        //System.out.println("print");
        if(das.compareTo(this.Date)>0){
            throw new FormatNotMatching1("Date should before todays date");
        }
        System.out.println(year-Integer.parseInt(this.Date.substring(6)));

    }
    public void setDate(String date) throws FormatNotMatching1 {

        if(date.matches("../../....")){
            this.Date=date;
        }
        else {
            throw new FormatNotMatching1("date should be in dd/mm/yyyy format");
        }

    }
}
public class TestAgeCalculator2 {
    public static void main(String[] args) throws FormatNotMatching1{
        AgeCalculator2 age=new AgeCalculator2();
        Scanner sc=new Scanner(System.in);
        try {

            String sdate1=sc.nextLine();
            age.setDate(sdate1);
            age.calculateAge();


        }finally {
            sc.close();
        }
    }
}
