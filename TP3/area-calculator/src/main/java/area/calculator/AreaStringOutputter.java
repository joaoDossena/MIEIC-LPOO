package area.calculator;

public class AreaStringOutputter
{
    private AreaAggregator areaAgg;

    public AreaStringOutputter(AreaAggregator arAg)
    {
        this.areaAgg = arAg;
    }

    public String output()
    {
        return "Sum of areas: " + this.areaAgg.sum();
    }
}
