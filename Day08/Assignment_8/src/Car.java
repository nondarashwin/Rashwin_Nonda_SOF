import java.io.Serializable;

class Engine implements Serializable {
    private transient String engineNo = "0000";
    private int cubicCapacity;

    public Engine() {
        this.engineNo = "0000";
        this.cubicCapacity = 0;
    }

    public Engine(String engineNo, int cubicCapacity) {
        this.engineNo = engineNo;
        this.cubicCapacity = cubicCapacity;
    }

    public String getEngineNo() {
        return engineNo;
    }

    public void setEngineNo(String engineNo) {
        this.engineNo = engineNo;
    }

    public int getCubicCapacity() {
        return cubicCapacity;
    }

    public void setCubicCapacity(int cubicCapacity) {
        this.cubicCapacity = cubicCapacity;
    }
}

public class Car implements Serializable {
    private transient String registrationNo = "0000";
    private String carMake;
    private Engine engine;

    public Car() {
        this.registrationNo = "0000";
        this.carMake = "0000";
        this.engine = new Engine();
    }

    public Car(String registrationNo, String carMake, Engine engine) {
        this.registrationNo = registrationNo;
        this.carMake = carMake;
        this.engine = engine;
    }

    public String getRegistrationNo() {
        return registrationNo;
    }

    public void setRegistrationNo(String registrationNo) {
        this.registrationNo = registrationNo;
    }

    public String getCarMake() {
        return carMake;
    }

    public void setCarMake(String carMake) {
        this.carMake = carMake;
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }
}
