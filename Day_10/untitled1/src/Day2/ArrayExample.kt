package Day2
fun main(args:Array<String>){

    val myLambda:(String,String)->String= { name,job-> "$name designation $job"}
    welcome("rashwin","spy",myLambda)
}