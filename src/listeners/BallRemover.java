package listeners;

import thegame.Counter;
import thegame.GameLevel;
import sprites.Ball;
import sprites.Block;
import interfaces.HitListener;

/**
 * The type Ball remover.
 */
public class BallRemover implements HitListener {
    private GameLevel game;
    private Counter remainingBalls;

    /**
     * Instantiates a new Ball remover.
     *
     * @param game       the game
     * @param removeBall the remove ball
     */
    public BallRemover(GameLevel game, Counter removeBall) {
        this.game = game;
        this.remainingBalls = removeBall;
    }

    @Override
    public void hitEvent(Block beingHit, Ball hitter) {
        hitter.removeFromGame(this.game);
        this.remainingBalls.decrease(1);
    }
}
