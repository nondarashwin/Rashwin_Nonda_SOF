package com.pattern.decorator;

public class GeneralShapeDecorated extends ShapeDecorator {
    String color;

    public GeneralShapeDecorated(Shape decoratedShape, String color) {
        super(decoratedShape);
        this.color = color;
    }


    public void draw() {
        this.decoratedShape.draw();
        setGeneralBorder(decoratedShape);
    }

    public void setGeneralBorder(Shape decoratedShape) {
        System.out.println("shape border color:" + color);
    }
}
