package Day2

import Day1.add_numbers
import Day1.factorial_numbers

fun main(args:Array<String>){
    run()
    run(30,"rash")
    run(25,location = "nope")
    run(40,"rashw","m")

}
fun run(num:Int=50,name:String="rashwin",location:String="mangalore"){
    println("num="+num+" name="+name+" loaction="+location)
}