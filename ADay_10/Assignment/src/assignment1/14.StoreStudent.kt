package assignment1

class Student(rollNo: Int = 0, name: String = "John Doe", city: String = "no Address") {
    private var rollNo: Int = 0
    private var name: String = ""
    private var city: String = ""
    fun setrollNo(rollNo: Int) {
        this.rollNo = rollNo
    }

    fun setName(name: String) {
        this.name = name
    }

    fun setCity(city: String) {
        this.city = city
    }

    fun getrollNo(): Int {
        return rollNo
    }

    fun getName(): String {
        return name
    }

    fun getCity(): String {
        return city
    }

    init {
        this.rollNo = rollNo
        this.name = name
        this.city = city
    }
}

fun main() {

    var students: MutableMap<Int, Student> = mutableMapOf()
    students.put(100, Student(100, "John", "Bangalore"))
    students.put(101, Student(101, "Peter", "Chennai"))
    students.put(102, Student(102, "Marks", "Mumbai"))
    students.put(103, Student(103, "Ravi", "Bangalore"))
    students.put(104, Student(104, "Meera", "Mumbai"))
    students.put(105, Student(105, "Usha", "Chennai"))
    students.put(106, Student(106, "Rekha", "Chennai"))
    students.put(107, Student(107, "Sunil", "Bangalore"))
    students.put(108, Student(108, "Tara", "Chennai"))
    students.put(109, Student(109, "Sun", "Mumbai"))
    students.put(110, Student(110, "Ramu", "Bangalore"))
    var studentDetails: Map<Int, Student> = students.toMap()
    for (i in studentDetails)
        if (i.value.getCity() == "Bangalore")
            println("RollNo=${i.value.getrollNo()} Name=${i.value.getName()} City=${i.value.getCity()}")
}