package patterns;

import java.util.Objects;

public class StringReplacer implements StringTransformer
{
    private char toReplace;
    private char toBeReplaced;

    public StringReplacer(char tR, char tBR) { this.toReplace = tR; this.toBeReplaced = tBR; }

    @Override
    public void execute(StringDrink drink)
    {
        StringBuffer strB = new StringBuffer(drink.getText());

        for(int i = 0; i < strB.length(); i++)
        {
            if(Objects.equals(strB.charAt(i), this.toReplace))
                strB.setCharAt(i, this.toBeReplaced);
        }

        drink.setText(strB.toString());
    }
}
