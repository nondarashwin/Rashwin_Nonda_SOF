package doa

import java.sql.*
import java.util.*
var conn: Connection? = null
fun getConnection1() {
    var connectionProps = Properties()
    connectionProps.put("user", "root")
    connectionProps.put("password", "root")
    try {
        Class.forName("com.mysql.cj.jdbc.Driver")
        conn = DriverManager.getConnection(
                "jdbc:mysql://localhost/Store",
                connectionProps)
        if (conn != null) {
            //println("Connected successfully")
        }
    } catch (ex: SQLException) {
        // handle any errors
        ex.printStackTrace()
    } catch (ex: Exception) {
        // handle any errors
        ex.printStackTrace()
    }
}


fun connectionClose()
{
    conn?.close()
}