package Day2



open class Bird{
    open var color=""
    open fun fly()
    {
        println("Bird is flying.....")
    }
}

interface Sparrow
{
    fun fly()
    {
        println("Sparrow is flying.....")
    }
}
class PeaCock:Bird(),Sparrow{
    override var color="Blue"
    override fun fly() {
        super<Bird>.fly()
        super<Sparrow>.fly()
        println("Peacock color is $color")
        println("Peacock is flying.......")
    }

}
fun main(args:Array<String>)
{
    var p=PeaCock()
    p.fly()
}