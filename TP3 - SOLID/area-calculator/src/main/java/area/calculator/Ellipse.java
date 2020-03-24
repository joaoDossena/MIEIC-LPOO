package area.calculator;

public class Ellipse implements AreaShape
{
    private double xRadius;
    private double yRadius;

    public Ellipse(double xR, double yR)
    {
        this.xRadius = xR;
        this.yRadius = yR;
    }

    public void setxRadius(double xRadius) { this.xRadius = xRadius; }
    public void setyRadius(double yRadius)
    {
        this.yRadius = yRadius;
    }


    public double getxRadius()
    {
        return xRadius;
    }
    public double getyRadius()
    {
        return yRadius;
    }

    @Override
    public double getArea() { return Math.PI * this.xRadius * this.yRadius; }

    @Override
    public void draw() { System.out.println("Ellipse"); }
}
