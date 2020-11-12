package assignment1

class Calculator {
    companion object {
        fun add(a: Int, b: Int): Int {
            return a + b
        }

        fun minus(a: Int, b: Int): Int {
            return a - b
        }

        fun multiply(a: Int, b: Int): Int {
            return a * b
        }

        fun divide(a: Double, b: Double): Any {
            if (b == 0.0) {
                return "Can't Divde by zero"
            }
            return a / b
        }
    }
}

fun main() {
    println("Add 1+2=${Calculator.add(1, 2)}")
    println("subtract 3-5=${Calculator.minus(3, 5)}")
    println("Multiply 6*3=${Calculator.multiply(6, 3)}")
    println("Divide 1/2=${Calculator.divide(1.0, 2.0)}")
    println("Divide 1/0=${Calculator.divide(1.0, 0.0)}")
}