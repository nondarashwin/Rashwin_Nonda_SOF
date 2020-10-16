package Day3
import java.lang.NumberFormatException

fun main()
{
    val str=convertNumber("10.5")
    println(str)
}

fun convertNumber(str:String):Int{
    return try{
        Integer.parseInt(str)
    }catch(e: NumberFormatException)
    {
        0
    }
}