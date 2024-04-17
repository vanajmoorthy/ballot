package cs4303.p4.states;

import java.util.ArrayList;
import java.util.List;

import cs4303.p4.Player;
import cs4303.p4._util.Colors;
import cs4303.p4._util.Constants;
import cs4303.p4._util.gui.GestureDetector;
import cs4303.p4.items.Item;
import processing.core.PApplet;
import processing.core.PVector;

public final class GameStateBase extends GameState {
    private Player player;
    private List<GestureDetector> buttons;

    public GameStateBase(Player player) {
        this.player = player;
        this.buttons = new ArrayList<GestureDetector>();
        for (int i = 0; i < player.getInventory().size(); i++) {
            Item item = player.getInventory().get(i);
            final int offset = i * 60;

            buttons.add(new GestureDetector(
                (sketch, hitbox, hasHover, hasClick) -> {
                    sketch.fill(
                        hasHover
                            ? Colors.platinum.dark
                            : Colors.night.lighter
                    );
                    sketch.noStroke();
                    sketch.rect(10 + offset, 10, 50, 50, 10);

                    sketch.noFill();
                    sketch.stroke(item.getType().getRarity().getColor());
                    sketch.strokeWeight(2);
                    sketch.rect(10 + offset + 5, 10 + 5, 40, 40, 5);
                },
                (sketch) -> {
                    PApplet.println(item.getType().getDisplayName());
                },
                new GestureDetector.Hitbox(
                    new PVector(10 + offset, 10),
                    new PVector(50, 50)
                )
            ));
        }
    }

    public void draw(PApplet sketch) {
        sketch.fill(Colors.night.darker);
        sketch.noStroke();
        sketch.rect(0, 0, Constants.Screen.Base.inventoryWidth, Constants.Screen.Base.inventoryHeight);

        for (GestureDetector button : buttons) {
            button.draw(sketch);
        }
    }

    public void keyPressed(PApplet sketch) {

    }

    public void keyReleased(PApplet sketch) {

    }

    public void mousePressed(PApplet sketch) {

    }

    public void mouseReleased(PApplet sketch) {
        for (GestureDetector button : buttons) {
            if (button.isFocused(sketch)) button.click(sketch);
        }
    }
}
