package patterns;

public class HumanClient implements Client
{
    @Override
    public void happyHourStarted(Bar bar) { System.out.println("The bar's happy hour has started!"); }

    @Override
    public void happyHourEnded(Bar bar) { System.out.println("The bar's happy hour has ended!"); }

    @Override
    public void wants(StringDrink drink, StringRecipe recipe, StringBar bar)
    {
        
    }

}
