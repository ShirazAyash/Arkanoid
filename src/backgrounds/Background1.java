package backgrounds;

import biuoop.DrawSurface;
import interfaces.Sprite;

import java.awt.Color;

/**
 * The type Background 1.
 */
public class Background1 implements Sprite {
    @Override
    public void drawOn(DrawSurface d) {
        d.setColor(Color.black);
        d.fillRectangle(0, 0, 800, 600);
        d.setColor(Color.blue);
        for (int i = 0; i < 3; i++) {
            d.drawCircle(400, 210, 50 + i * 40);
        }
        d.drawLine(250, 210, 550, 210);
        d.drawLine(400, 60, 400, 360);
    }

    @Override
    public void timePassed() {

    }
}
