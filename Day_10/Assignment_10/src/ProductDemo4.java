import java.sql.*;

public class ProductDemo4 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection= DriverManager.getConnection("jdbc:mysql://localhost/SHOP","root","root");
        Statement statement=connection.createStatement();
        ResultSet resultSet=statement.executeQuery("select * from PRODUCT");
        while(resultSet.next()){
            System.out.println("******************");
            System.out.println("Product code"+resultSet.getString("PROD_CODE"));
            System.out.println("Product Name"+resultSet.getString("PROD_NAME"));
            System.out.println("Product price"+resultSet.getString("PROD_PRICE"));
            System.out.println("Product category"+resultSet.getString("PROD_CATG"));
        }
        statement.execute("UPDATE `PRODUCT` SET `PROD_PRICE`=`PROD_PRICE`*1.1 WHERE PROD_CATG='Electronics' and PROD_PRICE<=1000");
        statement.execute("UPDATE `PRODUCT` SET `PROD_PRICE`=`PROD_PRICE`*0.9 WHERE PROD_CATG='Clothing' and PROD_PRICE<=1000");
        resultSet=statement.executeQuery("select * from PRODUCT");
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
