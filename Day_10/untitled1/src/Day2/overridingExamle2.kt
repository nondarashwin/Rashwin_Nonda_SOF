package Day2


open class Animal1{
    open var color=""
    open fun eat()
    {
        println("I am a animal..i like to eat always")
    }
}
open class Dog1:Animal()
{
    override var color="Brown"
    override fun eat()
    {
        println("I am a dog my color is $color i like to eat bones")
    }
    open fun bark()
    {
        println("I am a Dog..I bark heavily")
    }
}

class Puppy:Dog1()
{
    override var color="Black"
    override fun eat()
    {
        println("I am a puupy i like to drink")
    }
    override fun bark()
    {
        println("I am a Puppy..I cannot bark heavily")
    }

}

fun main(args:Array<String>)
{
    var p=Puppy()
    p.eat()
    p.bark()
    var d=Dog1()
    d.eat()
    d.bark()
}


