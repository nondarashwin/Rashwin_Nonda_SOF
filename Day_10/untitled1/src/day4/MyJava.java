package day4;

public class MyJava {
    String firstname;
    String lastname;

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public static void main(String args[]) {
        System.out.println(fun("Swarna", 5));

    }

    public static String fun(String a, int number) {
        return "Welcome " + a + "to the learning " + "You are the " + number + " Learner ";
    }
}
