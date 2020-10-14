package Day2
fun welcome(name:String,job:String,fn:(String,String)->String){
    var state:String=fn(name,job)
    print(state)
}

fun main(args:Array<String>){

    val myLambda:(String,String)->String= { name,job-> "$name designation $job"}
   welcome("rashwin","spy",myLambda)
}