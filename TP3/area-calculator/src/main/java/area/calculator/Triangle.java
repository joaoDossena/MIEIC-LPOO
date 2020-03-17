package area.calculator;

public class Triangle implements AreaShape
{
    private double base;
    private  double height;

    public Triangle(double b, double h)
    {
        this.base = b;
        this.height = h;
    }

    public void setBase(double base) { this.base = base; }
    public void setHeight(double height) { this.height = height; }

    public double getBase() { return base; }
    public double getHeight() { return height; }

    @Override
    public double getArea() { return this.base * this.height / 2; }

    @Override
    public void draw() { System.out.println("Triangle"); }
}
