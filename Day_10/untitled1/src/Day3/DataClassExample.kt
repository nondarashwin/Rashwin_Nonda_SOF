package Day3

data class Employee(var empId:Int, var empName: String ="Not Entered", var empEmail: String ="Not Provided")

fun main(args:Array<String>)
{
    val e1=Employee(100,"John","john@gmail.com")
    println(e1)
    val e2=Employee(100,"John","john@gmail.com")
    println(e2)
    println(e1==e2)
    println(e1.equals(e2))
    val e3=e1.copy(empId=1000)
    println(e3)
    val e4=Employee(2000)
    println(e4)
}