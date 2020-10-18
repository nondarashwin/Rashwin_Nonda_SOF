package day4



fun main()
{
    val myMap1:HashMap<Int,String> = hashMapOf<Int,String>(1 to "Ravi", 2 to "Raju")
    val myMap2:HashMap<Any,Any> = hashMapOf<Any,Any>(1 to "Ravi", "eId" to 100, 'c' to "Raju")
println("map1")
    for(i in myMap1){
    println("key=${i.key} value=${i.value}")
}
println("map2")
    for(i in myMap2){
        println("key=${i.key} value=${i.value}")
    }
}