package com.fn.openClosedPrinciple;

public class Optimize {
    public static void main(String[] args) {
        GraphicEditor ge = new GraphicEditor();
        ge.drawShape(new Rectangle());
        ge.drawShape(new Circle());
    }
}

class GraphicEditor {
    public void drawShape(Shape shape) {
        shape.draw();
    }
}

abstract class Shape {
    abstract void draw();
}

class Rectangle extends Shape {
    @Override
    void draw() {
        System.out.println("画个矩形");
    }
}

class Circle extends Shape {
    @Override
    void draw() {
        System.out.println("画个圆形");
    }
}