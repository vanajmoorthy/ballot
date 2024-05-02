package cs4303.p4;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import cs4303.p4._util.Constants;
import cs4303.p4.items.Item;
import cs4303.p4.items.ItemType;
import cs4303.p4.states.GameState;
import cs4303.p4.states.GameStateBase;
import cs4303.p4.states.GameStateGameplay;
import processing.core.PApplet;

@SpringBootApplication
public class Game extends PApplet {
    private GameState state;

    public static void main(String[] args) {
        String[] appletArgs = new String[] { "Game" };
        Game sketch = new Game();
        PApplet.runSketch(appletArgs, sketch);
    }

    @Override
    public void settings() {
        size(
                Math.max(Constants.Screen.width, Constants.Screen.minWidth),
                Math.max(Constants.Screen.height, Constants.Screen.minHeight));
    }

    @Override
    public void setup() {
        // state = new GameStateGameplay(this);
        Player player = new Player(0, 0);
        player.addItem(new Item(ItemType.Chestplate));
        player.addItem(new Item(ItemType.Constinution));
        state = new GameStateBase(player);
        // state = new GameStateGameplay(this);
    }

    @Override
    public void keyPressed() {
        state.keyPressed(this);
    }

    @Override
    public void keyReleased() {
        state.keyReleased(this);
    }

    @Override
    public void mousePressed() {
        state.mousePressed(this);
    }

    @Override
    public void mouseReleased() {
        state.mouseReleased(this);
    }

    @Override
    public void draw() {
        state.draw(this);
    }
}
