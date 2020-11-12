package doa

import model.Stock
import java.sql.PreparedStatement
import java.sql.Statement

fun insert(stock: Stock): Boolean {
    val sql = "insert into stock values(?,?,?);"
    val statement: PreparedStatement? = conn?.prepareStatement(sql)
    statement?.setInt(1, stock.storeId)
    statement?.setInt(2, stock.productId)
    statement?.setInt(3, stock.stock)
    var rowsInserted: Int? = statement?.executeUpdate()

    return true
}

fun updateStockRecord(stock: Stock) {
    val sql = "UPDATE stock SET stock=? where storeId=? and productId=?"
    val statement = conn!!.prepareStatement(sql)
    statement?.setInt(1, stock.stock)
    statement?.setInt(2, stock.storeId)
    statement?.setInt(3, stock.productId)
    val rowsUpdated = statement.executeUpdate()

}

fun selectStockRecord(): ArrayList<Stock> {
    val sql = "SELECT * FROM stock"
    val statement: Statement = conn!!.createStatement()
    val result = statement.executeQuery(sql)
    val stock: ArrayList<Stock> = ArrayList()
    while (result.next()) {
        stock.add(Stock(result.getInt("storeId"), result.getInt("productId"), result.getInt("stock")))
    }
    return stock
}

fun deleteStockRecord(id: Int, type: String) {
    var sql = "DELETE FROM stock WHERE storeId=$id"
    if (type == "Product") {
        sql = "DELETE FROM stock WHERE productId=$id"
    }
    val statement = conn!!.prepareStatement(sql)
    val rowsDeleted = statement.executeUpdate()

}