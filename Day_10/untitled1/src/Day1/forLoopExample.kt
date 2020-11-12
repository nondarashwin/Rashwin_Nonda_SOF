package Day1

fun main(args: Array<String>) {
    var marks: Array<Int> = arrayOf(1, 2, 3)
    for (mark: Int in marks) {
        println(mark)
    }
    for (mark: Int in marks.indices) {
        println(marks[mark])
    }
}