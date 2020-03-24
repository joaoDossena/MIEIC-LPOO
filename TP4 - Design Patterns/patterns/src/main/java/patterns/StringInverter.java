package patterns;

public class StringInverter implements StringTransformer
{
    @Override
    public void execute(StringDrink drink)
    {
        String reverse = new StringBuffer(drink.getText()).reverse().toString();
        drink.setText(reverse);
    }
}
