package Day2

open class Emp4(name: String, age: Int, salary: Float) {
    init {
        println("EmpName ${name}")
        println("EmpAge ${age}")
        println("EmpSalary ${salary}")
    }
}

class Developer1(name: String, age: Int, salary: Float, project: String) : Emp4(name, age, salary) {

    init {
        println("Emp Project ${project}")
    }
}

fun main(args: Array<String>) {
    val d = Developer1("John", 25, 4000f, "Website")

}
