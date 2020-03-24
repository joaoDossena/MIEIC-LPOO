package area.calculator;

public class AreaStringOutputter
{
    private SumProvider sumProvider;

    public AreaStringOutputter(SumProvider sp)
    {
        this.sumProvider = sp;
    }

    public String output()
    {
        return "Sum of areas: " + this.sumProvider.sum();
    }
}
