package Day2

open class parent() {
    var a = 100 //public by default
    private var b = 200 //private to the parent class
    protected open var c = 300 //visible to parent & child
    internal var d = 4 //visible in this module

}

class child : parent() {
    override var c = 350

    //println()
    fun output() {
        println(a)
        println(c)
        println(d)
    }
}

fun main(args: Array<String>) {
    var p = parent()
    var c = child()
    println("Using parent instance ${p.a}")
    println(p.d)
    c.output()
    //parent.a,d are visible
    //child.c will not be visible
}