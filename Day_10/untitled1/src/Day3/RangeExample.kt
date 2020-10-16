package Day3

fun main(){
    for(i:Int in 4..8){
        println(i)
        if(i in 5..6){
            print("target locked")
            println()
        }

    }
    var r=5..6
    println(4 in r)
    println(5 in r)
    for(i:Char in 'a'..'z'){
        print(i)
    }
    println()
    for(i:Int in 5 downTo 3){
        print(i)
    }
    println()
    for(i:Int in 1 .rangeTo(10)){
        print(i)
    }
    println()
    for(i:Int in 1 .rangeTo(10) step 2){
        print(i)
    }
    println()
    val temp=1..5
    val it:IntIterator=temp.iterator()
    while(it.hasNext()){
        print(it.next())
    }
}