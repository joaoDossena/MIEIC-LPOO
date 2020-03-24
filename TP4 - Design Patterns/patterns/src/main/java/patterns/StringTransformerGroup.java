package patterns;

import java.util.List;

public class StringTransformerGroup implements StringTransformer
{
    private List<StringTransformer> transformers;

    public StringTransformerGroup(List<StringTransformer> l) { this.transformers = l; }

    public void execute(StringDrink drink)
    {
        for(StringTransformer strTransf : this.transformers)
        {
            strTransf.execute(drink);
        }
    }
}
