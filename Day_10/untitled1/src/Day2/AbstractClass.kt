package Day2


abstract class RBI{
    abstract var rateofInterest:Float
    abstract fun simpleInterest(p:Int, t:Int):Float
}
class HDFC:RBI() {
    override var rateofInterest=5.0f
    override fun simpleInterest(p: Int, t: Int): Float {

        return (p * rateofInterest *t) / 100
    }
}

class SBI:RBI()
{
    override var rateofInterest=8.0f
    override fun simpleInterest(p: Int,  t: Int): Float {

        return (p * rateofInterest *t) / 100
    }
}

fun main(args:Array<String>){
    var h:RBI =HDFC()
    var SI:Float
    SI=h.simpleInterest(1000,3)
    println("Simpleinterest from HDFC is $SI")
    var s:RBI=SBI()
    SI=s.simpleInterest(10000, 4)
    println("Simpleinterest from SBI is $SI")
}