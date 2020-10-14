package com.airline;



public class International extends Airlines {
    private String countryCode;
    private double ticketCost;


    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public double getTicketCost() {
        return ticketCost;
    }

    public void setTicketCost(double ticketCost) {
        this.ticketCost = ticketCost;
    }

    public International(String airID, String source, String destination, String countryCode, double ticketCost) throws InvalidEntryException {
        super(airID, source, destination);
        setTicketCost(ticketCost);
        setCountryCode(countryCode);

    }

    @Override
    public void bookTicket(int noOfTickets) {
        System.out.println("Air Id:"+getAirID());
        System.out.println("Source:"+getSource());
        System.out.println("Destination"+getDestination());
        System.out.println("Cost per person:"+getTicketCost());
        System.out.println("number of passenges are"+noOfTickets);
System.out.println("The total ticket cost is"+ticketCost*noOfTickets);
    }
}

