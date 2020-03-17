package area.calculator;

public class AreaXMLOutputter
{
    private AreaAggregator areaAgg;

    public AreaXMLOutputter(AreaAggregator arAg)
    {
        this.areaAgg = arAg;
    }

    public String output()
    {
        return "<area>" + this.areaAgg.sum() + "</area>";
    }
}
