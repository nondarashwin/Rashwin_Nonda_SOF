import java.sql.*;
import java.util.Scanner;

public class ProductDemo2 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Product Code");
        int n = sc.nextInt();
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/SHOP", "root", "root");
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from PRODUCT where `PROD_CODE`=" + n);
        while (resultSet.next()) {
            System.out.println("******************");
            System.out.println("Product code" + resultSet.getString("PROD_CODE"));
            System.out.println("Product Name" + resultSet.getString("PROD_NAME"));
            System.out.println("Product price" + resultSet.getString("PROD_PRICE"));
            System.out.println("Product category" + resultSet.getString("PROD_CATG"));
        }
        //statement.executeUpdate("DROP TABLE `PRODUCT`");
        //statement.executeUpdate("CREATE TABLE `PRODUCT`(`PROD_CODE` INT PRIMARY KEY,`PROD_NAME` VARCHAR(40),`PROD_PRICE` INT,`PROD_CATG` VARCHAR(15))");

    }
}
