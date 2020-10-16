package assignment1
/*
4.  Accept the age and weight of a person from console input,
check whether the person is eligible to donate blood. If his age>18 and weight>55 he is eligible to donate blood
 */
import java.util.*

fun main() {
    val sc = Scanner(System.`in`)
    print("Enter the age")
    val age = sc.nextInt()
    print("Enter the Weight")
    val weight = sc.nextInt()
    if (age > 18 && weight > 55) {
        println("Eligible to donate blood")
    } else {
        println("Not Eligible to donate blood")
    }
}