package com.airline;

public class Domestic extends Airlines {
    private String zonalCode;
    private double ticketCost;

    public String getZonalCode() {
        return zonalCode;
    }

    public void setZonalCode(String zonalCode) {
        this.zonalCode = zonalCode;
    }

    public double getTicketCost() {
        return ticketCost;
    }

    public void setTicketCost(double ticketCost) {
        this.ticketCost = ticketCost;
    }

    public Domestic(String airID, String source, String destination, String zonalCode, double ticketCost) throws InvalidEntryException {
        super(airID, source, destination);
        setTicketCost(ticketCost);
        setZonalCode(zonalCode);

    }

    @Override
    public void bookTicket(int noOfTickets) {
        System.out.println("Air Id:" + getAirID());
        System.out.println("Source:" + getSource());
        System.out.println("Destination" + getDestination());
        System.out.println("Cost per person:" + getTicketCost());
        System.out.println("number of passenges are" + noOfTickets);
        System.out.println("The total ticket cost is" + ticketCost * noOfTickets);
    }
}
