import java.io.*;

public class DeserializeCar {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        ObjectInputStream oos=new ObjectInputStream(new FileInputStream("Cardata.ser"));
        Car c=(Car)oos.readObject();
        oos.close();
        System.out.println("carMake "+c.getCarMake()+"\ncar reg "+c.getRegistrationNo()+"\nEngine No "+c.getEngine().getEngineNo()+"\ncc "+c.getEngine().getCubicCapacity());
    }
}
