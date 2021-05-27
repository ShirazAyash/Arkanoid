package screens;

import geometric.Point;
import geometric.Rectangle;
import geometric.Velocity;
import interfaces.LevelInformation;
import interfaces.Sprite;
import sprites.Block;
import backgrounds.Background1;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * The type Level 1.
 */
public class Level1 implements LevelInformation {
    @Override
    public int numberOfBalls() {
        return 1;
    }

    @Override
    public List<Velocity> initialBallVelocities() {
        List<Velocity> list = new ArrayList<>();
        list.add(Velocity.fromAngleAndSpeed(0, 5));
        return list;
    }

    @Override
    public int paddleSpeed() {
        return 3;
    }

    @Override
    public int paddleWidth() {
        return 50;
    }

    @Override
    public String levelName() {
        return "Direct Hit";
    }

    @Override
    public Sprite getBackground() {
        return new Background1();
    }

    @Override
    public List<Block> blocks() {
        List<Block> list = new ArrayList<>();
        Point upperLeft = new Point(390, 200);
        Block block = new Block(new Rectangle(upperLeft, 20, 20), Color.red);
        list.add(block);
        return list;
    }

    @Override
    public int numberOfBlocksToRemove() {
        return this.blocks().size();
    }
}
