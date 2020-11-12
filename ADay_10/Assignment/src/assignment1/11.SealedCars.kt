package assignment1

import java.util.*

sealed class Car {
    class Maruti : Car() {
        init {
            print("Indian Make")
        }

    }

    class Hyundai : Car() {
        init {
            print("Korean Make")
        }
    }

    class Honda : Car() {
        init {
            print("Japan Make")
        }
    }
}

fun main() {
    var scanner = Scanner(System.`in`)
    var str = scanner.nextLine()
    when (str) {
        "Maruti" -> Car.Maruti()
        "maruti" -> Car.Maruti()
        "Honda" -> Car.Honda()
        "honda" -> Car.Honda()
        "Hyundai" -> Car.Hyundai()
        "hyundai" -> Car.Hyundai()
        else -> print("car maker doesn't exists")
    }
}