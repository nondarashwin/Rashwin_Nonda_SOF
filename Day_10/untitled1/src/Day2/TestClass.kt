package day2


class outerClass1 {
    var name: String = "John"

    inner class nestedClass1 {

        private var str: String = "Ramu"
        fun foo() {
            println(name) //you cannot access outer class members from nested class
            println(str)
        }
    }
}
fun main(args:Array<String>)
{
    var ob=outerClass1().nestedClass1()
    ob.foo()
}