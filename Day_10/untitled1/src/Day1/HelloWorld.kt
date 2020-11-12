package Day1

import java.util.*

fun main(array: Array<String>) {
    println("Hello world")
    val read = Scanner(System.`in`)
    var langauge = "python"
    val noidea = 12
    var b: Byte = read.nextByte()
    println("u gave $b")
    var d: Double = read.nextDouble()
    println("u gave $d")
    var s: String = read.next()
    println("u gave $s")
    println(langauge + " " + noidea)
    var result: String = if (10 > 20) "10 is lwess than 20" else if (10 == 20) "10 is equal" else "da"
    println(result)
    var num1 = 10
    var num2 = 20
    var num3 = 30
    val result1: String = if (num1 > num2) {
        val max: Int = if (num1 > num3) {
            num1
        } else {
            num3
        }
        "$max"
    } else {
        val max: Int = if (num2 > num3) {
            num2
        } else {
            num3
        }
        "$max"
    }
    print(result1)

}