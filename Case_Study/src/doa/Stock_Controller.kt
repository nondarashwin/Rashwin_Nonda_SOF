package doa

import model.Stock
import java.sql.PreparedStatement
import java.sql.Statement

fun insert(stock: Stock): Boolean {
    var sql: String = "insert into Stock values(?,?,?);";
    var statement: PreparedStatement? = conn?.prepareStatement(sql);
    if (statement != null) {
        statement.setInt(1, stock.storeId)
    };
    if (statement != null) {
        statement.setInt(2, stock.productId)
    };
    if (statement != null) {
        statement.setInt(3, stock.Stock)
    };
    var rowsInserted: Int? = statement?.executeUpdate()
    if (rowsInserted != null) {
        if (rowsInserted > 0) {
            System.out.println("A new user was inserted successfully!")
        }
    }
    return true
}
fun updateStockRecord(stock: Stock) {
    val sql = "UPDATE Stock SET stock=? where storeId=? and productId=?"
    val statement = conn!!.prepareStatement(sql)
    if (statement != null) {
        statement.setInt(1, stock.Stock)
    };
    if (statement != null) {
        statement.setInt(2, stock.storeId)
    };
    if (statement != null) {
        statement.setInt(3, stock.productId)
    };
    val rowsUpdated = statement.executeUpdate()
    if (rowsUpdated > 0) {
        //println("An existing user was updated successfully!")
    }
}
fun selectStockRecord(): ArrayList<Stock> {
    val sql = "SELECT * FROM Stock"
    val statement: Statement = conn!!.createStatement()
    val result=statement.executeQuery(sql)
    var stock:ArrayList<Stock> = ArrayList()
    while (result.next()) {
        stock.add(Stock(result.getInt("storeId"),result.getInt("productId"),result.getInt("stock")))
    }
    return stock
}