import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.TerminalPosition;


public class Coin extends Element
{
    public Coin(int x, int y)
    {
        super(x,y);
    }

    public void draw(TextGraphics graphics)
    {
        graphics.setForegroundColor(TextColor.Factory.fromString("#FFFF00"));
        graphics.putString(new TerminalPosition(position.getX(), position.getY()), "O");
    }

}