class Address {
    private String adressLine;
    private String city;

    Address(String adressLine, String city) {
        this.adressLine = adressLine;
        this.city = city;
    }

    public String getAdressLine() {
        return adressLine;
    }

    public void setAdressLine(String adressLine) {
        this.adressLine = adressLine;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAdressdetails() {
        return this.adressLine + ',' + this.city;
    }
}

class Customer {
    String customerName;
    Address residentialAdress;

    public Customer() {
        this.customerName = "john doe";
        this.residentialAdress = new Address("hsr layout", "bangalore");
    }

    public Customer(String customerName, Address residentialAdress) {
        this.customerName = customerName;
        this.residentialAdress = residentialAdress;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getResidentialAdress() {
        return residentialAdress.getAdressdetails();
    }

    public void setResidentialAdress(Address residentialAdress) {
        this.residentialAdress = residentialAdress;
    }

    public void getCustomerDetails() {
        System.out.println("Customer :" + this.customerName);
        System.out.println("Residential Address :" + this.residentialAdress.getAdressdetails());
    }
}

public class Question_1 {
    public static void main(String[] args) {
        Customer c = new Customer();
        c.setCustomerName("Rashwin");
        c.setResidentialAdress(new Address("lane 1", "managalore"));
        System.out.println(c.getCustomerName());
        System.out.println(c.getResidentialAdress());
        Customer c1=new Customer("ramu",new Address("lane2","Mangalore"));
        c1.getCustomerDetails();
    }
}
