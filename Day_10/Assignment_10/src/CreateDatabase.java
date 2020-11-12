import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateDatabase {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/SHOP", "root", "root");
        Statement statement = connection.createStatement();
        //statement.executeUpdate("DROP TABLE `PRODUCT`");
        statement.executeUpdate("CREATE TABLE `PRODUCT`(`PROD_CODE` INT PRIMARY KEY,`PROD_NAME` VARCHAR(40),`PROD_PRICE` INT,`PROD_CATG` VARCHAR(15))");

    }
}
