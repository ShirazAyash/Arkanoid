// ID: 314987926
package thegame;

import geometric.Line;
import geometric.Point;
import geometric.Rectangle;
import interfaces.Collidable;

import java.util.List;
import java.util.ArrayList;

/**
 * The type game.Game environment is contain a list of all the collidacles.
 */
public class GameEnvironment {
    private List<Collidable> collidables;

    /**
     * Instantiates a new game.Game environment.
     */
    public GameEnvironment() {
        this.collidables = new ArrayList<Collidable>();
    }

    /**
     * add the given collidable to the environment.
     *
     * @param c the c
     */
    public void addCollidable(Collidable c) {
        this.collidables.add(c);
    }

    /**
     * remobe the given collidable from the environment.
     *
     * @param c the c
     */
    public void removeCollidable(Collidable c) {
        this.collidables.remove(c);
    }

    /**
     * Assume an object moving from line.start() to line.end().
     * If this object will not collide with any of the collidables
     * in this collection, return null. Else, return the information
     * about the closest collision that is going to occur.
     *
     * @param trajectory the trajectory
     * @return the closest collision
     */
    public CollisionInfo getClosestCollision(Line trajectory) {
        Rectangle rect;
        //the default is the info to be a null if there is no collision
        CollisionInfo info = null;
        Point hitPoint;
        double minDistance = -1, currentDis;
        // over oll the collidables list and find the one which closest to the start of the line
        for (Collidable c : collidables) {
            rect = c.getCollisionRectangle();
            hitPoint = trajectory.closestIntersectionToStartOfLine(rect);
            if (hitPoint != null) {
                //the distance between the start and the collosion
                currentDis = hitPoint.distance(trajectory.start());
                // if its smaller then the minimum than make it to be the minimum
                if (currentDis < minDistance || minDistance == -1) {
                    minDistance = currentDis;
                    info = new CollisionInfo(hitPoint, c);
                }
            }
        }
        return info;
    }

    /**
     * Gets collidables.
     *
     * @return the collidables
     */
    public List<Collidable> getCollidables() {
        return collidables;
    }
}
