// ID: 314987926
package geometric;

/**
 * The type geometric.Point.
 */
public class Point {
    // Fields
    private double x;
    private double y;

    /**
     * Instantiates a new geometric.Point.
     *
     * @param x the x
     * @param y the y
     */
// constructor
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Return the distance of this point to the other point.
     *
     * @param other the other line
     * @return the double the distance between them
     */
    public double distance(Point other) {
        double rootOfDistance = (Math.pow(this.x - other.getX(), 2) + Math.pow(this.y - other.getY(), 2));
        return Math.sqrt(rootOfDistance);
    }

    /**
     * Return true if the points are equal, false otherwise.
     *
     * @param other the other point
     * @return the boolean
     */
    public boolean equals(Point other) {
        return (this.x == other.getX() && this.y == other.getY());
    }

    /**
     * Gets x.
     *
     * @return the x
     */
    public double getX() {
        return this.x;

    }

    /**
     * Gets y.
     *
     * @return the y
     */
    public double getY() {
        return this.y;
    }

    /**
     * Sets x.
     *
     * @param theX the x
     */
    public void setX(double theX) {
        this.x = theX;
    }

    /**
     * Sets y.
     *
     * @param theY the y
     */
    public void setY(double theY) {
        this.y = theY;
    }
}

