package listeners;

import sprites.Ball;
import sprites.Block;
import interfaces.HitListener;

/**
 * The type Printing hit listener.
 */
public class PrintingHitListener  implements HitListener {
    @Override
    public void hitEvent(Block beingHit, Ball hitter) {
        System.out.println("A sprites.Block was hit.");
    }
}
