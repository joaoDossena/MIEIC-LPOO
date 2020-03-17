package area.calculator;

public class Square implements AreaShape
{
    private double side;

    public Square(double s) { this.side = s; }

    public void setSide(double side) { this.side = side; }

    public double getSide() { return this.side; }

    @Override
    public double getArea() { return this.side * this.side; }

    @Override
    public void draw() { System.out.println("Square"); }
}
