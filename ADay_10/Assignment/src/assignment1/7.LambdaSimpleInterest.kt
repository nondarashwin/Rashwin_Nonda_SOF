package assignment1
/*
7. Using Lambda function calculate the Simple Interest(p*t*r/100)
 */
import java.util.*

fun main() {
    val calInterest: (Int, Double, Int) -> Double = { p, t, r -> (p * t * r) / 100 }
    val sc = Scanner(System.`in`)
    print("enter principal")
    val p = sc.nextInt()
    print("enter rate")
    val r = sc.nextDouble()
    print("enter term")
    val t = sc.nextInt()
    print("interest is ${calInterest(p, r, t)}")
}