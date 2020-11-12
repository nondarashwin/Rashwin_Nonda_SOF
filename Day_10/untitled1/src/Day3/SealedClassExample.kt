package Day3


sealed class A {
    init {
        println("I am from class A")
    }

    class B : A() {
        init {
            println("I am from class B")
        }

        class E : A() {
            init {
                println("I am from class E")
            }
        }
    }

    class C : A() {
        init {
            println("I am from class C ")
        }
    }

}

class D : A() {
    //  class F:A() //throwing error
}

fun main() {
    val b = A.B()
    val c = A.C()
    val e = A.B.E()
}
