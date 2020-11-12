
import java.util.*;

class Patient implements Comparable<Patient> {
    private int patientId, age;
    private String name;

    public Patient() {
        this.age = 0;
        this.patientId = 0;
        this.name = "";
    }

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Patient(int patientId, int age, String name) {
        this.patientId = patientId;
        this.age = age;
        this.name = name;
    }


    @Override
    public int compareTo(Patient patient) {
        return this.patientId - patient.patientId;
    }
}

class SortByAge implements Comparator<Patient> {

    @Override
    public int compare(Patient patient, Patient patient1) {
        return patient.getAge() - patient1.getAge();
    }
}

public class TestPatientList {
    public static void main(String[] args) {
        ArrayList<Patient> patients = new ArrayList<>();
        patients.add(new Patient(5, 23, "Rashwin"));
        patients.add(new Patient(3, 25, "Rahul"));
        patients.add(new Patient(2, 24, "Rashmi"));
        Collections.sort(patients);
        System.out.println("The Sort By Name");
        for (Patient patient : patients) {
            System.out.println("Patient Id:" + patient.getPatientId());
            System.out.println("Patient Name:" + patient.getName());
            System.out.println("Patient Age:" + patient.getAge());
        }
        System.out.println("The Sort By Age");
        Collections.sort(patients, new SortByAge());
        Iterator it = patients.iterator();
        while (it.hasNext()) {
            Patient patient = (Patient) it.next();
            System.out.println("Patient Id:" + patient.getPatientId());
            System.out.println("Patient Name:" + patient.getName());
            System.out.println("Patient Age:" + patient.getAge());
        }
        TreeSet<Patient> patientTreeSet = new TreeSet<>();
        patientTreeSet.addAll(patients);
        int age = getPatientAge("Rashmi", patientTreeSet);

        if (age > -2) {
            System.out.println("The Age=" + age);
        }
    }

    public static int getPatientAge(String Name, TreeSet<Patient> patients) {
        Iterator it = patients.iterator();
        while (it.hasNext()) {
            Patient patient = (Patient) it.next();
            if (patient.getName().equals(Name)) {
                return patient.getAge();
            }
        }
        System.out.println("Age Not Found");
        return -2;
    }
}

