package area.calculator;

import javax.sound.sampled.Line;
import java.util.ArrayList;
import java.util.List;

public class App
{
    public static void main(String[] args)
    {
        AreaAggregator areaAgg = new AreaAggregator();

        areaAgg.addShape(new Circle(3));
        areaAgg.addShape(new Square(2));
        areaAgg.addShape(new Square(5));
        areaAgg.addShape(new Ellipse(2, 3));
        areaAgg.addShape(new Triangle(3, 4));

        areaAgg.addShape(new House(55));

        AreaStringOutputter stringOutputter = new AreaStringOutputter(areaAgg);
        AreaXMLOutputter xmlOutputter = new AreaXMLOutputter(areaAgg);

        System.out.println(stringOutputter.output());
        System.out.println(xmlOutputter.output());


        List<House> houses = new ArrayList<>();
        houses.add(new House(50));
        houses.add(new House(150));

        City city = new City(houses);

        AreaStringOutputter cityStringOutputter = new AreaStringOutputter(city);
        AreaXMLOutputter cityXmlOutputter = new AreaXMLOutputter(city);

        System.out.println(cityStringOutputter.output());
        System.out.println(cityXmlOutputter.output());

    }
}
