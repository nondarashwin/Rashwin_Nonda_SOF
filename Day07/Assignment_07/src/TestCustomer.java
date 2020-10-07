import java.util.Scanner;

class InvalidInputExcpetion extends Exception{
   public InvalidInputExcpetion(String M){
        System.out.println(M);
    }
}
class Customer{
    private String custNo;
    private String custName;
    private String category;

    public String getCustNo() {
        return custNo;
    }

    public void setCustNo(String custNo) throws InvalidInputExcpetion{
       if(custNo.startsWith("C")|custNo.startsWith("c"))
        this.custNo = custNo;
       else
           throw new InvalidInputExcpetion("Custno should start with C or c");
    }

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) throws InvalidInputExcpetion {
        if(custName.length()>=4)
        this.custName = custName;
        else
            throw new InvalidInputExcpetion("custName Should be atleast 4 character");
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) throws InvalidInputExcpetion{
        if(category.equals("Platinum")|category.equals("Gold")|category.equals("Silver"))
        this.category = category;
        else

            throw new InvalidInputExcpetion("Category Not found");

    }

    public Customer(String custNo, String custName, String category) throws InvalidInputExcpetion {
        setCustNo(custNo);
        setCustName(custName);
        setCategory(category);
    }
}
public class TestCustomer {
    public static void main(String[] args) throws InvalidInputExcpetion {
        String custNo,custName,category;
        Scanner sc=new Scanner(System.in);
        custNo=sc.nextLine();
        custName=sc.nextLine();
        category=sc.nextLine();
        try{
Customer c=new Customer(custNo,custName,category);System.out.println(c.getCustNo());
            System.out.println(c.getCustName());
            System.out.println(c.getCategory());}
        finally {
            sc.close();
        }


    }
}
