package thegame;

import biuoop.DrawSurface;
import biuoop.KeyboardSensor;
import interfaces.Animation;

/**
 * The type Key press stoppable animation.
 */
public class KeyPressStoppableAnimation implements Animation {
    private Animation animation;
    private String key;
    private KeyboardSensor keyboardSensor;
    private boolean running;
    private boolean isAlreadyPressed = true;

    /**
     * Instantiates a new Key press stoppable animation.
     *
     * @param sensor    the sensor
     * @param key       the key
     * @param animation the animation
     */
    public KeyPressStoppableAnimation(KeyboardSensor sensor, String key, Animation animation) {
        this.animation = animation;
        this.key = key;
        this.keyboardSensor = sensor;
        this.running = false;
    }

    @Override
    public void doOneFrame(DrawSurface d) {
        animation.doOneFrame(d);
        if (!this.keyboardSensor.isPressed(this.key)) {
            this.isAlreadyPressed = false;
        }
        if (!isAlreadyPressed && this.keyboardSensor.isPressed(this.key)) {
            this.running = true;
        }
    }
    @Override
    public boolean shouldStop() {
        return this.running;
    }
}
