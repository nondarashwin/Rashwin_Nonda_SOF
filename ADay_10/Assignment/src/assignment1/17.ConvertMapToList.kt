package assignment1

fun main() {
    var a: HashMap<String, Int> = hashMapOf("A" to 1, "B" to 2, "C" to 3)
    var value: MutableList<MutableList<Any>> = mutableListOf()
    for (i in a) {
        value.add(mutableListOf(i.key, i.value))
    }
    println("The HashMap")
    println(a)
    println("The List")
    println(value)
}