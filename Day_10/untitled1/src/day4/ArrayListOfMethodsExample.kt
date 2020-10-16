package day4

fun main()
{
    var list2:ArrayList<String> = arrayListOf("Delhi","Mumbai","Bangalore","Chennai")
    var list1:ArrayList<String> = arrayListOf<String>("xxx","yyyy","zzzz")

    println(list2.get(2))
    println()
    list2.add("Hyd")
    printArrayList(list2)
    println()
    println(list2.set(3,"Cal"))
    printArrayList(list2)
    println()
    list2.addAll(list1)
    printArrayList(list2)
    println()
    list1.clear()
    printArrayList(list1)
    println()
    list2.removeAt(3)
    printArrayList(list2)
    println()



}