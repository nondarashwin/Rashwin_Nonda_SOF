package PatientHashSet;

import java.util.*;

class Patient implements Comparable<Patient> {
    private int patientId,age;
    private String name;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Patient)) return false;
        Patient patient = (Patient) o;
        return getPatientId() == patient.getPatientId() &&
                getAge() == patient.getAge() &&
                getName().equals(patient.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPatientId(), getAge(), getName());
    }

    public Patient() {
        this.age=0;
        this.patientId=0;
        this.name="";
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
        return this.patientId-patient.patientId;
    }
}

class SortByAge implements Comparator<Patient>{

    @Override
    public int compare(Patient patient, Patient patient1) {
        return patient.getAge()-patient1.getAge();
    }
}

public class TestPatientList {
    public static void main(String[] args) {
        LinkedHashSet<Patient> patients=new LinkedHashSet<>();
        patients.add(new Patient(5,23,"Rashwin"));
        patients.add(new Patient(5,23,"Rashwin"));
        patients.add(new Patient(2,24,"Rashmi"));
        System.out.println("The Total Patients:"+patients.size());
        Iterator it=patients.iterator();
        while(it.hasNext()){
            Patient patient=(Patient)it.next();
            System.out.println("Patient Id:"+patient.getPatientId());
            System.out.println("Patient Name:"+patient.getName());
            System.out.println("Patient Age:"+patient.getAge());
        }
        }

    }

