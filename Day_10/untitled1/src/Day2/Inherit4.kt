package Day2

open class Emp5(name: String, age: Int, salary: Float) {
    init {
        println("EmpName ${name}")
        println("EmpAge ${age}")
        println("EmpSalary ${salary}")
    }
}

open class Developer2(name: String, age: Int, salary: Float, project: String) : Emp5(name, age, salary) {

    init {
        println("Emp Project ${project}")
    }
}

class SalesPerson(name: String, age: Int, salary: Float, project: String, bonus: Float) : Developer2(name, age, salary, project) {
    init {
        println("EMp Bonus is ${bonus}")
    }
}

fun main(args: Array<String>) {
    val d = SalesPerson("John", 25, 4000f, "Website", bonus = 10000f)

}
