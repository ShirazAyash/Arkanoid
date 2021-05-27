package interfaces;

import geometric.Velocity;
import sprites.Block;

import java.util.List;

/**
 * The interface Level information.
 */
public interface LevelInformation {
    /**
     * Number of balls int.
     *
     * @return the int
     */
    int numberOfBalls();

    /**
     * The initial velocity of each ball.
     *
     * @return the list
     */
    List<Velocity> initialBallVelocities();

    /**
     * Paddle speed int.
     *
     * @return the int
     */
    int paddleSpeed();

    /**
     * Paddle width int.
     *
     * @return the int
     */
    int paddleWidth();

    /**
     * The level name will be displayed at the top of the screen.
     *
     * @return the string
     */
    String levelName();

    /**
     * Returns a sprite with the background of the level.
     *
     * @return the background
     */
    Sprite getBackground();

    /**
     * Returns the Blocks that make up this level,
     * each block contains its size, color and location.
     * @return the list
     */
    List<Block> blocks();

    /**
     * Number of blocks that should be removed
     * before the level is considered to be "cleared".
     *
     * @return the int
     */
    int numberOfBlocksToRemove();
}
