package screens;

import geometric.Point;
import geometric.Rectangle;
import geometric.Velocity;
import interfaces.LevelInformation;
import interfaces.Sprite;
import sprites.Block;
import backgrounds.Background2;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * The type Level 2.
 */
public class Level2 implements LevelInformation {
    @Override
    public int numberOfBalls() {
        return 10;
    }

    @Override
    public List<Velocity> initialBallVelocities() {
        List<Velocity> list = new ArrayList<>();
        int angle = 270;
        for (int i = 0; i < this.numberOfBalls(); i++) {
            Velocity vel = Velocity.fromAngleAndSpeed(angle, 7);
            list.add(vel);
            angle += 22;
        }
        return list;
    }

    @Override
    public int paddleSpeed() {
        return 5;
    }

    @Override
    public int paddleWidth() {
        return 600;
    }

    @Override
    public String levelName() {
        return "Wide Easy";
    }

    @Override
    public Sprite getBackground() {
        return new Background2();
    }

    @Override
    public List<Block> blocks() {
        List<Block> list = new ArrayList<>();
        Color[] colorArr = {Color.red, Color.red, Color.orange, Color.orange, Color.yellow, Color.yellow, Color.green,
                Color.green, Color.green, Color.blue, Color.blue, Color.pink, Color.pink, Color.cyan, Color.cyan};
        double firstX = 21, firstY = 250;
        int colorIndex = 0;
        Point upperLeft;
        Block block;
        for (int i = 0; i < 15; i++) {
            upperLeft = new Point(firstX, firstY);
            block = new Block(new Rectangle(upperLeft, 51, 20), colorArr[colorIndex]);
            colorIndex++;
            list.add(block);
            firstX = firstX + (760.00 / 15.00);
        }
        return list;
    }

    @Override
    public int numberOfBlocksToRemove() {
        return this.blocks().size();
    }
}
