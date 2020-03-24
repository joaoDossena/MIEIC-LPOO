package patterns;

import java.util.ArrayList;
import java.util.List;

public class SmartStrategy implements OrderingStrategy
{
    List<StringDrink> drinks = new ArrayList<>();
    List<StringRecipe> recipes = new ArrayList<>();

    @Override
    public void wants(StringDrink drink, StringRecipe recipe, StringBar bar)
    {
        if(bar.isHappyHour())
            bar.order(drink, recipe);
        else
        {
            this.drinks.add(drink);
            this.recipes.add(recipe);
        }
    }
    @Override
    public void happyHourStarted(StringBar bar)
    {
        for(int i = 0; i < this.drinks.size(); i++)
            bar.order(drinks.get(i), recipes.get(i));
    }
    @Override
    public void happyHourEnded(StringBar bar)
    {

    }
}
