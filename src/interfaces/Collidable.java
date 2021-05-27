// ID: 314987926
package interfaces;

import geometric.Point;
import geometric.Rectangle;
import geometric.Velocity;
import sprites.Ball;

/**
 * The interface interfaces.Collidable is all the objects that collidable with the ball.
 */
public interface Collidable {
    /**
     * Gets collision rectangle.
     *
     * @return the "collision shape" of the object.
     */
    Rectangle getCollisionRectangle();

    /**
     *Notify the object that we collided with it at collisionPoint with
     *a given velocity.
     *The return is the new velocity expected after the hit (based on
     *the force the object inflicted on us).
     *
     * @param hitter the ball that hit the block
     * @param collisionPoint  the collision point
     * @param currentVelocity the current velocity
     * @return the velocity
     */
    Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity);
}