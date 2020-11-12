package day4

fun main() {
    var list2: MutableList<String> = mutableListOf<String>("Delhi", "Mumbai", "Bangalore", "Chennai")
    var list3: MutableList<String> = mutableListOf<String>("Hyderabad", "Calcutta")
    printList(list2)
    list2.addAll(list3)
    printList(list2)
    list2.removeAt(0)
    list2.remove("Delhi")
    printList(list2)
    list2.set(2, "Chandigarh")
    printList(list2)
    list2.retainAll(list3)
    printList(list2)
    list2.clear()
    printList(list2)
    list2.addAll(list3)
    println(list2)
    list2.subList(0, 1)
    println(list2)
}


