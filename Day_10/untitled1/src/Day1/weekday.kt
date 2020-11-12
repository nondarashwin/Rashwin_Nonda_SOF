package Day1

import java.util.*

fun main(args: Array<String>) {
    val read = Scanner(System.`in`)
    val weekday: Int = read.nextInt()
    var result: String = when (weekday) {
        1 -> "Monday"
        2 -> "Tuesday"
        3 -> "Wednesday"
        4 -> "Thrusday"
        5 -> "Friday"
        6 -> "Saturday"
        7 -> "Sunday"
        else -> "invalid"
    }
    print(result)
}