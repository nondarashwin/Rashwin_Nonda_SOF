package doa

import model.Product
import java.sql.PreparedStatement
import java.sql.ResultSet
import java.sql.Statement

fun selectProductRecord(): ArrayList<Product> {
    val sql = "SELECT * FROM Product"
    val statement: Statement = conn!!.createStatement()
    val result: ResultSet = statement.executeQuery(sql)
    var count = 0
    var product:ArrayList<Product> = arrayListOf()
    while (result.next()) {
        product.add(Product(productId = result.getInt("productId"),productName = result.getString("productName"), productCost = result.getString("productCost").toInt(), productInfo = result.getString("productInfo"), productType = result.getString("productType"), productContniuity = result.getBoolean("productConiuity"))
                )
    }
    return product
}
fun insert(product:Product): Boolean {
    var sql: String = "insert into Product(productName,productType,productInfo,productCost,productConiuity) values(?,?,?,?,?);";
    var statement: PreparedStatement? = conn?.prepareStatement(sql);
    if (statement != null) {
        statement.setString(1, product.productName)
    };
    if (statement != null) {
        statement.setString(2, product.productType)
    };
    if (statement != null) {
        statement.setString(3, product.productInfo)
    };
    if (statement != null) {
        statement.setString(4, product.productCost.toString())
    };
   if(statement!=null){
       statement.setBoolean(5,product.productContniuity)
   }
    var rowsInserted: Int? = statement?.executeUpdate()
    if (rowsInserted != null) {
        if (rowsInserted > 0) {
            System.out.println("A new user was inserted successfully!")
        }
    }
    return true;
}
fun updateProductRecord(product: Product) {
    val sql = "update Product set productName=?,productType=?,productInfo=?,productCost=?,productConiuity=? where productId=?"
    val statement = conn!!.prepareStatement(sql)
    if (statement != null) {
        statement.setString(1, product.productName)
    };
    if (statement != null) {
        statement.setString(2, product.productType)
    };
    if (statement != null) {
        statement.setString(3, product.productInfo)
    };
    if (statement != null) {
        statement.setString(4, product.productCost.toString())
    };
    if(statement!=null){
        statement.setBoolean(5,product.productContniuity)
    }
    if(statement!=null){
        statement.setInt(6,product.productId)
    }
    val rowsUpdated = statement.executeUpdate()
    if (rowsUpdated > 0) {
        println("An existing user was updated successfully!")
    }
}
fun deleteProductRecord(product: Product)
{
    product.productContniuity=false
    updateProductRecord(product)
}
