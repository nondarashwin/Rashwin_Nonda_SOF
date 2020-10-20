package doa

import model.Billing
import java.sql.PreparedStatement
import java.sql.ResultSet
import java.sql.Statement

fun selectBillingRecord(): ArrayList<Billing> {
    val sql = "SELECT * FROM Billing"
    val statement: Statement = conn!!.createStatement()
    val result: ResultSet = statement.executeQuery(sql)
    var count = 0
    var Billing:ArrayList<Billing> = arrayListOf()
    while (result.next()) {
    var id=result.getInt("billId")
        //println("$id ${result.getInt("totalAmount")}")
       Billing.add(Billing(id,result.getInt("storeId"), selectBillingProductRecord(id),result.getInt("totalAmount")))
    }
    return Billing
}
fun insert(billing: Billing): Int {
    var sql: String = "insert into Billing(storeId,totalAmount) VALUES(${billing.storeId},${billing.amount});";
    var statement: PreparedStatement? = conn?.prepareStatement(sql);
    var id:Int=0
    var rowsInserted= statement?.executeUpdate()
    var sql1:String="SELECT @@IDENTITY;"
    var statement1: PreparedStatement? = conn?.prepareStatement(sql1);
    var rowsInserted1=statement1?.executeQuery()
    if (rowsInserted1 != null) {
        while (rowsInserted1.next()){
            id=rowsInserted1.getInt("@@IDENTITY")
            billing.billId=id
            insertBP(billing)
        }
    }
    return id;
}
