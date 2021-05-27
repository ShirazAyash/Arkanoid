package backgrounds;

import biuoop.DrawSurface;
import interfaces.Sprite;
import java.awt.Color;

/**
 * The type Backgruond 4.
 */
public class Backgruond4 implements Sprite {
    @Override
    public void drawOn(DrawSurface d) {
        Color color = new Color(10, 140, 220);
        d.setColor(color);
        d.fillRectangle(0, 0, 800, 600);
        this.drawCloud(70, 400, d);
        this.drawCloud(600, 500, d);

    }
    /**
     * Instantiates a new geometric.Line.
     *
     * @param x the x value point of the left circle in the cloud
     * @param y the y value point of the left circle in the cloud
     * @param d the surface
     */
    private void drawCloud(int x, int y, DrawSurface d) {
        int firstX = x;
        d.setColor(Color.white);
        for (int i = 0; i < 10; i++) {
            d.drawLine(firstX, y, firstX - 80, 800);
            firstX += 10;
        }
        d.setColor(Color.lightGray);
        d.fillCircle(x, y, 15);
        d.fillCircle(x + 20, y + 20, 20);
        d.setColor(Color.gray.brighter());
        d.fillCircle(x + 30, y - 10, 25);
        d.setColor(Color.lightGray.darker());
        d.fillCircle(x + 75, y, 30);
        d.fillCircle(x + 50, y + 20, 20);
    }

    @Override
    public void timePassed() {

    }
}
