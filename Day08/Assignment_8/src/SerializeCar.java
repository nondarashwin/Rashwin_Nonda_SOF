import java.io.*;

public class SerializeCar {


    public static void main(String[] args) throws IOException {
        Car c = new Car("ka18N4817", "petrol", new Engine("0001", 1000));
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("Cardata.ser"));
        oos.writeObject(c);
        oos.close();
    }
}
