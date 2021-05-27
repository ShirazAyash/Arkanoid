// ID: 314987926
package sprites;

import biuoop.DrawSurface;
import thegame.Counter;
import thegame.GameLevel;
import geometric.Rectangle;
import interfaces.Sprite;

import java.awt.Color;

/**
 * The type Score indicator.
 */
public class ScoreIndicator implements Sprite {
    private Rectangle rect;
    private Counter score;

    /**
     * Instantiates a new Score indicator.
     *
     * @param rect     the rect
     * @param theScore the the score
     */
    public ScoreIndicator(Rectangle rect, Counter theScore) {
        this.rect = rect;
        this.score = theScore;
    }

    @Override
    public void drawOn(DrawSurface d) {
        d.setColor(Color.white);
        int theX = (int) this.rect.getUpperLeft().getX();
        int theY = (int) this.rect.getUpperLeft().getY();
        d.fillRectangle(theX, theY, (int) this.rect.getWidth(), (int) this.rect.getHeight());
        d.setColor(Color.black);
        d.drawText(375, 15, String.valueOf("Score: " + this.score.getValue()), 15);
    }

    @Override
    public void timePassed() {

    }

    /**
     * Add to game.
     *
     * @param g the g
     */
    public void addToGame(GameLevel g) {
        g.addSprite(this);
    }
}
