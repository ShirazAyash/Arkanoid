// ID: 314987926
package thegame;

import biuoop.DrawSurface;
import biuoop.GUI;
import biuoop.KeyboardSensor;
import geometric.Point;
import geometric.Rectangle;
import geometric.Velocity;
import interfaces.Animation;
import interfaces.LevelInformation;
import listeners.BallRemover;
import listeners.BlockRemover;
import listeners.ScoreTrackingListener;
import screens.PauseScreen;
import sprites.Ball;
import sprites.Block;
import interfaces.Collidable;
import interfaces.HitListener;
import sprites.Paddle;
import sprites.ScoreIndicator;
import interfaces.Sprite;

import java.awt.Color;
import java.util.List;

/**
 * The game.Game class is initialize the game by adding all the objects on the screen and run it.
 */
public class GameLevel implements Animation {
    private LevelInformation level;
    private SpriteCollection sprites;
    private GameEnvironment environment;
    private GUI gui;
    private Counter blockCounter;
    private Counter ballsCounter;
    private Counter score;
    private AnimationRunner runner;
    private boolean running;
    private KeyboardSensor keyboard;

    /**
     * Balls left int.
     *
     * @return the int
     */
    public int ballsLeft() {
        return this.ballsCounter.getValue();
    }

    /**
     * Blocks left int.
     *
     * @return the int
     */
    public int blocksLeft() {
        return this.blockCounter.getValue();
    }

    /**
     * The constant GAME_WIDTH.
     */
    public static final int GAME_WIDTH = 800;
    /**
     * The constant GAME_HEIGHT.
     */
    public static final int GAME_HEIGHT = 600;
    /**
     * The constant PADDLE_H.
     */
    public static final int PADDLE_H = 12;
    /**
     * The constant BLOCK_W.
     */
    public static final int BLOCK_W = 40;
    /**
     * The constant BLOCK_H.
     */
    public static final int BLOCK_H = 20;

    /**
     * Instantiates a new Game level.
     *
     * @param level           the level
     * @param keyboardSensor  the keyboard sensor
     * @param animationRunner the animation runner
     * @param score           the score
     * @param giu             the giu
     */
    public GameLevel(LevelInformation level, KeyboardSensor keyboardSensor, AnimationRunner animationRunner,
                     Counter score, GUI giu) {
        this.sprites = new SpriteCollection();
        this.environment = new GameEnvironment();
        this.blockCounter = new Counter(0);
        this.ballsCounter = new Counter(0);
        this.runner = animationRunner;
        this.keyboard = keyboardSensor;
        this.level = level;
        this.score = score;
        this.gui = giu;
    }

    /**
     * Add collidable.
     *
     * @param c the collidable
     */
    public void addCollidable(Collidable c) {
        this.environment.addCollidable(c);
    }

    /**
     * Add sprite.
     *
     * @param s the sprite
     */
    public void addSprite(Sprite s) {
        this.sprites.addSprite(s);
    }

    /**
     * Remove collidable.
     *
     * @param c the c
     */
    public void removeCollidable(Collidable c) {
        this.environment.removeCollidable(c);
    }

    /**
     * Remove sprite.
     *
     * @param s the s
     */
    public void removeSprite(Sprite s) {
        this.sprites.removeSprite(s);
    }

    /**
     * Initialize the game by adding 2 balls, the frame of the game,the paddle and the blocks.
     */
    public void initialize() {
        //add listeners
        HitListener removeBlock = new BlockRemover(this, this.blockCounter);
        HitListener removeBall = new BallRemover(this, this.ballsCounter);
        HitListener scoreListener = new ScoreTrackingListener(this.score);

        this.sprites.addSprite(this.level.getBackground());

        this.ballsCounter.increase(this.level.numberOfBalls());
        this.blockCounter.increase(this.level.numberOfBlocksToRemove());
        Point p = new Point(0, 0);
        Rectangle scoreRec = new Rectangle(p, GAME_WIDTH, BLOCK_H);
        ScoreIndicator scoreIndicator = new ScoreIndicator(scoreRec, this.score);
        scoreIndicator.addToGame(this);

        addFrame();

        //add the "killing block"
        Point p4 = new Point(BLOCK_H, GAME_HEIGHT + 10);
        Rectangle r4 = new Rectangle(p4, GAME_WIDTH - BLOCK_H, BLOCK_H);
        Block block4 = new Block(r4, Color.gray);
        block4.addHitListener(removeBall);
        block4.addToGame(this);


        //add the paddle
        Point paddleP = new Point(400 - this.level.paddleWidth() / 2, GAME_HEIGHT - PADDLE_H);
        Rectangle paddleRec = new Rectangle(paddleP, this.level.paddleWidth(), PADDLE_H);
        Paddle paddle = new Paddle(paddleRec, Color.pink, gui.getKeyboardSensor(), BLOCK_H,
                GAME_WIDTH - BLOCK_H, this.level.paddleSpeed());
        paddle.addToGame(this);

        List<Block> list = this.level.blocks();
        for (Block block : list) {
            //this.blockCounter.increase(1);
            block.addHitListener(removeBlock);
            block.addHitListener(scoreListener);
            block.addToGame(this);
        }
    }

    @Override
    public void doOneFrame(DrawSurface d) {
        this.sprites.drawAllOn(d);
        d.setColor(Color.black);
        d.drawText(600, 15, "Level Name: " + this.level.levelName(), 15);
        this.sprites.notifyAllTimePassed();
        if (this.blockCounter.getValue() == -1 || this.ballsCounter.getValue() == 0) {
            this.running = false;
        }
        if (this.blockCounter.getValue() == 0) {
            this.blockCounter.decrease(1);
        }
        if (this.keyboard.isPressed("p")) {
            this.runner.run(new KeyPressStoppableAnimation(this.keyboard, KeyboardSensor.SPACE_KEY, new PauseScreen()));
        }
    }

    @Override
    public boolean shouldStop() {
        return !this.running;
    }

    /**
     * Run the game -- start the animation loop.
     */
    public void run() {
        this.createBallsOnTopOfPaddle(); // or a similar method
        this.running = true;
        this.runner.run(new CountdownAnimation(2, 3, this.sprites)); // countdown before turn starts.
        // use our runner to run the current animation -- which is one turn of
        // the game.
        this.runner.run(this);
    }
    /**
     * Creats the balls on the Paddle.
     */
    private void createBallsOnTopOfPaddle() {
        List<Velocity> velList = this.level.initialBallVelocities();
        for (Velocity vel : velList) {
            Point center = new Point(400, 550);
            Ball ball = new Ball(center, 5, Color.white, this.environment);
            ball.setVelocity(vel);
            ball.addToGame(this);
        }
    }

    /**
     * Add frame - add the blocks in the frame so that the ball never travels outside of the screen.
     */
    public void addFrame() {
        Point p1 = new Point(0, 20);
        Rectangle r1 = new Rectangle(p1, GAME_WIDTH, BLOCK_H);
        Block block1 = new Block(r1, Color.gray);
        block1.addToGame(this);

        Point p2 = new Point(0, BLOCK_H);
        Rectangle r2 = new Rectangle(p2, BLOCK_H, GAME_HEIGHT - BLOCK_H);
        Block block2 = new Block(r2, Color.gray);
        block2.addToGame(this);

        Point p3 = new Point(GAME_WIDTH - BLOCK_H, BLOCK_H);
        Rectangle r3 = new Rectangle(p3, BLOCK_H, GAME_HEIGHT - BLOCK_H);
        Block block3 = new Block(r3, Color.gray);
        block3.addToGame(this);

    }
}