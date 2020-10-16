package assignment1

/*
8. Declare a dynamic array it contains ANY type of data and iterate the array values using for loop.
 */
fun main() {
    val a = ArrayList<Any>()
    a.add("rashwin")
    a.add("s")
    a.add("nonda")
    a.add(12)
    a.add(30)
    a.add(30.0f)
    for (i: Any in a) {
        println(i)
    }

}