// ID: 314987926
package geometric;

/**
 * The type geometric.Velocity.
 */
public class Velocity {
    // Fields
    private double dx = 0;
    private double dy = 0;

    /**
     * Instantiates a new geometric.Velocity.
     *
     * @param dx the dx
     * @param dy the dy
     */
// constructor
    public Velocity(double dx, double dy) {
        this.dx = dx;
        this.dy = dy;
    }

    /**
     * Take a point with position (x,y) and return a new point.
     * with position (x+dx, y+dy)
     *
     * @param p the point
     * @return the point after the position
     */
    public Point applyToPoint(Point p) {
        Point newPoint = new Point(p.getX() + dx, p.getY() + dy);
        return newPoint;
    }

    /**
     * Gets dx.
     *
     * @return the dx
     */
    public double getDx() {
        return this.dx;
    }

    /**
     * Gets dy.
     *
     * @return the dy
     */
    public double getDy() {
        return this.dy;
    }


    /**
     * Sets dx.
     *
     * @param theDx the the dx
     */
    public void setDx(double theDx) {
        this.dx = theDx;
    }

    /**
     * Sets dy.
     *
     * @param theDy the the dy
     */
    public void setDy(double theDy) {
        this.dy = theDy;
    }

    /**
     * take an angle and speed and convert it to velocity.
     *
     * @param angle the angle
     * @param speed the speed
     * @return the velocity
     */
    public static Velocity fromAngleAndSpeed(double angle, double speed) {
        double angleR = Math.toRadians(angle);
        double dx = speed * Math.sin(angleR);
        double dy = -1 * speed * Math.cos(angleR);
        Velocity vel = new Velocity(dx, dy);
        return vel;
    }

}