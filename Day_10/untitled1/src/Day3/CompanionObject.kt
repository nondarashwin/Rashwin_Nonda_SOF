package Day3


class Student(rollno: Int, name: String) {
    init {
        println("Rollno is $rollno")
        println("name is $name")
    }

    companion object {
        fun collegeName(): String {
            return "College name is Manipal"
        }
    }
}

fun Student.Companion.collegeLoc(): String {
    return "College Location is Bangalore"
}

fun main() {
    var s = Student(100, "Raju")
    println(Student.collegeName())
    println(Student.collegeLoc())
    var s1 = Student(101, "Ravi")
    println(Student.collegeName())
    println(Student.collegeLoc())

}