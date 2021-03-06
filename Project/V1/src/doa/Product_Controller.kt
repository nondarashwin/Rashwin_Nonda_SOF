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
        product.add(Product(productId = result.getInt("productId"), productName = result.getString("productName"), productCost = result.getString("productCost").toInt(), productInfo = result.getString("productInfo"), productType = result.getString("productType"), productContniuity = result.getBoolean("productConiuity"))
        )
    }
    return product
}

fun insert(product: Product): Boolean {
    val sql = "insert into Product(productName,productType,productInfo,productCost,productConiuity) values(?,?,?,?,?);"
    val statement: PreparedStatement? = conn?.prepareStatement(sql)
    statement?.setString(1, product.productName)
    statement?.setString(2, product.productType)
    statement?.setString(3, product.productInfo)
    statement?.setString(4, product.productCost.toString())
    statement?.setBoolean(5, product.productContniuity)
    var rowsInserted: Int? = statement?.executeUpdate()

    return true
}

fun updateProductRecord(product: Product) {
    val sql = "update Product set productName=?,productType=?,productInfo=?,productCost=?,productConiuity=? where productId=?"
    val statement = conn!!.prepareStatement(sql)
    statement?.setString(1, product.productName)
    statement?.setString(2, product.productType)
    statement?.setString(3, product.productInfo)
    statement?.setString(4, product.productCost.toString())
    statement?.setBoolean(5, product.productContniuity)
    statement?.setInt(6, product.productId)
    val rowsUpdated = statement.executeUpdate()

}

fun deleteProductRecord(product: Product) {
    product.productContniuity = false
    updateProductRecord(product)
    deleteStockRecord(product.productId, "Store")
}
