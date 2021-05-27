package thegame;

import biuoop.DrawSurface;
import interfaces.Animation;

import java.awt.Color;

/**
 * The CountdownAnimation will display the given gameScreen,
 * for numOfSeconds seconds, and on top of them it will show
 * a countdown from countFrom back to 1, where each number will
 * appear on the screen for (numOfSeconds / countFrom) seconds, before
 * it is replaced with the next one.
 */
public class CountdownAnimation implements Animation {
    private double numOfSeconds;
    private int countFrom;
    private SpriteCollection gameScreen;
    private boolean stop;
    private int step = 0;
    private double milSec;

    /**
     * Instantiates a new Countdown animation.
     *
     * @param numOfSeconds the num of seconds
     * @param countFrom    the count from
     * @param gameScreen   the game screen
     */
    public CountdownAnimation(double numOfSeconds, int countFrom, SpriteCollection gameScreen) {
        this.numOfSeconds = numOfSeconds;
        this.countFrom = countFrom;
        this.gameScreen = gameScreen;
        this.stop = false;
        this.milSec = 1000 * (this.numOfSeconds / this.countFrom + 1);
    }

    @Override
    public void doOneFrame(DrawSurface d) {
        gameScreen.drawAllOn(d);
        if (this.countFrom > 0) {
            d.setColor(Color.red);
            d.fillCircle(d.getWidth() / 2, d.getHeight() / 2, 50);
            d.setColor(Color.black);
            d.drawCircle(d.getWidth() / 2, d.getHeight() / 2, 50);
            d.setColor(Color.black);
            d.drawText(d.getWidth() / 2 - 10, d.getHeight() / 2 + 10, String.valueOf(countFrom), 35);
        }
        if (this.countFrom == 0) {
            d.setColor(Color.green);
            d.fillCircle(d.getWidth() / 2, d.getHeight() / 2, 35);
            d.setColor(Color.black);
            d.drawCircle(d.getWidth() / 2, d.getHeight() / 2, 35);
            d.setColor(Color.black);
            d.drawText(d.getWidth() / 2 - 30, d.getHeight() / 2 + 11, "GO!", 32);
        }
        if (this.countFrom == -1) {
            this.stop = true;
        }
        this.step += 60;
        if (this.step >= this.milSec) {
            this.countFrom--;
            this.step = 0;
        }
    }
    @Override
    public boolean shouldStop() {
        return this.stop;
    }
}