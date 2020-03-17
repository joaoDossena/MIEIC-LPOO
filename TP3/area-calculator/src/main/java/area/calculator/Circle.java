package area.calculator;

public class Circle implements AreaShape
{
    private double radius;

    public Circle(double rad)
    {
        this.radius = rad;
    }

    public void setRadius(double radius) { this.radius = radius; }

    public double getRadius() { return this.radius; }

    @Override
    public double getArea()
    {
        return Math.PI * this.radius * this.radius;
    }

    @Override
    public void draw() { System.out.println("Circle"); }
}
