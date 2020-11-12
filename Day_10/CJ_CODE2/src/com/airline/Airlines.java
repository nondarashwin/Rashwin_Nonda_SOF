package com.airline;

public abstract class Airlines {
    private String airID, source, destination;

    public Airlines(String airID, String source, String destination) throws InvalidEntryException {
        setAirID(airID);
        setSource(source);
        setDestination(destination);
    }

    public String getAirID() {
        return airID;
    }

    public void setAirID(String airID) throws InvalidEntryException {
        if (airID.startsWith("BOEING"))
            this.airID = airID;
        else
            throw new InvalidEntryException("airID should start with BOEING");
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getDestination() {
        return destination;
    }

    public abstract void bookTicket(int noOfTickets);

    public void setDestination(String destination) throws InvalidEntryException {
        if (!this.getSource().equals(destination)) {
            this.destination = destination;
        } else
            throw new InvalidEntryException("Source and Destination Can't be same");
    }
}
