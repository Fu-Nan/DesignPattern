package com.fn.openClosedPrinciple;

public class Original {
    public static void main(String[] args) {
        GraphicEditor ge = new GraphicEditor();
        ge.drawShape(new Rectangle());
        ge.drawShape(new Circle());
    }

}

/**
 * 使用方，绘图
 */
class GraphicEditor {
    public void drawShape(Shape shape) {
        if (shape.m_type == 1) {
            drawRectangle();
        } else if (shape.m_type == 2) {
            drawCircle();
        }
    }

    private void drawRectangle() {
        System.out.println("画个矩形");
    }

    private void drawCircle() {
        System.out.println("画个圆形");
    }
}

/**
 * 图形父类，提供方，提供图形
 */
class Shape {
    int m_type;
}

/**
 * 矩形
 */
class Rectangle extends Shape {
    Rectangle() {
        super.m_type = 1;
    }
}

/**
 * 圆形
 */
class Circle extends Shape {
    Circle() {
        super.m_type = 2;
    }
}
