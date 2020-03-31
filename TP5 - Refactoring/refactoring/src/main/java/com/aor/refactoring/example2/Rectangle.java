package com.aor.refactoring.example2;

public class Rectangle implements Shape
{
    private double x;
    private double y;
    private double width;  // ONLY FOR RECTANGLES
    private double height; // ONLY FOR RECTANGLES

    public Rectangle(double x, double y, double width, double height)
    {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public double getArea() { return this.width * this.height; }
    public double getPerimeter() { return 2 * (this.width + this.height); }
    public void draw(GraphicFramework graphics)
    {
        graphics.drawLine(x, y, x + width, y);
        graphics.drawLine(x + width, y, x + width, y + height);
        graphics.drawLine(x + width, y + height, x, y + height);
        graphics.drawLine(x, y + height, x, y);
    }
}