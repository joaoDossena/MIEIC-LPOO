package area.calculator;

public class App
{
    public static void main(String[] args)
    {
        AreaAggregator areaAgg = new AreaAggregator();

        Shape c1 = new Circle(3);
        Shape sq1 = new Square(2);
        Shape sq2 = new Square(5);
        Shape el1 = new Ellipse(2, 3);

        areaAgg.addShape(c1);
        areaAgg.addShape(sq1);
        areaAgg.addShape(sq2);
        areaAgg.addShape(el1);


        AreaStringOutputter stringOutputter = new AreaStringOutputter(areaAgg);
        AreaXMLOutputter xmlOutputter = new AreaXMLOutputter(areaAgg);

        System.out.println(stringOutputter.output());
        System.out.println(xmlOutputter.output());

    }
}
