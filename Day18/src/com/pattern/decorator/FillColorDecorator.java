package com.pattern.decorator;

public class FillColorDecorator extends ShapeDecorator {
    String color;

    public FillColorDecorator(Shape decoratedShape, String color) {
        super(decoratedShape);
        this.color = color;
    }


    public void draw() {
        this.decoratedShape.draw();
        setFillColor(decoratedShape);
    }

    public void setFillColor(Shape decoratedShape) {
        System.out.println("shape  color:" + color);
    }
}
