package area.calculator;

public class House implements HasArea
{
    private double area;

    public House(double a) { this.area = a; }

    public void setArea(double area) { this.area = area; }

    @Override
    public double getArea() { return this.area; }
}
