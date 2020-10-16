package Day3
fun main() {
    var str: String? = "Welcome to my session"
    if (str != null) {    //smart cast
        println(str.length)
    }

    //the smart cast also provides is or !is
    //is used to check whether the given type is of specified type
    //!is throws true or false basis on the comparison

    val temp: Any? =10.5f

    if(temp is String?)
    {
        if(temp != null)
            println("$temp->length is->${temp.length}")
        else
            println("temp is string of zero length")
    }
    if(temp !is String?)
    {
        if(temp != null)
            println("$temp")
        else
            println("temp is not a string")
    }
}