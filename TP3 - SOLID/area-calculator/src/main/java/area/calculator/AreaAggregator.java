package area.calculator;


import java.util.*;
import java.util.ArrayList;

public class AreaAggregator implements SumProvider
{
    private List<HasArea> shapes = new ArrayList<>();

    public AreaAggregator() { }

    public void addShape(HasArea shape)
    {
        shapes.add(shape);
    }

    public double sum()
    {
        double sum = 0;
        for (HasArea shape: shapes)
           sum += shape.getArea();
        return sum;
    }

}
