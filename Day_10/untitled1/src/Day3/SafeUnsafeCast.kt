package Day3

fun main(args: Array<String>) {
    var location: Any? = "Manipal"
    val unsafe: String? = location as String
    println(unsafe)
    val SafeString: String? = location
    println(SafeString)
    val SafeInt: Int? = location as? Int
    println(SafeInt)


}