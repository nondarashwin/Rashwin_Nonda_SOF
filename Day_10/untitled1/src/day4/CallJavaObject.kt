package day4

fun main(){
    val Res:String=MyJava.`fun`("Rashwin",1)
    println(Res)
    val a=MyJava()
    a.setFirstname("Rashwin")
    a.setLastname("Nonda")
    println("${a.getFirstname()} ${a.getLastname()}")
}