package backgrounds;

import biuoop.DrawSurface;
import interfaces.Sprite;

import java.awt.Color;

/**
 * The type Background 3.
 */
public class Background3 implements Sprite {
    @Override
    public void drawOn(DrawSurface d) {
        Color background = new Color(60, 130, 50);
        d.setColor(background);
        d.fillRectangle(0, 0, 800, 600);
        d.setColor(Color.black);
        d.fillRectangle(40, 450, 110, 200);
        d.setColor(Color.white);
        int firstX = 50, firstY = 455;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                d.fillRectangle(firstX, firstY, 12, 25);
                firstX += 20;
            }
            firstY += 30;
            firstX = 50;

        }
        d.setColor(Color.darkGray.darker());
        d.fillRectangle(83, 400, 30, 50);
        d.setColor(Color.darkGray);
        d.fillRectangle(93, 200, 10, 200);
        d.setColor(Color.orange);
        d.fillCircle(98, 200, 10);
        d.setColor(Color.red);
        d.fillCircle(98, 200, 7);
        d.setColor(Color.white);
        d.fillCircle(98, 200, 3);

    }

    @Override
    public void timePassed() {

    }
}
