package assignment1

import java.util.*

fun main() {
    var date1 = Calendar.getInstance()
    var date2 = Calendar.getInstance()
    print("Date 1 ")
    println("${date1.get(Calendar.DATE)}/${date1.get(Calendar.MONTH)}/${date1.get(Calendar.YEAR)}")
    date1.add(Calendar.YEAR, date2.get(Calendar.YEAR))
    date1.add(Calendar.MONTH, date2.get(Calendar.MONTH))
    date1.add(Calendar.DATE, date2.get(Calendar.DATE))
    print("Date 2 ")
    println("${date2.get(Calendar.DATE)}/${date2.get(Calendar.MONTH)}/${date2.get(Calendar.YEAR)}")
    print("${date1.get(Calendar.DATE)}/${date1.get(Calendar.MONTH)}/${date1.get(Calendar.YEAR)}")
}