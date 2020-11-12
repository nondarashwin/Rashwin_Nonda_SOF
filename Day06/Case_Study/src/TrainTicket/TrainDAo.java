package TrainTicket;

import java.util.ArrayList;

public class TrainDAo {
    ArrayList<Train> trains = new ArrayList<>();

    private void addTrain() throws InvalidInputException {

        trains.add(new Train(111, "Mumbai", "Mangalore", "GaribRath", 750));
        trains.add(new Train(112, "Bangalore", "Mangalore", "Mangal Express", 1250));
    }

    public Train getTrain(int trainNo) throws InvalidInputException, InputNotFoundException {
        addTrain();
        for (Train train : trains) {
            if (train.getTrainNo() == trainNo) {
                return train;
            }
        }
        return null;
    }
}
