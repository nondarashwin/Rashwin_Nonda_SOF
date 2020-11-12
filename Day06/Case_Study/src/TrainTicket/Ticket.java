package TrainTicket;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.TreeMap;

public class Ticket {
    private static int counter = 100;
    private String pnr;
    private Date travelDate;
    private Train train;
    private TreeMap<Passenger, Integer> passengers = new TreeMap<>();

    public Ticket(Date travelDate, Train train) {

        this.travelDate = travelDate;
        this.train = train;
        setPnr();
    }

    private int getCounter() {
        setCounter();
        return counter - 1;
    }

    private void setCounter() {
        this.counter++;
    }

    public String getPnr() {
        return pnr;
    }

    public void setPnr() {
        this.pnr = generatePNR();
    }

    public Date getTravelDate() {
        return travelDate;
    }

    public void setTravelDate(Date travelDate) {
        this.travelDate = travelDate;
    }

    public Train getTrain() {
        return train;
    }

    public void setTrain(Train train) {
        this.train = train;
    }

    public TreeMap<Passenger, Integer> getPassengers() {
        return passengers;
    }

    private String generatePNR() {
        return this.getTrain().getSource().substring(0, 1) + this.getTrain().getDestination().substring(0, 1) + this.getCounter();
    }

    private int calcPassengerFare(Passenger p) {
        int cost = 0;
        if (p.getAge() <= 12) {
            return (int) ((int) this.train.getPrice() * .5);
        }
        if (p.getAge() >= 60) {
            return (int) ((int) this.train.getPrice() * .6);
        }
        if (p.getGender() == 'F') {
            return (int) ((int) this.train.getPrice() * .25);
        }
        return (int) this.train.getPrice();
    }

    public void addPassengers(String name, int age, char gender) throws InvalidInputException {
        System.out.println(name);
        Passenger p = new Passenger(name, age, gender);
        //System.out.println("add Passenger"+p.getName());
        this.passengers.put(p, calcPassengerFare(p));
    }

    private StringBuilder generateticket() {
        StringBuilder ticket = new StringBuilder();
        ticket.append("PNR:" + this.getPnr() + "\n");
        ticket.append("Train No:" + this.getTrain().getTrainNo() + "\n");
        ticket.append("Train Name:" + this.getTrain().getTrainName() + "\n");
        ticket.append("From:" + this.getTrain().getSource() + "\n");
        ticket.append("To:" + this.getTrain().getDestination() + "\n");
        ticket.append("Train Date" + this.getTravelDate().toString() + "\n");
        ticket.append("Passenger:\n");
        ticket.append("Name\tAge\tGender\tFare\n");
        for (Passenger passenger : passengers.keySet()) {
            //System.out.println("genrate ticket "+passenger.getName());
            ticket.append(passenger.getName() + "\t" + passenger.getAge() + "\t" + passenger.getGender() + "\t" + passengers.get(passenger) + "\n");
        }
        ticket.append("Total Price:" + calculateTotalTicketPrice());
        return ticket;
    }

    public void writeTicket() throws IOException {
        StringBuilder ticket = generateticket();
        File f1 = new File(getPnr() + ".txt");
        f1.createNewFile();
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(f1));
        bos.write(ticket.toString().getBytes());
        bos.close();
    }

    private double calculateTotalTicketPrice() {
        double cost = 0;
        for (Passenger passenger : passengers.keySet()) {
            //System.out.println(passengers.get(passenger));
            cost += passengers.get(passenger);
        }
        return cost;
    }
}
