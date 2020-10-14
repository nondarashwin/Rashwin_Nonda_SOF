package Day2

open class Emp3(name:String, age:Int, salary:Float)
{
    init{
        println("EmpName ${name}")
        println("EmpAge ${age}")
        println("EmpSalary ${salary}")
    }
}
class Developer(name:String,age:Int,salary:Float):Emp3(name,age,salary)
{

}

fun main(args:Array<String>)
{
    val d=Developer("John",25,4000f)
}
