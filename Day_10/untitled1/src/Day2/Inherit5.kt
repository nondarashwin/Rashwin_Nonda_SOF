package Day2


open class Emp6 {
    constructor(name: String, age: Int, salary: Float) {
        println("EmpName ${name}")
        println("EmpAge ${age}")
        println("EmpSalary ${salary}")
    }

    fun doWork() {
        println("I am an Employee, I love to Work always!!!!")
    }
}

class Developer3 : Emp6 {

    constructor(name: String, age: Int, salary: Float, project: String) : super(name, age, salary) {
        println("Emp Project ${project}")
    }

    fun doProgram() {
        println("I am a developer, i like to do programming")
    }
}

class SalesPerson2 : Emp6 {
    constructor(name: String, age: Int, salary: Float, bonus: Float) : super(name, age, salary) {
        println("EMp Bonus is ${bonus}")
    }

    fun doTravel() {
        println("I am a sales person, i like to do travelling")
    }
}

fun main(args: Array<String>) {
    val d = Developer3("John", 25, 4000f, "Website")
    d.doWork()
    d.doProgram();
    val s = SalesPerson2("John", 25, 4000f, 10000f)
    s.doWork()
    s.doTravel()

}

