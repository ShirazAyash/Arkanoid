package screens;

import biuoop.DrawSurface;
import interfaces.Animation;
import java.awt.Color;

/**
 * The type You win.
 */
public class YouWin implements Animation {
    private int score;
    private boolean running;
    private int ballY = 600;
    private int ballX = 0;

    /**
     * Instantiates a new You win.
     *
     * @param score the score
     */
    public YouWin(int score) {
        this.score = score;
        this.running = true;
    }

    @Override
    public void doOneFrame(DrawSurface d) {
        Color color = new Color(10, 140, 220);
        d.setColor(color);
        d.fillRectangle(0, 0, 800, 600);
        Color[] list = {Color.cyan, Color.pink, Color.red, Color.orange, Color.yellow, Color.green};
        for (int i = 0; i < 20; i++) {
            d.setColor(list[i % 6]);
            d.fillCircle(ballX + i * 50, ballY, i % 6 + 3);
        }
        ballY -= 5;
        if (ballY < 0) {
            ballY = 600;
        }
        d.setColor(Color.white);
        d.drawText(130, 250, "You Win! Your score is ", 50);
        d.drawText(310, 370, String.valueOf(this.score), 100);
    }
    @Override
    public boolean shouldStop() {
        return !this.running;
    }
}
