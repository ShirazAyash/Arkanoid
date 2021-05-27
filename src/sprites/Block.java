// ID: 314987926
package sprites;

import biuoop.DrawSurface;
import geometric.Point;
import geometric.Rectangle;
import geometric.Velocity;
import interfaces.Collidable;
import interfaces.HitListener;
import interfaces.HitNotifier;
import interfaces.Sprite;
import thegame.GameLevel;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * The type sprites.Block is a rectangle with a color.
 */
public class Block implements Collidable, Sprite, HitNotifier {
    //Fields
    private Rectangle rect;
    private Color color;
    private List<HitListener> hitListeners;

    /**
     * Instantiates a new sprites.Block.
     *
     * @param rect  the rect
     * @param color the color
     */
    public Block(Rectangle rect, Color color) {
        this.rect = rect;
        this.color = color;
        this.hitListeners = new ArrayList<HitListener>();
    }

    // Return the "collision shape" of the object.
    @Override
    public Rectangle getCollisionRectangle() {
        return this.rect;
    }
    @Override
    public void addHitListener(HitListener hl) {
        this.hitListeners.add(hl);
    }

    @Override
    public void removeHitListener(HitListener hl) {
        this.hitListeners.remove(hl);
    }

    /**
     * play the listeners in the list.
     *
     * @param hitter the ball that hit the block
     */
    private void notifyHit(Ball hitter) {
        // Make a copy of the hitListeners before iterating over them.
        List<HitListener> listeners = new ArrayList<HitListener>(this.hitListeners);
        // Notify all listeners about a hit event:
        for (HitListener hl : listeners) {
            hl.hitEvent(this, hitter);
        }
    }

    // Notify the object that we collided with it at collisionPoint with
    // a given velocity.
    // The return is the new velocity expected after the hit (based on
    // the force the object inflicted on us).
    @Override
    public Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity) {
        double recLeftX = this.rect.getUpperLeft().getX();
        double recLeftY = this.rect.getUpperLeft().getY();
        double dx = currentVelocity.getDx(), dy = currentVelocity.getDy();
        // if there is a collision point between the block and the ball
        if (collisionPoint != null) {

            //if the collision is on the left or right sides of the block than change the dx
            if ((collisionPoint.getX() >= recLeftX - 0.01 && collisionPoint.getX() <= recLeftX + 0.01)
                    || collisionPoint.getX() >= recLeftX + this.rect.getWidth() - 0.01
                    && collisionPoint.getX() <= recLeftX + this.rect.getWidth() + 0.01) {
                currentVelocity.setDx(dx * -1);
            }
            //if the collision is on the up or down sides of the block than change the dy
            if ((collisionPoint.getY() >= recLeftY - 0.01 && collisionPoint.getY() <= recLeftY + 0.01)
                    || collisionPoint.getY() >= recLeftY + this.rect.getHeight() - 0.01
                    && collisionPoint.getY() <= recLeftY + this.rect.getHeight() + 0.01) {
                currentVelocity.setDy(dy * -1);
            }
        }

        this.notifyHit(hitter);
        return currentVelocity;
    }

    @Override
    public void drawOn(DrawSurface d) {
        d.setColor(this.color);
        int theX = (int) this.rect.getUpperLeft().getX();
        int theY = (int) this.rect.getUpperLeft().getY();
        d.setColor(color);
        d.fillRectangle(theX, theY, (int) this.rect.getWidth(), (int) this.rect.getHeight());
        d.setColor(Color.black);
        d.drawRectangle(theX, theY, (int) this.rect.getWidth(), (int) this.rect.getHeight());
    }

    @Override
    public void timePassed() {
    }

    /**
     * Add to the list of sprites and to the list of collidable in the game.
     *
     * @param g the game
     */
    public void addToGame(GameLevel g) {

        g.addCollidable(this);
        g.addSprite(this);
    }


    /**
     * Remove from game.
     *
     * @param game the game
     */
    public void removeFromGame(GameLevel game) {
        game.removeCollidable(this);
        game.removeSprite(this);
    }

}
