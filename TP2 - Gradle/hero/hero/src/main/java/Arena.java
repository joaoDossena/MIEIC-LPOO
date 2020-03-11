import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;


import java.util.ListIterator;
import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;
import java.util.Random;
import java.io.IOException;



public class Arena
{
    private int width;
    private int height;
    private Hero hero = new Hero(10, 10);
    private List<Wall> walls;
    private List<Coin> coins;

    public Arena(int w, int h)
    {
        this.width = w;
        this.height = h;
        this.walls = createWalls();
        this.coins = createCoins();
    }

    private List<Wall> createWalls()
    {
        List<Wall> walls = new ArrayList<>();

        for(int c = 0; c < width; c++)
        {
            walls.add(new Wall(c, 0));
            walls.add(new Wall(c, height - 1));
        }

        for(int r = 1; r < height - 1; r++)
        {
            walls.add(new Wall(0, r));
            walls.add(new Wall(width - 1, r));
        }

        return walls;

    }

    private List<Coin> createCoins()
    {
        Random random = new Random();
        ArrayList<Coin> coins = new ArrayList<>();
        for (int i = 0; i < 5; i++)
            coins.add(new Coin(random.nextInt(this.width - 2) + 1, random.nextInt(this.height - 2) + 1));
        return coins;
    }

    private boolean canHeroMove(Position position)
    {
        if(position.getX() < 1 || position.getX() >= this.width - 1)
            return false;
        if(position.getY() < 1 || position.getY() >= this.height - 1)
            return false;
        else
            return true;
    }

    public void retrieveCoins(Position position)
    {
        for(Iterator<Coin> it = coins.listIterator(); it.hasNext(); )
        {
            Coin c = it.next();

            System.out.println("Hero: " + position.getX() + ", " + position.getY());
            System.out.println("Coin: " + c.getPosition().getX() + ", " + c.getPosition().getX());

            if(c.getPosition().equals(position))
            {
                it.remove();
                System.out.println("Got coin");
            }
        }
    }

    public void moveHero(Position position)
    {
        if(canHeroMove(position))
        {
            hero.setPosition(position);
            retrieveCoins(position);
        }
    }

    public int processKey(KeyStroke key) throws IOException
    {
        switch(key.getKeyType())
        {
            case Character: if(key.getCharacter() == 'q')
                return 1;
            case ArrowUp: moveHero(hero.moveUp());
                break;
            case ArrowDown: moveHero(hero.moveDown());
                break;
            case ArrowRight: moveHero(hero.moveRight());
                break;
            case ArrowLeft: moveHero(hero.moveLeft());
                break;
            default:
                break;
        }
        System.out.println(key);
        return 0;
    }

    public void draw(TextGraphics graphics)
    {
        graphics.setBackgroundColor(TextColor.Factory.fromString("#336699"));
        graphics.fillRectangle(new TerminalPosition(0, 0), new TerminalSize(width, height), ' ');
        for(Wall wall : walls)
            wall.draw(graphics);
        for(Coin coin : coins)
            coin.draw(graphics);
        this.hero.draw(graphics);
    }


}