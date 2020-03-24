import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.TerminalPosition;



import java.io.IOException;
import java.util.Date;



public class Game {
    //Class Fields:
    private Screen screen;
    private Arena arena;

    //Methods:
    public Game() throws IOException //Constructor
    {
        Terminal terminal = new DefaultTerminalFactory().createTerminal();
        this.screen = new TerminalScreen(terminal);
        this.arena = new Arena(80, 24);
        TextGraphics graphics = screen.newTextGraphics();



        screen.setCursorPosition(null);
        screen.startScreen();
        screen.doResizeIfNecessary();
    }


    private void draw() throws IOException
    {
        screen.clear();
        this.arena.draw(this.screen.newTextGraphics());
        screen.refresh();
    }

    private int processKey(KeyStroke key) throws IOException
    {
        return this.arena.processKey(key);
    }

    /*public void GameOver(TextGraphics graphics) throws IOException
    {
        graphics.setForegroundColor(TextColor.Factory.fromString("#FF0000"));
        graphics.putString(new TerminalPosition(81, 12), "GAME ");
        graphics.putString(new TerminalPosition(81, 13), "OVER!    ");
        screen.refresh();
        Date startDate = new Date();
        Date endDate = new Date();
        int numSeconds = 0;
        while (numSeconds < 10) {
            endDate = new Date();
            numSeconds = (int)((endDate.getTime() - startDate.getTime()) / 1000);
        }
        screen.close();
    }*/


    public void run() throws IOException //Runs game
    {
        while(true)
        {
            this.draw();
            KeyStroke key = screen.readInput();
            int i = this.processKey(key);
            switch(i)
            {
                case 1:
                    this.screen.close();
                    break;
                case 2:
                    //gameOver();
                    this.screen.close();
                    break;
            }

            if(key.getKeyType() == KeyType.EOF)
            {
                break;
            }
        }

    }

}