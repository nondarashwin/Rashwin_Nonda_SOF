package day4

import java.util.*
import kotlin.collections.ArrayList

fun add():Emp{
    var sc=Scanner(System.`in`)
    print("Enter id")
    var id=sc.nextInt()
    sc.nextLine()
    print("Enter name")
    var name=sc.nextLine()
    print("Enter city")
    var city=sc.nextLine()
    print("Enter Salary")
    var salary=sc.nextFloat()
    return Emp(id,name,city,salary)

}
class Emp(var eId:Int, var eName:String, var eCity:String, var eSlary:Float)
fun main()
{

    var list4:ArrayList<Emp> = arrayListOf<Emp>()
    var sc=Scanner(System.`in`)
    print("Enter no of employee")
    var n=sc.nextInt()
    while(n>0){
        list4.add(add())
        n--
    }
    println()

    for(e in list4)
    {
        println("${e.eId}, ${e.eName}, ${e.eCity}, ${e.eSlary}")
    }



}