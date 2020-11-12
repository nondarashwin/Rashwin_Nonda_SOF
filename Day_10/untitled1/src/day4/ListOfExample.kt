package day4

fun printList(l: List<Any>) {
    for (i in l) {
        print(" " + i)
    }
    println()
}

fun main() {
    var list1: List<Int> = listOf<Int>(34, 56, 78, 89, 23, 45)
    var list2: List<String> = listOf<String>("Delhi", "Mumbai", "Bangalore", "Chennai")
    var list3: List<Any> = listOf<Any>(12, 34, 56.6, "Delhi", "Mumbai", "Bangalore", "Chennai", false, 'a')
    printList(list1)
    println()

    printList(list2)

    println()

    printList(list3)

    println()
}