package com.aor.refactoring.example2;

public class Circle implements Shape
{
    private double x;
    private double y;
    private double radius; // ONLY FOR CIRCLES

    public Circle(double x, double y, double radius)
    {
        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    public double getArea() { return Math.PI * Math.pow(this.radius, 2); }
    public double getPerimeter() { return 2 * Math.PI * this.radius; }
    public void draw(GraphicFramework graphics) { graphics.drawCircle(this.x, this.y, this.radius); }
}