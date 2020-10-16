package Day3

fun main(args:Array<String>){
    var str1:String?="Welcome"
    println(str1?.length ?: 0)
    str1=null
    println(str1?.length ?: 0)
}