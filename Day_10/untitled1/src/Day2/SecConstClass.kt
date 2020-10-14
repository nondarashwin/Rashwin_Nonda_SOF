package Day2


class Employe{

    var eName:String=""
    var eId:Int=0
    constructor(id: Int,name: String){
        print("construcot")
        this.eName=name
        this.eId=id
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
    val e=Employe(1000,"John")
    //   e.input(1000,"John")
    e.output()
}