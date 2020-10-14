package Day2

fun add(num:Int, num1:Int, myLam: (Int) -> Unit) {

    myLam(num+num1)
}
fun main(args:Array<String>){

    val myLambda= { addResult:Int-> println("the adding number $addResult") }
    add(5,3,myLambda)
}