import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;

import java.util.Random;


public class Monster extends Element
{
    //Constructor
    public Monster(int x, int y)
    {
        super(x,y);
    }

    public Position move()
    {
        Random random = new Random();
        Position result;
        int x = random.nextInt(4);

        switch(x)
        {
            case 0:
                result = new Position(this.position.getX(), this.position.getY() - 1);
                break;
            case 1:
                result = new Position(this.position.getX(), this.position.getY() + 1);
                break;
            case 2:
                result = new Position(this.position.getX() - 1, this.position.getY());
                break;
            case 3:
                result = new Position(this.position.getX() + 1, this.position.getY());
                break;
            default:
                result = new Position(this.position.getX(), this.position.getY());
        }

        return result;

    }


    public void draw(TextGraphics graphics)
    {
        graphics.setForegroundColor(TextColor.Factory.fromString("#FF0000"));
        graphics.enableModifiers(SGR.BOLD);
        graphics.putString(new TerminalPosition(position.getX(), position.getY()), "M");
    }
}