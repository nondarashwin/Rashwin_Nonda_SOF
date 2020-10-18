package assignment1

fun MutableMap<Int, Int>.simpleInterest(key: Int): Double {

    var p = this[key]?.toInt()
    if (p != null) {
        return p * 5.0 * 3 / 100
    } else
        return 0.0


}

fun main() {
    var a: MutableMap<Int, Int> = mutableMapOf()
    a.put(1, 1000)
    a.put(2, 2000)
    for (i in a) {
        println("principal amount=${i.value} interest=${a.simpleInterest(i.key)}")
    }
}