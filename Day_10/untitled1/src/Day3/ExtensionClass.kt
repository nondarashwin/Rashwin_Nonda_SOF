package Day3

class Vehicle {
    fun run(): String {
        return "Vehicle running"
    }


}

fun Vehicle.stop():String {

    return "Vehicle Stopped"
}

fun main(args: Array<String>) {
    val v = Vehicle()
    println(v.run())
    println(v.stop())


}



