package assignment1

import java.util.*
import kotlin.collections.ArrayList

fun main()
{
    var stringList:ArrayList<String> = arrayListOf<String>()
    var IntList:ArrayList<Int> = arrayListOf<Int>()
    var mixedList:ArrayList<Any> = arrayListOf<Any>()
    var scanner=Scanner(System.`in`)
    print("Enter 3 String")
    for(i in 0..2){
        stringList.add(scanner.nextLine())

    }
    print("Enter 3 Integer value")
    for(i in 0..2){
        IntList.add(scanner.nextInt())

    }
    scanner.nextLine()
    print("Enter 3 choice of your datatype")
    for(i in 0..2){
        mixedList.add(scanner.nextLine())

    }
    println("Strings you Entered")
    stringList.printList()
    println("Integer Value you Entered")
    IntList.printList()
    println("Mixed Datatype you Entered")
    mixedList.printList()
}

fun <T>ArrayList<T>.printList()
{
    for(element in this)
    {
        println(element)
    }
}