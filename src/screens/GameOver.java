package screens;

import biuoop.DrawSurface;
import interfaces.Animation;
import java.awt.Color;

/**
 * The type Game over.
 */
public class GameOver implements Animation {
    private int score;
    private boolean running;
    private int ballY = 0;

    /**
     * Instantiates a new Game over.
     *
     * @param score the score
     */
    public GameOver(int score) {
        this.score = score;
        this.running = true;
    }

    @Override
    public void doOneFrame(DrawSurface d) {
        d.setColor(Color.black);
        d.fillRectangle(0, 0, 800, 600);
        d.setColor(Color.white);
        for (int i = 0; i < 20; i++) {
            d.fillCircle(20 + i * 50, ballY, 4);
        }
        ballY += 5;
        d.setColor(Color.red);
        d.drawText(70, 300, "Game Over. Your score is " + String.valueOf(this.score), 50);

    }
    @Override
    public boolean shouldStop() {
        return !this.running;
    }
}
