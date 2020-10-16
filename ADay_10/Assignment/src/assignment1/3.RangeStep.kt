package assignment1
/*
3. Declare a float range from 45.5 to 100.5
1. check whether the value 64.5 is present in the range,
2. if it is available then display the output
3. Reverse the range and display the output for every alternate number
 */
fun reverse(start: Double, end: Double, step:Double){
    var temp=end
    while(temp in start..end){
        println(temp)
        temp=temp+step*-1
    }
}
fun main() {
    val floatrange=45.5..100.5
    if(64.5 in floatrange){
        print("64.5 is in range")
    }
    else{
        print("64.5 is not in range")
    }
    var temp=floatrange.endInclusive
    var step=0.5
    while(temp in floatrange){
        println(temp)
        temp=temp+step*-1
    }



}
