package Day1

fun main(args: Array<String>) {
    var col: Int = 5
    var row: Int = 5
    do {
        col = 1
        do {
            print(col)
            col++
        } while (col <= row)
        println()
        row--
    } while (row > 0)
}