package area.calculator;

public class AreaXMLOutputter
{
    private SumProvider sumProvider;

    public AreaXMLOutputter(SumProvider sp)
    {
        this.sumProvider = sp;
    }

    public String output()
    {
        return "<area>" + this.sumProvider.sum() + "</area>";
    }
}
