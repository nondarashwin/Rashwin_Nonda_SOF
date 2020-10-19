package doa

import model.Billing
import model.Product
import java.sql.PreparedStatement
import java.sql.ResultSet
import java.sql.Statement
fun countBillingProduct():MutableMap<Int,Int>{
    val sql = "select productId,sum(quantity) from BillingProduct group by productId;"
    val statement: Statement = conn!!.createStatement()
    val result: ResultSet = statement.executeQuery(sql)
    var count:MutableMap<Int,Int> = mutableMapOf()
    while (result.next()){
        if(count.containsKey(result.getInt(1)))
            count[result.getInt(1)]=count.getValue(result.getInt(1))+result.getInt(2)
        else
            count[result.getInt(1)]=result.getInt(2)
    }
    return count
}
fun selectBillingProductRecord():ArrayList<Product>{
    val sql = "SELECT * FROM BillingProduct"
    val statement: Statement = conn!!.createStatement()
    val result: ResultSet = statement.executeQuery(sql)
    var products= selectProductRecord()
    var product:ArrayList<Product> = arrayListOf()
    while (result.next()) {
        var id=result.getInt("productId")
        for(i in product){
            if(i.productId==id){
                product.add(i)
            }
        }

    }
    return product
}
fun selectBillingProductRecord(billId:Int): ArrayList<Product> {
    val sql = "SELECT * FROM BillingProduct where billId=$billId"
    val statement: Statement = conn!!.createStatement()
    val result: ResultSet = statement.executeQuery(sql)
    var products= selectProductRecord()
    var product:ArrayList<Product> = arrayListOf()
    while (result.next()) {
        var id=result.getInt("productId")
        for(i in product){
            if(i.productId==id){
                product.add(i)
            }
        }

    }
    return product
}
fun insertBP(billing: Billing): Boolean {
    for(i in billing.productIds){
    var sql: String = "insert into BillingProduct(billId,productId,cost,quantity) values(?,?,?,?);";
    var statement: PreparedStatement? = conn?.prepareStatement(sql);
    if (statement != null) {
        statement.setInt(1, billing.billId)
    };
    if (statement != null) {
        statement.setInt(2, i.productId)
    };
    if (statement != null) {
        statement.setInt(3, i.productCost)
    };
    if (statement != null) {
        statement.setInt(4, i.productQuantity)
    };
    var rowsInserted: Int? = statement?.executeUpdate()
    if (rowsInserted != null) {
        if (rowsInserted > 0) {
            System.out.println("A new user was inserted successfully!")
        }
    }}
    return true;
}
