package com.test;
import com.airline.*;

import java.util.ArrayList;
import java.util.Scanner;

public class TestAirline {
    public static void main(String[] args) throws InvalidEntryException {
        ArrayList<Airlines> airlines= new ArrayList<Airlines>();
        ArrayList<Domestic> domesticAirline=new ArrayList<>();
        airlines.add(new Domestic("BOEING001","MUMBAI","BANGALORE","Z001",3500));
        airlines.add(new Domestic("BOEING002","MUMBAI","DELHI","Z002",4000));
        airlines.add(new Domestic("BOEING003","MUMBAI","CHENNAI","Z003",3500));
        System.out.println("Enter no of Person");
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        ArrayList<International> internationalAirline=new ArrayList<>();
        domesticAirline.add(new Domestic("BOEING001","MUMBAI","BANGALORE","Z001",3500));
        domesticAirline.add(new Domestic("BOEING002","MUMBAI","DELHI","Z002",4000));
        domesticAirline.add(new Domestic("BOEING003","MUMBAI","CHENNAI","Z003",3500));
        internationalAirline.add(new International("BOEING004","Delhi","Prague","I001",25000));
        internationalAirline.add(new International("BOEING005","Delhi","Paris","I002",36000));
        internationalAirline.add(new International("BOEING006","Delhi","New York","I003",38000));
        System.out.println("Domestic Rates");
        for(Domestic plane:domesticAirline){
            System.out.println("**************************");
            plane.bookTicket(n);
        }
        System.out.println("international Rates");
        for(International plane:internationalAirline){
            System.out.println("**************************");
            plane.bookTicket(n);
        }
        System.out.println("Advance Happy Journey");
        sc.close();
    }
}
