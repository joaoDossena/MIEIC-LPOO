package area.calculator;

public class Circle extends Shape
{
    private double radius;

    public Circle(double rad)
    {
        this.radius = rad;
    }

    public void setRadius(double radius)
    {
        this.radius = radius;
    }

    public double getRadius()
    {
        return this.radius;
    }
}
