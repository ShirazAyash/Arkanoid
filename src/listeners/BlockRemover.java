package listeners;

import thegame.Counter;
import thegame.GameLevel;
import sprites.Ball;
import sprites.Block;
import interfaces.HitListener;

/**
 * The type Block remover.
 */
public class BlockRemover implements HitListener {
    private GameLevel game;
    private Counter remainingBlocks;

    /**
     * Instantiates a new Block remover.
     *
     * @param game          the game
     * @param removedBlocks the removed blocks
     */
    public BlockRemover(GameLevel game, Counter removedBlocks) {
        this.game = game;
        this.remainingBlocks = removedBlocks;
    }

    // Blocks that are hit should be removed
    // from the game. Remember to remove this listener from the block
    // that is being removed from the game.
    @Override
    public void hitEvent(Block beingHit, Ball hitter) {

        beingHit.removeHitListener(this);
        beingHit.removeFromGame(this.game);
        this.remainingBlocks.decrease(1);
    }
}