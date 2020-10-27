package creator

import doa.conn
import doa.connectionClose
import doa.getConnection1
import doa.insert
import model.Product
import model.Stock
import model.Store
import java.sql.PreparedStatement

fun insert() {
    insert(Product(name = "Laptop", cost = 30000, info = "Low performance", type = "Electronics", continuity = true))
    insert(Product(name = "Mobile", cost = 70000, info = "8GB Ram", type = "Electronics", continuity = true))
    insert(Product(name = "Iron Box", cost = 700, info = "steam press", type = "Electronics", continuity = true))
    insert(Store(name = "anymore", address = "XYZ"))
    insert(Store(name = "Rai", address = "Dubai"))
    insert(Store(name = "song", address = "UAE"))
    insert(Stock(1, 1, 5))
    insert(Stock(1, 2, 20))
    insert(Stock(1, 3, 20))
    insert(Stock(2, 1, 5))
    insert(Stock(2, 2, 20))
    insert(Stock(2, 3, 20))
    insert(Stock(3, 1, 20))
    insert(Stock(3, 2, 5))
    insert(Stock(3, 3, 20))
}

fun create() {

    val sql = "CREATE TABLE IF NOT EXISTS Product(id INT PRIMARY KEY AUTO_INCREMENT,name varchar(10),type varchar(20),info varchar(20),cost varchar(20),continuity boolean);"
    val statement: PreparedStatement? = conn?.prepareStatement(sql)
    statement?.execute()

    val sql1 = "CREATE TABLE IF NOT EXISTS Stores(id INT PRIMARY KEY AUTO_INCREMENT,name varchar(10),address varchar(30),continuity boolean)"
    val statement1 = conn?.prepareStatement(sql1)
    statement1?.execute()

    val sql2 = "CREATE TABLE IF NOT EXISTS Stock(storeId INT,productId INT,stock INT,FOREIGN KEY(storeId) REFERENCES Stores(id),FOREIGN KEY(productId) REFERENCES Product(id),PRIMARY KEY (storeId,productId))"
    val statement2 = conn?.prepareStatement(sql2)
    statement2?.execute()
    val sql3= "CREATE TABLE IF NOT EXISTS Billing(id INT PRIMARY KEY AUTO_INCREMENT,storeId INT,totalAmount INT,FOREIGN KEY(storeId) REFERENCES Stores(id));"
    val statement3 = conn?.prepareStatement(sql3)
    statement3?.execute(sql3)
    val sql4 = "CREATE TABLE IF NOT EXISTS BillingProduct(billId INT,productId INT,cost INT,quantity INT,FOREIGN KEY(productId) REFERENCES Product(id),FOREIGN KEY(billId) REFERENCES Billing(id),PRIMARY KEY(billId,productId));"
    val statement4 = conn?.prepareStatement(sql4)
    statement4?.execute(sql4)

}

fun main() {
    getConnection1()
    create()
    insert()
    connectionClose()
}