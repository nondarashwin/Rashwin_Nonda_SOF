package Day3

fun main(){
    var range1=1..6
    for(i:Int in range1.reversed()){
        print(i)
    }
    println()
    var range2:IntRange= IntRange(1,10)
    for(i:Int in range2.reversed()){
        print(i)
    }
    println()
    var range3:IntProgression= IntProgression.fromClosedRange(10,1,-1)
    for(i:Int in range3.reversed()){
        print(i)
    }
    println()
    var range4:IntProgression= IntProgression.fromClosedRange(10,1,-2)
    for(i:Int in range4.reversed()){
        print(i)
    }
    println()
}