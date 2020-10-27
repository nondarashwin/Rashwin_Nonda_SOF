package doa

import model.Billing
import model.Product
import creator.*
import java.sql.PreparedStatement
import java.sql.ResultSet
import java.sql.Statement
fun countBillingProduct():MutableMap<Int,Int>{
    val sql = "select billId,sum(quantity) from BillingProduct group by billId;"
    val statement: Statement = conn!!.createStatement()
    val result: ResultSet = statement.executeQuery(sql)
    val count:MutableMap<Int,Int> = mutableMapOf()
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
    val product:ArrayList<Product> = arrayListOf()
    while (result.next()) {
        val id=result.getInt("productId")
        for(i in product){
            if(i.id==id){
                print(id)
                i.cost=result.getInt("cost")
                i.quantity=result.getInt("quantity")
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
    val products= selectProductRecord()
    val product:ArrayList<Product> = arrayListOf()
    while (result.next()) {
        val id=result.getInt("productId")

        for(i in products){
            if(i.id==id){

                i.cost=result.getInt("cost")
                i.quantity=result.getInt("quantity")
                product.add(i)
            }
        }

    }
    return product
}
fun insertBP(billing: Billing) {
    for(i in billing.productIds){

    val sql = "insert into BillingProduct(billId,productId,cost,quantity) values(?,?,?,?);"
    val statement: PreparedStatement? = conn?.prepareStatement(sql)
        statement?.setInt(1, billing.id)
        statement?.setInt(2, i.id)
        statement?.setInt(3, i.cost)
        statement?.setInt(4, i.quantity)
        statement?.executeUpdate()


}}
