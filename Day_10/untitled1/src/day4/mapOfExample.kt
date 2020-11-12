package day4


fun main() {
    val myMap = mapOf<Int, String>(1 to "Ravi", 2 to "Ramu", 3 to "Raju")
    for (k in myMap.keys)
        print(" " + myMap[k])
    println()
    //keys can be in any order
    val myMap1: Map<Int, String> = mapOf<Int, String>(1 to "xxx", 4 to "yyy", 2 to "zzz")
    for (k in myMap1.keys)
        print("Value at the $k = ${myMap1.get(k)} ")
    //Not declared the type of the key
    val myMap2 = mapOf(1 to "Banana", 3 to "Orange", "Fru" to "Mango", "num" to 20, 'c' to "Carrot", 5 to 200, null to "abcd")
    for (k in myMap2.keys)
        println("Value at the $k = ${myMap2.get(k)} ")
    println(myMap2.getValue("Fru"))
    println(myMap2.getValue(null))
    println(myMap2.containsValue("Carrot"))
    var e1 = Emp(100, "Ravi", "Delhi", 1000f)
    val myMap3: Map<Int, Emp> = mapOf<Int, Emp>(1 to e1)
    // for(k in myMap3)
    //  println("Value at the $k = ${myMap3.getValue(k)} ")

    for (e in myMap3.asIterable()) {
        println("key is = ${e.key}  Value is   ${e.value.eId} , ${e.value.eName},  ${e.value.eCity}, ${e.value.eSlary}")
    }

}
