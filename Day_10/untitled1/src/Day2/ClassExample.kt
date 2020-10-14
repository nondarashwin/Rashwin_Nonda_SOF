package Day2

class Student{
    var rollNo:Int=0
    var Name:String=""
    fun input(tollNo:Int=20,Name:String="john Doe"){
        this.rollNo=tollNo
        this.Name=Name
    }
    fun output(){
        print("Name $Name RollNO $rollNo")
    }
}
fun changeAddress()
{
    var s1=Student()
    s1.input(Name= "Delhi")
    s1.output()
}
fun main(args:Array<String>){
    var s=Student()
    s.input(12,"raksha")
    s.output()
}