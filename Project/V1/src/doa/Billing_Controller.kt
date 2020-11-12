package doa

import model.Billing
import java.sql.PreparedStatement
import java.sql.ResultSet
import java.sql.Statement
import kotlin.collections.ArrayList

fun selectBillingRecord(): ArrayList<Billing> {
    val sql = "SELECT * FROM Billing"
    val statement: Statement = conn!!.createStatement()
    val result: ResultSet = statement.executeQuery(sql)
    var count = 0
    val billing: ArrayList<Billing> = arrayListOf()
    while (result.next()) {
        val id = result.getInt("billId")
        //println("$id ${result.getInt("totalAmount")}")
        billing.add(Billing(id, result.getInt("storeId"), selectBillingProductRecord(id), result.getInt("totalAmount")))
    }
    return billing
}

fun countStoreAmount(): MutableMap<Int, Int> {
    val sql = "select storeId,sum(totalAmount) from Billing group by storeId;"
    val statement: Statement = conn!!.createStatement()
    val result: ResultSet = statement.executeQuery(sql)
    val count: MutableMap<Int, Int> = mutableMapOf()
    while (result.next()) {
        if (count.containsKey(result.getInt(1)))
            count[result.getInt(1)] = count.getValue(result.getInt(1)) + result.getInt(2)
        else
            count[result.getInt(1)] = result.getInt(2)
    }
    return count
}

fun insert(billing: Billing): Int {
    val sql = "insert into Billing(storeId,totalAmount) VALUES(${billing.storeId},${billing.amount});"
    val statement: PreparedStatement? = conn?.prepareStatement(sql)
    var id = 0
    var rowsInserted = statement?.executeUpdate()
    val sql1 = "SELECT @@IDENTITY;"
    val statement1: PreparedStatement? = conn?.prepareStatement(sql1)
    val rowsInserted1 = statement1?.executeQuery()
    if (rowsInserted1 != null) {
        while (rowsInserted1.next()) {
            id = rowsInserted1.getInt("@@IDENTITY")
            billing.billId = id
            insertBP(billing)
        }
    }
    return id
}
