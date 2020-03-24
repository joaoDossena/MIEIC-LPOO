package patterns;

public class StringCaseChanger implements StringTransformer
{
    @Override
    public void execute(StringDrink drink)
    {
        StringBuffer strB = new StringBuffer(drink.getText());

        for(int i = 0; i < strB.length(); i++)
        {
            if(Character.isLowerCase(strB.charAt(i)))
                strB.setCharAt(i, Character.toUpperCase(strB.charAt(i)));
            else
                strB.setCharAt(i, Character.toLowerCase(strB.charAt(i)));
        }

        drink.setText(strB.toString());
    }
}
