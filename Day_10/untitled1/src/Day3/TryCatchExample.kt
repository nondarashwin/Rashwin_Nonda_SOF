package Day3

import java.lang.ArithmeticException

fun main(args: Array<String>) {
    try {
        var res = 20 / 0
        println(res)
    } catch (e: ArithmeticException) {
        println("Demoninator cannot be zero $e")
    }
    println("Rest of the code...")
}
