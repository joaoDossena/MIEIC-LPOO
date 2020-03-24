package area.calculator;

public class Rectangle implements AreaShape
{
    private double width;
    private double height;

    public Rectangle(double w, double h)
    {
        this.width = w;
        this.height = h;
    }

    public void setHeight(double height) { this.height = height; }
    public void setWidth(double width) { this.width = width; }

    public double getHeight() { return height; }
    public double getWidth() { return width; }

    @Override
    public double getArea() { return this.width * this.height; }

    @Override
    public void draw() { System.out.println("Rectangle"); }
}
