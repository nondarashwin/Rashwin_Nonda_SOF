package TrainTicket;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;
import java.util.logging.SimpleFormatter;

public class TicketApplication {
    public static void main(String[] args) throws ParseException, InvalidInputException, InputNotFoundException, IOException {
        Scanner sc=new Scanner(System.in);
        //System.out.println("tes".substring(0,1));
        System.out.println("Enter Train No");
        int trainNo=sc.nextInt();
        sc.nextLine();
        TrainDAo tdao=new TrainDAo();
        Train t=tdao.getTrain(trainNo);
        System.out.println("Enter Date");
        Date d1=new SimpleDateFormat("dd/mm/yyyy").parse(sc.nextLine());
        System.out.println("Enter No of Passengers");
        int n=sc.nextInt();
        sc.nextLine();
        Ticket ticket=new Ticket(d1,t);
        System.out.println("Enter Name");
        String name=sc.nextLine();
        System.out.println(name);
        System.out.println("Enter Age");
        int Age=sc.nextInt();
        sc.nextLine();
        System.out.println("Enter Gender in M/F format only");
        char gender=sc.nextLine().charAt(0);
        ticket.addPassengers(name,Age,gender);
        for(int i=1;i<n;i++){
            System.out.println("Enter Name");
            name=sc.nextLine();
            //System.out.println(name);
            System.out.println("Enter Age");
            Age=sc.nextInt();
            sc.nextLine();
            System.out.println("Enter Gender in M/F format only");
            gender=sc.nextLine().charAt(0);
            ticket.addPassengers(name,Age,gender);
        }
        ticket.writeTicket();

    }
}
