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
    insert(Product(productName = "Laptop", productCost = 30000, productInfo = "Low performance", productType = "Electronics", productContniuity = true))
    insert(Product(productName = "Mobile", productCost = 70000, productInfo = "8GB Ram", productType = "Electronics", productContniuity = true))
    insert(Product(productName = "Iron Box", productCost = 700, productInfo = "no steam", productType = "Electronics", productContniuity = true))
    insert(Store(storeName = "ABC", storeAddress = "XYZ"))
    insert(Store(storeName = "Rai", storeAddress = "Dubai"))
    insert(Store(storeName = "song", storeAddress = "UAE"))
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

    val sql = "CREATE TABLE IF NOT EXISTS Product(productId INT PRIMARY KEY AUTO_INCREMENT,productName varchar(10),productType varchar(20),productInfo varchar(20),productCost varchar(20),productConiuity boolean);"
    val statement: PreparedStatement? = conn?.prepareStatement(sql)
    var created = statement?.executeUpdate()

    val sql1 = "CREATE TABLE IF NOT EXISTS Stores(storeId INT PRIMARY KEY AUTO_INCREMENT,storeName varchar(10),storeAddress varchar(30),storeClosed boolean)"
    val statement1 = conn?.prepareStatement(sql1)
    var created1 = statement1?.execute()

    val sql2 = "CREATE TABLE IF NOT EXISTS stock(storeId INT,productId INT,stock INT,FOREIGN KEY(storeId) REFERENCES Stores(storeId),FOREIGN KEY(productId) REFERENCES Product(productId),PRIMARY KEY (storeId,productId))"
    val statement2 = conn?.prepareStatement(sql2)
    var created2 = statement2?.execute()
    val sql3 = "CREATE TABLE IF NOT EXISTS Billing(billId INT PRIMARY KEY AUTO_INCREMENT,storeId INT,totalAmount INT,FOREIGN KEY(storeId) REFERENCES Stores(storeId));"
    val statement3 = conn?.prepareStatement(sql3)
    var create3 = statement3?.execute(sql3)
    val sql4 = "CREATE TABLE IF NOT EXISTS BillingProduct(billId INT,productId INT,cost INT,quantity INT,FOREIGN KEY(productId) REFERENCES Product(productId),FOREIGN KEY(billId) REFERENCES Billing(billId),PRIMARY KEY(billId,productId));"
    var statement4 = conn?.prepareStatement(sql4)
    var create4 = statement3?.execute(sql4)

}

fun main() {
    getConnection1()
    create()
    insert()
    connectionClose()
}