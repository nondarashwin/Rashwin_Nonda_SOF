package Day2


class Employ(City: String) {

    var eName: String = ""
    var eId: Int = 0
    var city: String = ""

    constructor(id: Int, name: String, city: String) : this(city) {
        print("construcot")
        this.eName = name
        this.eId = id
        this.city = city
    }

    /*   fun input(id:Int,name:String)
       {
           eId=id
           eName=name
       }*/
    fun output() {
        println("Emp id is $eId")
        println("EmpName  is $eName")
    }
}

fun main(args: Array<String>) {
    val e = Employ(1000, "John", "john")
    //   e.input(1000,"John")
    e.output()
}