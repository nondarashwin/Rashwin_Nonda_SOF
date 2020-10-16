package assignment1

import java.util.*

/*
1. Count Vowels in the String using functions

 */
fun count(str: String): Int {
    var Count = 0
    for (i: Char in str) {
        //println(i)
        when (i) {
            'a', 'e', 'i', 'o', 'u' -> Count++
            'A', 'E', 'I', 'O', 'U' -> Count++
        }
    }
    return Count
}

fun main() {
    val scanner = Scanner(System.`in`)
    val str: String = scanner.nextLine()
    print("The total vowel count is " + count(str))
}