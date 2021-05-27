// ID: 314987926
package thegame;

import geometric.Point;
import interfaces.Collidable;

/**
 * The type Collision info is contain the collisiom point ans the collision object.
 */
public class CollisionInfo {
    private Point collisionPoint;
    private Collidable collisionObject;

    /**
     * Instantiates a new Collision info.
     *
     * @param collisionPoint  the collision point
     * @param collisionObject the collision object
     */
    public CollisionInfo(Point collisionPoint, Collidable collisionObject) {
        this.collisionObject = collisionObject;
        this.collisionPoint = collisionPoint;
    }

    /**
     * returns the point at which the collision occurs.
     *
     * @return the point
     */
    public Point collisionPoint() {
        return collisionPoint;
    }

    /**
     * returns the collidable object involved in the collision.
     *
     * @return the collidable
     */
    public Collidable collisionObject() {
        return collisionObject;
    }
}
