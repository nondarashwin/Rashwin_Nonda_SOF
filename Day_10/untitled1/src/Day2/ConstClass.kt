package day2
class Employee(id:Int,name:String){
    var eName:String=""
    var eId:Int=0
    init{
        eId=id
        eName=name
    }
    /*   fun input(id:Int,name:String)
       {
           eId=id
           eName=name
       }*/
    fun output()
    {
        println("Emp id is $eId")
        println("EmpName  is $eName")
    }
}
fun main(args:Array<String>)
{
    val e=Employee(1000,"John")
    //   e.input(1000,"John")
    e.output()
}