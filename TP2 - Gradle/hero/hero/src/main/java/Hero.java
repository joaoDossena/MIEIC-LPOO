import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;



public class Hero extends Element
{
    //Constructor
    public Hero(int x, int y)
    {
        super(x,y);
    }

    public Position moveUp() { return new Position(this.position.getX(), this.position.getY() - 1); }
    public Position moveDown() { return new Position(this.position.getX(), this.position.getY() + 1); }
    public Position moveRight() { return new Position(this.position.getX() + 1, this.position.getY()); }
    public Position moveLeft() { return new Position(this.position.getX() - 1, this.position.getY()); }


    public void draw(TextGraphics graphics)
    {
        graphics.setForegroundColor(TextColor.Factory.fromString("#FFFF33"));
        graphics.enableModifiers(SGR.BOLD);
        graphics.putString(new TerminalPosition(position.getX(), position.getY()), "X");
    }
}