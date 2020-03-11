import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.graphics.TextGraphics;


import java.io.IOException;



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


    public void run() throws IOException //Runs game
    {
        while(true)
        {
            this.draw();
            KeyStroke key = screen.readInput();
            if(this.processKey(key) == 1)
            {
                this.screen.close();
            }
            if(key.getKeyType() == KeyType.EOF)
            {
                break;
            }
        }

    }

}