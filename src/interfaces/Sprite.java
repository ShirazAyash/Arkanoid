// ID: 314987926
package interfaces;

import biuoop.DrawSurface;

/**
 * The interface interfaces.Sprite.
 */
public interface Sprite {
    /**
     * draw the sprite to the screen.
     *
     * @param d the d
     */
    void drawOn(DrawSurface d);

    /**
     * notify the sprite that time has passed.
     */
    void timePassed();
}