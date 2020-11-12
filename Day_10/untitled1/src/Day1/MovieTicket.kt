package Day1

import java.util.*

fun main(args: Array<String>) {
    val read = Scanner(System.`in`)
    val weekday: Int = read.nextInt()
    when (weekday) {
        1, 3, 5 -> print("Go for movie")
        2, 4, 6, 7 -> print("Dont go for movie")
        else -> print("invalid")
    }

}