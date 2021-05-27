package screens;

import geometric.Point;
import geometric.Rectangle;
import geometric.Velocity;
import interfaces.LevelInformation;
import interfaces.Sprite;
import sprites.Block;
import backgrounds.Backgruond4;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * The type Level 4.
 */
public class Level4 implements LevelInformation {
    @Override
    public int numberOfBalls() {
        return 3;
    }

    @Override
    public List<Velocity> initialBallVelocities() {
        List<Velocity> list = new ArrayList<>();
        int angle = 340;
        for (int i = 0; i < this.numberOfBalls(); i++) {
            Velocity vel = Velocity.fromAngleAndSpeed(angle, 5);
            list.add(vel);
            angle = angle + 5;
        }
        return list;
    }

    @Override
    public int paddleSpeed() {
        return 7;
    }

    @Override
    public int paddleWidth() {
        return 100;
    }

    @Override
    public String levelName() {
        return "Final Four";
    }

    @Override
    public Sprite getBackground() {
        return new Backgruond4();
    }

    @Override
    public List<Block> blocks() {
        List<Block> list = new ArrayList<>();
        Color[] colorArr = {Color.gray, Color.red, Color.yellow, Color.green, Color.white, Color.pink, Color.cyan};
        double firstX = 21, firstY = 150;
        int colorIndex = 0;
        Point upperLeft;
        Block block;
        for (int j = 0; j < colorArr.length; j++) {
            for (int i = 0; i < 15; i++) {
                upperLeft = new Point(firstX, firstY + j * 20);
                block = new Block(new Rectangle(upperLeft, 51, 20), colorArr[colorIndex]);
                list.add(block);
                firstX = firstX + (760.00 / 15.00);
            }
            colorIndex++;
            firstX = 21;
        }
        return list;
    }

    @Override
    public int numberOfBlocksToRemove() {
        return this.blocks().size();
    }
}
