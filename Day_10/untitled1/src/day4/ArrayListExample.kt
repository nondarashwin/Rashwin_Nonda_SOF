package day4


fun main() {
    var arraylist1 = ArrayList<String>()
    var arraylist2 = ArrayList<String>(4)
    var arraylist3 = ArrayList<String>(arraylist1)
    //print(arraylist2.size)
    arraylist1.add("Bangalore")
    arraylist1.add("Delhi")
    arraylist1.add("Chennai")
    arraylist1.add("Chennai")
    arraylist1.add("Chennai")
    printArrayList(arraylist1)
    println()
    arraylist2.add("Bangalore")
    arraylist2.add("Delhi")
    arraylist2.add("Chennai")
    arraylist2.add("Chennai")
    arraylist2.add("Chennai")
    arraylist2.add("Chennai")
    arraylist2.add("Chennai")
    arraylist2.add("Chennai")
    printArrayList(arraylist2)
    println()
    arraylist3.addAll(arraylist1)
    println(arraylist3.size)
    printArrayList(arraylist3)
}

fun <T> printArrayList(list: ArrayList<T>) {
    var tmp = list.iterator()
    while (tmp.hasNext()) {
        print(" " + tmp.next())
    }

}