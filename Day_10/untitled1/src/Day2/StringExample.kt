package Day2

fun main(args:Array<String>){
    var a:String="qwerty";
    println(a)
    println(a.toUpperCase())
    println(a.toLowerCase())
    println(a.substring(0,3).toUpperCase())
var text="""
    Rashwin Nonda
    cold Heart
    nope
""".trimIndent()
    println(text)
    var text1="""
        #tum mile
        #asama chu gaye
        #tum mile
        #(music)
    """.trimMargin("#")
    println(text1)
}