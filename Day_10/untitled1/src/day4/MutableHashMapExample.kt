package day4

fun main()
{
    val myMap1:MutableMap<Int,String> = mutableMapOf<Int,String>(1 to "Ravi", 2 to "Raju")
    val myMap2:MutableMap<Any,Any> = mutableMapOf<Any,Any>(1 to "Ravi", "eId" to 100, 'c' to "Raju")
    val myMap3:MutableMap<Int,String> = mutableMapOf()
    myMap3.putAll(myMap1)
    for(i in myMap1){
    println("key=${i.key} value=${i.value}")
}

    for(i in myMap3){
        println("key=${i.key} value=${i.value}")
    }
}


