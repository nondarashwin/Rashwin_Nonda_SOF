package TrainTicket;

import java.util.Comparator;
import java.util.Objects;

public class Passenger implements Comparable<Passenger> {
    private String name;
    private int age;
    private char gender;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Passenger)) return false;
        Passenger passenger = (Passenger) o;
        return getAge() == passenger.getAge() &&
                getGender() == passenger.getGender() &&
                getName().equals(passenger.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getAge(), getGender());
    }

    public Passenger(String name, int age, char gender) throws InvalidInputException {
        setName(name);
        setAge(age);
        setGender(gender);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) throws InvalidInputException {
        if(gender=='M'||gender=='F')
        this.gender = gender;
        else{
            throw new InvalidInputException("The Gender should be M/F");
        }
    }

    @Override
    public int compareTo(Passenger passenger) {
        return this.getName().compareTo(passenger.getName());
    }
}
