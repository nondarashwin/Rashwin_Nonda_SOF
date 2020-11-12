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
    val product: ArrayList<Product> = arrayListOf()
    while (result.next()) {
        product.add(Product(id = result.getInt("id"), name = result.getString("name"), cost = result.getString("cost").toInt(), info = result.getString("info"), type = result.getString("type"), continuity = result.getBoolean("continuity"))
        )
    }
    return product
}

fun insert(product: Product): Boolean {
    val sql = "insert into Product(name,type,info,cost,continuity) values(?,?,?,?,?);"
    val statement: PreparedStatement? = conn?.prepareStatement(sql)
    statement?.setString(1, product.name)
    statement?.setString(2, product.type)
    statement?.setString(3, product.info)
    statement?.setString(4, product.cost.toString())
    statement?.setBoolean(5, product.continuity)
    var rowsInserted: Int? = statement?.executeUpdate()

    return true
}

fun updateProductRecord(product: Product) {
    val sql = "update Product set name=?,type=?,info=?,cost=?,continuity=? where id=?"
    val statement = conn!!.prepareStatement(sql)
    statement?.setString(1, product.name)
    statement?.setString(2, product.type)
    statement?.setString(3, product.info)
    statement?.setString(4, product.cost.toString())
    statement?.setBoolean(5, product.continuity)
    statement?.setInt(6, product.id)
    val rowsUpdated = statement.executeUpdate()

}

fun deleteProductRecord(product: Product) {
    product.continuity = false
    updateProductRecord(product)
    deleteStockRecord(product.id, "Store")
}
