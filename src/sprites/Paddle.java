// ID: 314987926
package sprites;

import biuoop.DrawSurface;
import biuoop.KeyboardSensor;
import geometric.Point;
import geometric.Rectangle;
import geometric.Velocity;
import interfaces.Collidable;
import interfaces.Sprite;
import thegame.GameLevel;

import java.awt.Color;

/**
 * The sprites.Paddle is the "player" -- a block controlled by the keyboard.
 */
public class Paddle implements Sprite, Collidable {
    private int speed;
    private biuoop.KeyboardSensor keyboard;
    private Rectangle rect;
    private Color color;
    private int startEdge;
    private int endEdge;

    /**
     * Instantiates a new sprites.Paddle.
     *
     * @param rect     the rect
     * @param color    the color
     * @param keyboard the keyboard
     * @param start    the start
     * @param end      the end
     * @param speed the speed
     */
    public Paddle(Rectangle rect, Color color, KeyboardSensor keyboard, int start, int end, int speed) {
        this.rect = rect;
        this.color = color;
        this.keyboard = keyboard;
        this.startEdge = start;
        this.endEdge = end;
        this.speed = speed;
    }

    /**
     * Move the paddle left in the screen area.
     */
    public void moveLeft() {
        double x = this.rect.getUpperLeft().getX();
        double y = this.rect.getUpperLeft().getY();
        //check is the paddle is out of the screen
        if (x - this.speed >= this.startEdge) {
            this.rect.setUpperLeft(x - this.speed, y);
        }
    }

    /**
     * Move the paddle right in the screen area.
     */
    public void moveRight() {
        double x = this.rect.getUpperLeft().getX();
        double y = this.rect.getUpperLeft().getY();
        //check is the paddle is out of the screen
        if (x + this.speed + this.rect.getWidth() <= this.endEdge) {
            this.rect.setUpperLeft(x + this.speed, y);
        }
    }

    @Override
    public void timePassed() {
        // check on which key the player hold and move according it
        if (keyboard.isPressed(KeyboardSensor.LEFT_KEY)) {
            this.moveLeft();
        }
        if (keyboard.isPressed(KeyboardSensor.RIGHT_KEY)) {
            this.moveRight();
        }
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
    public Rectangle getCollisionRectangle() {
        return this.rect;
    }

    @Override
    public Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity) {
        double recLeftX = this.rect.getUpperLeft().getX();
        double recLeftY = this.rect.getUpperLeft().getY();
        double width = this.rect.getWidth();
        //save the current values of the velocity
        double dx = currentVelocity.getDx(), dy = currentVelocity.getDy();
        double ballSpeed = Math.sqrt(dx * dx + dy * dy);
        Velocity newVel = currentVelocity;
        //if there is a collision
        if (collisionPoint != null) {

            //if the collision is on the up line in the paddle then change the angle of the velocity
            // according the place of the collision on the paddle
            if ((collisionPoint.getY() >= recLeftY - 0.01 && collisionPoint.getY() <= recLeftY + 0.01)) {

                if (collisionPoint.getX() >= recLeftX - 1 && collisionPoint.getX() <= recLeftX + width / 5) {
                    newVel = Velocity.fromAngleAndSpeed(300, ballSpeed);
                }
                if (collisionPoint.getX() > recLeftX + width / 5 && collisionPoint.getX() <= recLeftX + width / 5 * 2) {
                    newVel = Velocity.fromAngleAndSpeed(330, ballSpeed);
                }
                if (collisionPoint.getX() > recLeftX + width / 5 * 2
                        && collisionPoint.getX() <= recLeftX + width / 5 * 3) {
                    newVel.setDy(currentVelocity.getDy() * -1);
                }
                if (collisionPoint.getX() > recLeftX + width / 5 * 3
                        && collisionPoint.getX() <= recLeftX + width / 5 * 4) {
                    newVel = Velocity.fromAngleAndSpeed(30, ballSpeed);
                }
                if (collisionPoint.getX() > recLeftX + width / 5 * 4
                        && collisionPoint.getX() <= recLeftX + width + 1) {
                    newVel = Velocity.fromAngleAndSpeed(60, ballSpeed);
                }
            }
            //if the collision is on the left or right sides of the block than change the dx
            if ((collisionPoint.getX() >= recLeftX - 0.01 && collisionPoint.getX() <= recLeftX + 0.01)
                    || collisionPoint.getX() >= recLeftX + this.rect.getWidth() - 0.01
                    && collisionPoint.getX() <= recLeftX + this.rect.getWidth() + 0.01) {
                newVel.setDx(dx * -1);
            }
        }
        return newVel;
    }

    /**
     * Add this paddle to the game.
     *
     * @param g the game
     */
    public void addToGame(GameLevel g) {
        g.addSprite(this);
        g.addCollidable(this);
    }
}