package Day1

fun main(args: Array<String>) {
    println(factorial_numbers(42))
    println(add_numbers(100000000, 0))

}

tailrec fun add_numbers(n: Int, semi: Long): Int {
    if (n <= 1)
        return 1
    else
        return add_numbers(n - 1, semi + n)
}

fun factorial_numbers(num: Int): Long {

    return if (num == 1) {
        num.toLong()
    } else {
        num * factorial_numbers(num - 1)
    }
}