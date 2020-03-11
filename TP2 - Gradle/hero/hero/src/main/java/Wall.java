import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.TerminalPosition;


public class Wall extends Element
{
    public Wall(int x, int y)
    {
        super(x,y);
    }


    public void draw(TextGraphics graphics)
    {
        graphics.setForegroundColor(TextColor.Factory.fromString("#123456"));
        graphics.putString(new TerminalPosition(position.getX(), position.getY()), "+");
    }
}