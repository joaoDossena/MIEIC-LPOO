package patterns;

import java.util.List;

public class StringRecipe
{
    private List<StringTransformer> transformers;

    public StringRecipe(List<StringTransformer> l) { this.transformers = l; }

    public void mix(StringDrink drink)
    {
        for(StringTransformer strTransf : this.transformers)
        {
            strTransf.execute(drink);
        }
    }
}
