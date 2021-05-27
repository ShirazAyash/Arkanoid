// ID: 314987926
package thegame;
import biuoop.DrawSurface;
import interfaces.Sprite;
import java.util.ArrayList;
import java.util.List;

/**
 * The type interfaces.Sprite collection.
 */
public class SpriteCollection {
    private List<Sprite> sprites;

    /**
     * Instantiates a new interfaces.Sprite collection.
     */
    public SpriteCollection() {
        this.sprites = new ArrayList<Sprite>();
    }

    /**
     * Add sprite to the list of sprites.
     *
     * @param s the sprite
     */
    public void addSprite(Sprite s) {
        this.sprites.add(s);
    }

    /**
     * Remove sprite from the list of sprites.
     *
     * @param s the sprite
     */
    public void removeSprite(Sprite s) {
        this.sprites.remove(s);
    }

    /**
     * call timePassed() on all sprites.
     */
    public void notifyAllTimePassed() {
        List<Sprite> spriteCopy = new ArrayList<Sprite>(this.sprites);
        for (Sprite s : spriteCopy) {
            s.timePassed();
        }
    }

    /**
     * call drawOn(d) on all sprites.
     *
     * @param d the surface
     */
    public void drawAllOn(DrawSurface d) {
        for (Sprite s : sprites) {
            s.drawOn(d);
        }
    }
}