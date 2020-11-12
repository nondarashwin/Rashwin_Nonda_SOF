package Day2

interface Vehicle {
    var numberofWheels: Int //abstract property
    fun doRun() //non-abstract method
    {
        println("I am a vehicle i can run long distances")
    }

    fun describe(): String //abstract method
}

class Car : Vehicle {
    override var numberofWheels = 4
    override fun describe(): String {
        return "I am car i have $numberofWheels as wheels, i can run long distance"
    }
}

class AutoRick : Vehicle {
    override var numberofWheels = 3
    override fun describe(): String {
        return "I am a Rick i have $numberofWheels as wheels, i can run limited distance"
    }
}

fun main(args: Array<String>) {
    var c = Car()
    c.doRun()
    println(c.describe())
    var r = AutoRick()
    r.doRun()
    println(r.describe())

}