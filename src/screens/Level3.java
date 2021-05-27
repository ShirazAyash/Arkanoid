package screens;

import geometric.Point;
import geometric.Rectangle;
import geometric.Velocity;
import interfaces.LevelInformation;
import interfaces.Sprite;
import sprites.Block;
import backgrounds.Background3;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * The type Level 3.
 */
public class Level3 implements LevelInformation {
    @Override
    public int numberOfBalls() {
        return 2;
    }

    @Override
    public List<Velocity> initialBallVelocities() {
        List<Velocity> list = new ArrayList<>();
        for (int i = 0; i < this.numberOfBalls(); i++) {
            Velocity vel = Velocity.fromAngleAndSpeed(-20 + i * 40, 6);
            list.add(vel);
        }
        return list;
    }

    @Override
    public int paddleSpeed() {
        return 5;
    }

    @Override
    public int paddleWidth() {
        return 120;
    }

    @Override
    public String levelName() {
        return "Green 3";
    }

    @Override
    public Sprite getBackground() {
        return new Background3();
    }

    @Override
    public List<Block> blocks() {
        List<Block> list = new ArrayList<>();
        int row = 5;
        int col = 10;
        int firstX = 380, firstY = 200;
        Color[] colorArr = {Color.gray, Color.red, Color.yellow, Color.blue, Color.white};
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                Point upperLeft = new Point(firstX + ((j) * 40), firstY + i * 20);
                Block block = new Block(new Rectangle(upperLeft, 40, 20), colorArr[i]);
                list.add(block);
            }
            col--;
            firstX += 40;
        }
        return list;
    }

    @Override
    public int numberOfBlocksToRemove() {
        return this.blocks().size();
    }
}
