package TrainTicket;

public class Train {
    private int trainNo;
    private String source,destination,trainName;
    private double price;

    public Train(int trainNo, String source, String destination, String trainName, double price) throws InvalidInputException {
        setTrainNo(trainNo);
        setSource(source);
        setDestination(destination);
        setTrainName(trainName);
        setPrice(price);
    }

    public int getTrainNo() {
        return trainNo;
    }

    public void setTrainNo(int trainNo) {
        this.trainNo = trainNo;
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

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getTrainName() {
        return trainName;
    }

    public void setTrainName(String trainName) {
        this.trainName = trainName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) throws InvalidInputException {
        if(price>=0){
        this.price = price;}
        else {
            throw new InvalidInputException("Price Can't be Negative");
        }
    }
}
