package Day3

fun main() {
    val numArray = arrayOf(4, 8, 16, 34, 56, 23, 56)
    val denoArray = arrayOf(2, 0, 4, 0, 3)
    try {
        for (i in numArray.indices) {
            try {
                println(numArray[i].toString() + "/" + denoArray[i] + "=" + numArray[i] / denoArray[i])
            } catch (e2: ArithmeticException) {
                println("Can't divide by zero ")
            }
        }
    } catch (e1: ArrayIndexOutOfBoundsException) {
        println("Element not Found ")
    } finally {
        println("Code executed successfully")
    }
    println("Rest of the code")
}