package thegame;

import biuoop.GUI;
import biuoop.KeyboardSensor;
import interfaces.LevelInformation;
import screens.GameOver;
import screens.YouWin;
import java.util.List;

/**
 * The type Game flow.
 */
public class GameFlow {
    private Counter score;
    private GUI gui;
    private biuoop.KeyboardSensor keyboardSensor;
    private AnimationRunner animationRunner;

    /**
     * Instantiates a new Game flow.
     *
     * @param ar  the ar
     * @param ks  the ks
     * @param gui the gui
     */
    public GameFlow(AnimationRunner ar, KeyboardSensor ks, GUI gui) {
        this.keyboardSensor = ks;
        this.score = new Counter(0);
        this.animationRunner = ar;
        this.gui = gui;
    }

    /**
     * Run levels.
     *
     * @param levels the levels
     */
    public void runLevels(List<LevelInformation> levels) {
        Boolean gameOver = false;
        for (LevelInformation levelInfo : levels) {

            GameLevel level = new GameLevel(levelInfo, this.keyboardSensor,
                    this.animationRunner, this.score, this.gui);

            level.initialize();

            while (level.ballsLeft() > 0 && level.blocksLeft() > 0) {
                level.run();
            }

            if (level.ballsLeft() == 0) {
                gameOver = true;
                break;
            }
            this.score.increase(100);

        }
        if (gameOver) {
            this.animationRunner.run(new KeyPressStoppableAnimation(this.keyboardSensor, KeyboardSensor.SPACE_KEY,
                    new GameOver(this.score.getValue())));
        } else {
            this.animationRunner.run(new KeyPressStoppableAnimation(this.keyboardSensor, KeyboardSensor.SPACE_KEY,
                    new YouWin(this.score.getValue())));
        }
        gui.close();
    }
}
