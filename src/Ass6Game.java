// ID: 314987926

import biuoop.GUI;
import biuoop.KeyboardSensor;
import interfaces.LevelInformation;
import thegame.AnimationRunner;
import thegame.GameFlow;
import screens.Level1;
import screens.Level2;
import screens.Level3;
import screens.Level4;

import java.util.ArrayList;
import java.util.List;

/**
 * The class game.Ass3Game create and run a new game.
 */
public class Ass6Game {
    /**
     * The Main.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        GUI gui = new GUI("Arkanoid", 800, 600);
        KeyboardSensor keyboardSensor = gui.getKeyboardSensor();
        AnimationRunner runner = new AnimationRunner(gui);
        List<LevelInformation> levelList = new ArrayList<>();
        for (int i = 0; i < args.length; i++) {
            switch (args[i]) {
                case "1":
                    levelList.add(new Level1());
                    break;
                case "2":
                    levelList.add(new Level2());
                    break;
                case "3":
                    levelList.add(new Level3());
                    break;
                case "4":
                    levelList.add(new Level4());
                    break;
                default:
                    break;
            }
        }
        if (levelList.isEmpty()) {
            levelList.add(new Level1());
            levelList.add(new Level2());
            levelList.add(new Level3());
            levelList.add(new Level4());
        }

        GameFlow game = new GameFlow(runner, keyboardSensor, gui);
        game.runLevels(levelList);
    }
}
