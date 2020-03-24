import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.SGR;



import java.util.ListIterator;
import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;
import java.util.Random;
import java.io.IOException;



public class Arena
{
    private int maxNumCoins = 25;
    private int maxNumMonsters = 25;
    private int width;
    private int height;
    private Hero hero;
    private List<Monster> monsters;
    private List<Wall> walls;
    private List<Coin> coins;
    private int score = 0;
    private boolean stageComplete = false;
    private boolean gameOver = false;


    public Arena(int width, int height)
    {
        this.width = width;
        this.height = height;
        this.hero = new Hero(10,10);
        this.walls = createWalls();
        this.monsters = createMonsters();
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

    private List<Monster> createMonsters()
    {
        Random random = new Random();
        ArrayList<Monster> monsters = new ArrayList<>();


        while(monsters.size()!= maxNumMonsters){
            boolean positionTaken = false;
            int x = random.nextInt(width - 2) + 1;
            int y = random.nextInt(height - 2) + 1;

            //Does not spawn on top of hero
            if((hero.getPosition().getX() == x) && (hero.getPosition().getY() == y))
            {
                positionTaken = true;
                break;
            }

            //Does not spawn on top of another monster
            for(Monster monster : monsters)
            {
                if((monster.getPosition().getX() == x) && (monster.getPosition().getY() == y))
                {
                    positionTaken = true;
                    break;
                }
            }

            if(!positionTaken)
            {
                monsters.add(new Monster(x,y));
            }
        }
        return monsters;
    }

    private List<Coin> createCoins()
    {
        Random random = new Random();
        ArrayList<Coin> coins = new ArrayList<>();


        while(coins.size()!= maxNumCoins){
            boolean positionTaken = false;
            int x = random.nextInt(width - 2) + 1;
            int y = random.nextInt(height - 2) + 1;

            //Does not spawn on top of a coin
            for(Coin coin: coins)
            {
                if((coin.getPosition().getX() == x) && (coin.getPosition().getY() == y))
                {
                    positionTaken = true;
                    break;
                }
            }

            //Does not spawn on top of hero
            if((hero.getPosition().getX() == x) && (hero.getPosition().getY() == y))
            {
                positionTaken = true;
                break;
            }
            //Does not spawn on top of monster
            for(Monster monster : this.monsters)
            {
                if((monster.getPosition().getX() == x) && (monster.getPosition().getY() == y))
                {
                    positionTaken = true;
                    break;
                }
            }

            if(!positionTaken)
            {
                coins.add(new Coin(x,y));
            }
        }
        return coins;
    }


    private boolean canElementMove(Position position)
    {
        if(position.getX() < 1 || position.getX() >= this.width - 1)
            return false;
        if(position.getY() < 1 || position.getY() >= this.height - 1)
            return false;
        else
            return true;
    }

    public boolean verifyMonsterCollision()
    {
        for(Monster monster : this.monsters)
        {
            if(hero.getPosition().equals(monster.getPosition()))
            {
                System.out.println("Game over! The hero has touched one of the monsters");
                return true;
            }
        }
        return false;
    }

    public void retrieveCoins()
    {
        for(Coin coin : this.coins)
        {
            if(hero.getPosition().equals(coin.getPosition()))
            {
                coins.remove(coin);
                score += 1000;
                if(coins.size() == 0)
                    stageComplete = true;
                break;
            }
        }
    }

    public void moveHero(Position position)
    {
        if(canElementMove(position))
        {
            hero.setPosition(position);
            retrieveCoins();
        }
    }

    public void moveMonsters()
    {
        for(Monster monster : this.monsters)
        {
            Position position = monster.move();
            if(canElementMove(position))
            {
                monster.setPosition(position);
            }
        }
    }

    public int processKey(KeyStroke key) throws IOException
    {
        switch(key.getKeyType())
        {
            case Character: if(key.getCharacter() == 'q')
                return 1;
            case ArrowUp: moveHero(hero.moveUp());
                moveMonsters();
                if(verifyMonsterCollision() == true)
                    return 2;
                break;
            case ArrowDown: moveHero(hero.moveDown());
                moveMonsters();
                if(verifyMonsterCollision() == true)
                    return 2;
                break;
            case ArrowRight: moveHero(hero.moveRight());
                moveMonsters();
                if(verifyMonsterCollision() == true)
                    return 2;
                break;
            case ArrowLeft: moveHero(hero.moveLeft());
                moveMonsters();
                if(verifyMonsterCollision() == true)
                    return 2;
                break;
            default:
                break;
        }
        System.out.println(key);
        return 0;
    }



    public void draw(TextGraphics graphics)
    {
        graphics.setBackgroundColor(TextColor.Factory.fromString("#000000"));
        graphics.fillRectangle(new TerminalPosition(0, 0), new TerminalSize(width, height), ' ');



        for(Wall wall : this.walls)
            wall.draw(graphics);
        for(Coin coin : this.coins)
            coin.draw(graphics);
        this.hero.draw(graphics);
        for(Monster monster : this.monsters)
            monster.draw(graphics);
    }


}