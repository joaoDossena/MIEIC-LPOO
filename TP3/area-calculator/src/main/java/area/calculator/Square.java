package area.calculator;

public class Square extends Shape
{
    private double side;

    public Square(double s)
    {
        this.side = s;
    }

    public void setSide(double side)
    {
        this.side = side;
    }

    public double getSide()
    {
        return this.side;
    }
}
