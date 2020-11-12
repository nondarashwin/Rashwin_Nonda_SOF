package day4


fun main() {
    var list1: MutableList<Int> = mutableListOf<Int>()
    var list2: MutableList<String> = mutableListOf<String>("Delhi", "Mumbai", "Bangalore", "Chennai")
    var list3: MutableList<Any> = mutableListOf<Any>(12, 34, 56.6, "Delhi", "Mumbai", "Bangalore", "Chennai", false, 'a')

    list1.add(5)
    list1.add(4)
    list1.add(7)
    list1.add(3, 25)
    printList(list1)

    list2.add("Hyderabad")
    list2.add("Calcutta")
    printList(list2)


    list3.add(23)
    list3.add(23.5)
    list3.add("Welcome")
    list3.add('v')
    printList(list3)
}