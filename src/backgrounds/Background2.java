package backgrounds;

import biuoop.DrawSurface;
import interfaces.Sprite;

import java.awt.Color;

/**
 * The type Background 2.
 */
public class Background2 implements Sprite {
    @Override
    public void drawOn(DrawSurface d) {
        d.setColor(Color.white);
        d.fillRectangle(0, 0, 800, 600);
        d.setColor(Color.yellow);
        for (int i = 0; i < 75; i++) {
            d.drawLine(130, 130, -10 + i * 10, 255);

        }
        d.setColor(Color.ORANGE);
        d.fillCircle(130, 130, 45);
        d.setColor(Color.yellow);
        d.fillCircle(130, 130, 35);

    }

    @Override
    public void timePassed() {

    }
}
