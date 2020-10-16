package Day3


sealed class Shape{
    class Circle(var radius:Float):Shape()
    class Square(var length:Int):Shape()
    class Rectangle(var length:Int, var breadth:Int):Shape()
}
fun compute(s:Shape)
{
    when(s)
    {
        is Shape.Circle->println("Circle area is ${3.14*s.radius*s.radius}")
        is Shape.Square->println("Square area is ${s.length*s.length}")
        is Shape.Rectangle->println("Area of rectangle is ${s.length*s.breadth}")
    }
}
fun main(args:Array<String>){
    var circle=Shape.Circle(5.0f)
    var square=Shape.Square(5)
    var rectangle=Shape.Rectangle(4,5)

    compute(circle)
    compute(square)
    compute(rectangle)
}