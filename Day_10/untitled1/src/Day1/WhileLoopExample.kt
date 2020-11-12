package Day1

fun main(args: Array<String>) {
    var col: Int = 5
    var row: Int = 5
    while (row > 0) {
        col = 1
        while (col <= row) {
            print(col)
            col++
        }
        println()
        row--
    }
}