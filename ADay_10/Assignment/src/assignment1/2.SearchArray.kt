package assignment1

import java.util.*

//2.Search for the given element in the Array using functions
fun search(a: IntArray, key: Any) {
    var flag = false
    var count = 0
    for (i: Any in a) {
        count++
        if (i.equals(key)) {
            flag = true
            break
        }

    }
    if (flag) {
        print("Element $key found at $count")
    } else {
        print("Element not found")
    }
}

fun main() {

    val scanner = Scanner(System.`in`)
    val n = scanner.nextInt()
    val a = IntArray(n)
    print("Enter array elements")
    for (i: Int in 0 until n) {
        a[i] = scanner.nextInt()
    }
    println("Enter Search element")
    val key: Any = scanner.nextInt()
    search(a, key)
}