package day4

fun main() {
    var list2: List<String> = listOf<String>("Delhi", "Mumbai", "Bangalore", "Chennai", "Delhi")
    var list3: List<String> = listOf<String>("Delhi", "Bangalore")
    for (items in list2) {
        print(" " + items)
    }

    println();
    println(list2.get(2))
    println(list2.indexOf("Mumbai"))
    println(list2.lastIndexOf("Delhi"))
    println(list2.size)
    println(list2.contains("Bangalore"))
    println(list2.containsAll(list3))
    println(list2.subList(1, 3))
    println(list2.drop(2))
    println(list2.dropLast(2))
    println(list2.isEmpty())


}