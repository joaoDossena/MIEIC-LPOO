package area.calculator;

public class Line implements Shape
{
    private double length;

    public Line(double l) { this.length = l; }

    public void setLength(double length) { this.length = length; }

    public double getLength() { return length; }

    @Override
    public void draw() { System.out.println("Line"); }
}
