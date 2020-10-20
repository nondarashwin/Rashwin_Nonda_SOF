package doa



import model.Store
import java.sql.PreparedStatement
import java.sql.Statement

fun insert(store:Store): Boolean {
    var sql: String = "insert into Stores(StoreName,StoreAddress,StoreClosed) values(?,?,?);";
    var statement: PreparedStatement? = conn?.prepareStatement(sql);
    if (statement != null) {
        statement.setString(1, store.storeName)
    };
    if (statement != null) {
        statement.setString(2, store.storeAddress)
    };
    if (statement != null) {
        statement.setBoolean(3, store.storeClosed)
    };
    var rowsInserted: Int? = statement?.executeUpdate()
    if (rowsInserted != null) {
        if (rowsInserted > 0) {
            //System.out.println("A new user was inserted successfully!");
        }
    }
    return true;
}
fun updateStoreRecord(store: Store) {
    val sql = "UPDATE Stores SET StoreName=?,StoreAddress=?,StoreClosed=? where storeId=?"
    val statement = conn!!.prepareStatement(sql)
    if (statement != null) {
        statement.setString(1, store.storeName)
    };
    if (statement != null) {
        statement.setString(2, store.storeAddress)
    };
    if (statement != null) {
        statement.setBoolean(3, store.storeClosed)
    };
    if(statement!=null){
        statement.setInt(4,store.storeId)
    }
    val rowsUpdated = statement.executeUpdate()
    if (rowsUpdated > 0) {
        //println("An existing user was updated successfully!")
    }
}
fun selectStoreRecord(): ArrayList<Store> {
    val sql = "SELECT * FROM Stores"
    val statement: Statement = conn!!.createStatement()
    var result=statement.executeQuery(sql)
    var store:ArrayList<Store> = arrayListOf()
    while (result.next()) {
        store.add(Store(result.getInt("storeId"),result.getString("StoreName"),result.getString("StoreAddress"),result.getBoolean("StoreClosed")))
    }
    return store
}
fun deleteStoreRecord(store: Store)
{
    store.storeClosed=false
    updateStoreRecord(store)
}