// ID: 314987926
package interfaces;

import sprites.Ball;
import sprites.Block;

/**
 * The interface Hit listener.
 */
public interface HitListener {
    /**
     * This method is called whenever the beingHit object is hit.
     *
     * @param beingHit the being hit
     * @param hitter   the sprites Ball that's doing the hitting.
     */
    void hitEvent(Block beingHit, Ball hitter);
}
