package day4

fun main() {
    var mySet1: MutableSet<String> = mutableSetOf<String>("a", "b", "c", "c")
    var mySet2: MutableSet<Any> = mutableSetOf<Any>(2, 6, 4, 5, 6.5, 6.4, "a", "b", "c", 'q')
    for (i in mySet1)
        println(i)
    println("set2")
    for (i in mySet2)
        println(i)

}