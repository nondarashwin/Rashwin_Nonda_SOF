package day4



fun main()
{
    var mySet=setOf(2,6,6,2,6.5,6.3,"Ravi","Raju","Ravi")
    for(items in mySet)
        println(items)
    println()
    println(mySet.drop(2))
    //  for(items in mySet)
    //    println(items)
    println(mySet.isEmpty())
    println(mySet.elementAt(3))
}