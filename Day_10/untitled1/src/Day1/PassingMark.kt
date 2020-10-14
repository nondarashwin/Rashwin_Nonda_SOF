package Day1

import java.util.*

fun main(args:Array<String>){
    val read= Scanner(System.`in`)
    println("The Score in %")
    val marks:Int=read.nextInt()

    when(marks){
       in 1..34->print("Fail")
       in 35..49->print("Third Class")
        in 50..59->print("Second Class")
        in 60..100->print("First Class")
        else -> print("invalid")
    }

}