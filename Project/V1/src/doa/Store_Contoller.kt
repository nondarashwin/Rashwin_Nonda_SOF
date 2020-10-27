package doa



import model.Store
import java.sql.PreparedStatement
import java.sql.Statement

fun insert(store:Store): Boolean {
    val sql = "insert into Stores(StoreName,StoreAddress,StoreClosed) values(?,?,?);"
    val statement: PreparedStatement? = conn?.prepareStatement(sql)
    statement?.setString(1, store.storeName)
    statement?.setString(2, store.storeAddress)
    statement?.setBoolean(3, store.storeClosed)
    var rowsInserted: Int? = statement?.executeUpdate()

    return true
}
fun updateStoreRecord(store: Store) {
    val sql = "UPDATE Stores SET StoreName=?,StoreAddress=?,StoreClosed=? where storeId=?"
    val statement = conn!!.prepareStatement(sql)
    statement?.setString(1, store.storeName)
    statement?.setString(2, store.storeAddress)
    statement?.setBoolean(3, store.storeClosed)
    statement?.setInt(4,store.storeId)
    val rowsUpdated = statement.executeUpdate()

}
fun selectStoreRecord(): ArrayList<Store> {
    val sql = "SELECT * FROM Stores"
    val statement: Statement = conn!!.createStatement()
    val result=statement.executeQuery(sql)
    val store:ArrayList<Store> = arrayListOf()
    while (result.next()) {
        store.add(Store(result.getInt("storeId"),result.getString("StoreName"),result.getString("StoreAddress"),result.getBoolean("StoreClosed")))
    }
    return store
}
fun deleteStoreRecord(store: Store)
{
    store.storeClosed=false
    updateStoreRecord(store)
    deleteStockRecord(store.storeId,"Product")
}