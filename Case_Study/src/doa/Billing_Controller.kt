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

       Billing.add(Billing(result.getInt("billId"),result.getInt("storeId"), selectBillingProductRecord(result.getInt("billId")),result.getInt("totalAmount")))
    }
    return Billing
}
fun insert(billing: Billing): Int {
    var sql: String = "insert into Billing(storeId,Amount) VALUES(${billing.storeId},${billing.amount});SELECT @@IDENTITY";
    var statement: PreparedStatement? = conn?.prepareStatement(sql);
    var id:Int=0
    var rowsInserted: ResultSet? = statement?.executeQuery()
    if (rowsInserted != null) {
        while (rowsInserted.next()){
            id=rowsInserted.getInt("@@IDENTITY")
            billing.billId=id
            insertBP(billing)
        }
    }
    return id;
}
