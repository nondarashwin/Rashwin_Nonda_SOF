package assignment1

fun MutableMap<Int, ArrayList<Int>>.simpleInterest(key: Int): Int {

    var p = this[key]
//print(p?.get(0))
    //print(p?.get(1))
    if (p != null) return key * p?.get(0) * p?.get(1) / 100 else
        return 0


}


fun main() {
    var a: MutableMap<Int, ArrayList<Int>> = mutableMapOf()
    a.put(1000, arrayListOf(12,1))
   // a.put(2, 2000)
    for (i in a) {
        println("principal amount=${i.value} interest=${a.simpleInterest(i.key)}")
    }
}