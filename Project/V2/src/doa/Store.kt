package doa



import model.Store
import java.sql.PreparedStatement
import java.sql.Statement

fun insert(store:Store): Boolean {
    val sql = "insert into Stores(name,address,continuity) values(?,?,?);"
    val statement: PreparedStatement? = conn?.prepareStatement(sql)
    statement?.setString(1, store.name)
    statement?.setString(2, store.address)
    statement?.setBoolean(3, store.continuity)
    var rowsInserted: Int? = statement?.executeUpdate()

    return true
}
fun updateStoreRecord(store: Store) {
    val sql = "UPDATE Stores SET name=?,address=?,continuity=? where id=?"
    val statement = conn!!.prepareStatement(sql)
    statement?.setString(1, store.name)
    statement?.setString(2, store.address)
    statement?.setBoolean(3, store.continuity)
    statement?.setInt(4,store.id)
    val rowsUpdated = statement.executeUpdate()

}
fun selectStoreRecord(): ArrayList<Store> {
    val sql = "SELECT * FROM Stores"
    val statement: Statement = conn!!.createStatement()
    val result=statement.executeQuery(sql)
    val store:ArrayList<Store> = arrayListOf()
    while (result.next()) {

        store.add(Store(result.getInt("id"),result.getString("name"),result.getString("address"),result.getBoolean("continuity")))
    }
    return store
}
fun selectStoreRecord(id:Int): ArrayList<Store> {
    val sql = "SELECT * FROM Stores WHERE storeId=$id"
    val statement: Statement = conn!!.createStatement()
    val result=statement.executeQuery(sql)
    val store:ArrayList<Store> = arrayListOf()
    while (result.next()) {
        store.add(Store(result.getInt("id"),result.getString("name"),result.getString("address"),result.getBoolean("continuity")))
    }
    return store
}
fun deleteStoreRecord(store: Store)
{
    store.continuity=false
    updateStoreRecord(store)
    deleteStockRecord(store.id,"Product")
}