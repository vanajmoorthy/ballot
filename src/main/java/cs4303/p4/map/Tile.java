package cs4303.p4.map;

import processing.core.PApplet;

public class Tile {
    private int cellSize;
    private TileType type; // Type of the tile (0: empty, 1: platform, 2: enemy/treasure)

    // Constructor
    public Tile(int cellSize) {
        this.cellSize = cellSize;
        this.type = TileType.EMPTY; // Default to empty
    }

    // Setter for the tile type
    public void setType(TileType type) {
        this.type = type;
    }

    public TileType getType() {
        return type;
    }

    // Draw method for the tile
    public void draw(PApplet sketch, int x, int y, float lerp) {
        // Draw based on type
        switch (type) {
            case EMPTY:
                sketch.fill(255, 0, 0);
                sketch.rect(x * cellSize + lerp * cellSize, y * cellSize, cellSize, cellSize);
                break;
            case PLATFORM:
                // Draw platform
                sketch.fill(255);
                sketch.rect(x * cellSize + lerp * cellSize, y * cellSize, cellSize, cellSize);
                break;
            case ENTITY:
                // Draw enemy or treasure
                sketch.ellipse(x * cellSize + cellSize / 2 + lerp * cellSize, y * cellSize + cellSize / 2, cellSize / 2,
                        cellSize / 2);
                break;
            default:
                break;
        }
    }
}