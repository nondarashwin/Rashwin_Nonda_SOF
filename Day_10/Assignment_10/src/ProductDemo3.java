import java.sql.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

class Product{
    private int prod_code,prod_price;
    private String prod_name,prod_catg;

    public int getProd_code() {
        return prod_code;
    }

    public void setProd_code(int prod_code) {
        this.prod_code = prod_code;
    }

    public int getProd_price() {
        return prod_price;
    }

    public void setProd_price(int prod_price) {
        this.prod_price = prod_price;
    }

    public String getProd_name() {
        return prod_name;
    }

    public void setProd_name(String prod_name) {
        this.prod_name = prod_name;
    }

    public String getProd_catg() {
        return prod_catg;
    }

    public void setProd_catg(String prod_catg) {
        this.prod_catg = prod_catg;
    }
}
public class ProductDemo3 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        ArrayList<Product> products=new ArrayList<>();
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter no of products");
        int n=sc.nextInt();
        while(n!=0){
            Product p=new Product();
            System.out.println("Enter Product Code");
            p.setProd_code(sc.nextInt());
            sc.nextLine();
            System.out.println("Enter Product Name");
            p.setProd_name(sc.nextLine());
            System.out.println("Enter Product Price");
            p.setProd_price(sc.nextInt());
            sc.nextLine();
            System.out.println("Enter Product Category");
            p.setProd_catg(sc.nextLine());
            products.add(p);
            n--;
        }
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection= DriverManager.getConnection("jdbc:mysql://localhost/SHOP","root","root");
        Statement statement=connection.createStatement();
        Iterator iterator=products.iterator();
        while (iterator.hasNext()){
            Product p= (Product) iterator.next();
            statement.execute("INSERT INTO PRODUCT VALUES("+p.getProd_code()+",'"+p.getProd_name()+"',"+p.getProd_price()+",'"+p.getProd_catg()+"');");
        }
        ResultSet resultSet=statement.executeQuery("select * from PRODUCT");
        while(resultSet.next()){
            System.out.println("******************");
            System.out.println("Product code"+resultSet.getString("PROD_CODE"));
            System.out.println("Product Name"+resultSet.getString("PROD_NAME"));
            System.out.println("Product price"+resultSet.getString("PROD_PRICE"));
            System.out.println("Product category"+resultSet.getString("PROD_CATG"));
        }
        //statement.executeUpdate("DROP TABLE `PRODUCT`");
        //statement.executeUpdate("CREATE TABLE `PRODUCT`(`PROD_CODE` INT PRIMARY KEY,`PROD_NAME` VARCHAR(40),`PROD_PRICE` INT,`PROD_CATG` VARCHAR(15))");

    }
}

