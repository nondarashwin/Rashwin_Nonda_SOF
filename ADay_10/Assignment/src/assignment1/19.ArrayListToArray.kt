package assignment1

fun main(){
    var arraylist:ArrayList<Int> = arrayListOf(1,2,3,4,5)
    var array:Array<Any> = arraylist.toArray()
    for(i in array){
        print("$i ")
    }
    println()
    if(array is Array){
        print("array is of type Array")
    }
}