package assignment1
/*
6. Using TailRec compute factorial of the given number.Keep the number as < 50
 */
import java.util.*

tailrec fun factorial(fact: Int, sem: Long): Long {
    if (fact <= 1) {
        return sem
    }
    //println(sem)
    //println("n=$fact")
    return factorial(fact - 1, sem * fact)
}

fun main() {
    val sc = Scanner(System.`in`)
    print("Enter N value")
    val n = sc.nextInt()
    print("Factorial of $n is ${factorial(n, 1)}")

}