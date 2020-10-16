package assignment1

import java.util.*

/*
5. Accept the business sales revenue of the employee as console input.
If the revenue is in  below range provide bonus as follows
10000-2000 bonus=1500
21000-40000 bonus=2500
41000-60000 bonus=3500
Any other number “Not eligible for now”
 Use when operator to do this code
 */
fun main() {
    val sc = Scanner(System.`in`)
    print("enter salary")
    val bonus = when (sc.nextInt()) {
        in 10000..20000 -> "bonus is 1500"
        in 21000..40000 -> "bonus is 2500"
        in 41000..60000 -> "bonus is 3500"
        else -> "Not Eligible"
    }
    print(bonus)
}