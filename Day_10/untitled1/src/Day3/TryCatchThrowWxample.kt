package Day3

import java.lang.ArithmeticException

//Accept the age from the user.. if age is >18 display..eligible to vote
//or say not eligible...use throw keyword to demonstrate this/

fun main() {
    try {
        checkAge(15)
    } catch (e: ArithmeticException) {
        println(e)
    }
}

fun checkAge(age: Int) {
    if (age > 18)
        println("Eligible to Vote")
    else
        throw ArithmeticException("You are not eligible to vote")
}

