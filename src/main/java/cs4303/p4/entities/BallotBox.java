package cs4303.p4.entities;

import java.util.ArrayList;

import cs4303.p4._util.Colors;
import cs4303.p4._util.Constants;
import cs4303.p4.items.Item;
import cs4303.p4.physics.BoundingBox;
import processing.core.PApplet;
import processing.core.PImage;
import processing.core.PVector;

public class BallotBox extends Entity {
    private PImage image;

    public BallotBox(float x, float y, PImage image) {
        super(x, y);
        ArrayList<BoundingBox> bounds = new ArrayList<BoundingBox>();
        bounds.add(new BoundingBox(super.getLocation(), 35, 35));
        super.setBounds(bounds);
        super.setAcceleration(new PVector(0, 0));
        super.setVelocity(new PVector(0, 0));
        super.setInventory(new ArrayList<Item>());
        super.setMaxSlots(3);
        super.setMass(Constants.PLAYER.INSTANCE.MASS);
        this.image = image; // Set the image for the ballot box
    }

    @Override
    public void draw(PApplet sketch) {
        try {
            sketch.image(image, super.getLocation().x, super.getLocation().y, 35, 35); // Draw the image at the ballot
                                                                                       // box

        } catch (Exception e) {
            sketch.fill(Colors.gray.light);
            sketch.stroke(Colors.gray.primary);
            sketch.strokeWeight(2);
            sketch.rect(super.getLocation().x, super.getLocation().y, 35, 35);
        }
        // position
    }
}
