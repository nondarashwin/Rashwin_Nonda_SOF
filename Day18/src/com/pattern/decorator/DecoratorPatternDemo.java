package com.pattern.decorator;

public class DecoratorPatternDemo {
    public static void main(String[] args) {
        Shape shape = new Rectangle();
        shape.draw();
        Shape blueRectangle = new GeneralShapeDecorated(shape, "Blue");
        blueRectangle.draw();
        Shape redRectangle = new GeneralShapeDecorated(shape, "Red");
        redRectangle.draw();
        Shape redFilledRectangle = new FillColorDecorator(shape, "red");
        redFilledRectangle.draw();
    }
}
