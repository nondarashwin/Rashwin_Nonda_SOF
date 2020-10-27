package doa

import java.sql.*
import java.util.*
var conn: Connection? = null
fun getConnection1() {
    val connectionProps = Properties()
    connectionProps["user"] = "root"
    connectionProps["password"] = "root"
    try {
        Class.forName("com.mysql.cj.jdbc.Driver")
        conn = DriverManager.getConnection(
                "jdbc:mysql://localhost/Store",
                connectionProps)

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