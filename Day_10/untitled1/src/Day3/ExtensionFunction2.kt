package Day3

fun MutableList<Int>.swap(index1: Int, index2: Int): MutableList<Int> {
    val tmp = this[index1] //"this represents the list
    this[index1] = this[index2]
    this[index2] = tmp
    return this
}


fun main(args: Array<String>) {
    val list = mutableListOf<Int>(15, 25, 23)
    println("List values are $list")
    val result = list.swap(0, 2)
    println("List values after swap $list")

}