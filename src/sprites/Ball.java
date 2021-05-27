// ID: 314987926
package sprites;

import biuoop.DrawSurface;
import thegame.CollisionInfo;
import thegame.GameLevel;
import thegame.GameEnvironment;
import geometric.Line;
import geometric.Point;
import geometric.Velocity;
import interfaces.Sprite;

import java.awt.Color;

/**
 * The type sprites.Ball.
 */
public class Ball implements Sprite {
    // Fields
    private double size;
    private Point center;
    private java.awt.Color color;
    private Velocity velocity;
    private GameEnvironment game;

    /**
     * Instantiates a new sprites.Ball.
     *
     * @param center the center point of the ball
     * @param r      the size of the radius
     * @param color  the color of the ball
     * @param game   the game
     */
// constructor
    public Ball(Point center, int r, java.awt.Color color, GameEnvironment game) {
        this.center = center;
        this.size = r;
        this.color = color;
        this.game = game;
    }

    /**
     * Gets center.
     *
     * @return the center
     */
// accessors
    public Point getCenter() {
        return this.center;
    }

    /**
     * Gets x.
     *
     * @return the x
     */
    public int getX() {
        return (int) this.center.getX();
    }

    /**
     * Gets y.
     *
     * @return the y
     */
    public int getY() {
        return (int) this.center.getY();
    }

    /**
     * Gets size.
     *
     * @return the size
     */
    public int getSize() {
        return (int) this.size;
    }

    /**
     * Gets color.
     *
     * @return the color
     */
    public java.awt.Color getColor() {
        return this.color;
    }

    /**
     * Draw the ball on the given DrawSurface.
     *
     * @param surface the surface
     */
    @Override
    public void drawOn(DrawSurface surface) {
        surface.setColor(Color.black);
        surface.drawCircle(this.getX(), this.getY(), this.getSize());
        surface.setColor(this.color);
        surface.fillCircle(this.getX(), this.getY(), this.getSize());
    }

    @Override
    public void timePassed() {
        moveOneStep();
    }

    /**
     * Sets velocity.
     *
     * @param v the velocity
     */
    public void setVelocity(Velocity v) {
        this.velocity = v;
    }

    /**
     * Sets velocity according to the dx and dy.
     *
     * @param dx the dx
     * @param dy the dy
     */
    public void setVelocity(double dx, double dy) {
        Velocity v = new Velocity(dx, dy);
        this.velocity = v;

    }

    /**
     * Gets velocity.
     *
     * @return the velocity
     */
    public Velocity getVelocity() {
        return this.velocity;
    }

    /**
     * Move the ball one step according to its velocity.
     */
    public void moveOneStep() {
        // the line is the path of the ball in this step
        Line line = new Line(this.center, this.getVelocity().applyToPoint(this.center));
        //find the collision with the line
        CollisionInfo hitInfo = this.game.getClosestCollision(line);
        //if there is collision
        if (hitInfo != null) {
            //we want the ball to get almost to the collision point
            //so we make a new line from the ball to the collision point
            Line line1 = new Line(this.center, hitInfo.collisionPoint());
            //the center of the point will be at the middle of the line
            //and now the ball get closer to the collision point
            this.center = line1.middle();
            //set the velocity of the ball
            this.setVelocity(hitInfo.collisionObject().hit(this, hitInfo.collisionPoint(), this.velocity));
            //if there is no collision the ball make a regular step
        } else {
            this.center = this.getVelocity().applyToPoint(this.center);
        }
    }

    /**
     * Add to the ball to the sprite list in the game class.
     *
     * @param g the game
     */
    public void addToGame(GameLevel g) {
        g.addSprite(this);
    }

    /**
     * Remove from game.
     *
     * @param g the game
     */
    public void removeFromGame(GameLevel g) {
        g.removeSprite(this);
    }
}