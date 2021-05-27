// ID: 314987926
package geometric;

import java.util.List;
import java.util.ArrayList;

/**
 * The type geometric.Rectangle.
 */
public class Rectangle {
    // Fields
    private Point upperLeft;
    private double width;
    private double height;

    /**
     * Create a new rectangle with location and width/height.
     *
     * @param upperLeft the upper left
     * @param width     the width
     * @param height    the height
     */
    public Rectangle(Point upperLeft, double width, double height) {
        this.upperLeft = upperLeft;
        this.width = width;
        this.height = height;
    }

    /**
     * Return a (possibly empty) List of intersection points
     * with the specified line.
     *
     * @param line the line
     * @return the java . util . list
     */
    public java.util.List<Point> intersectionPoints(Line line) {

        double upperRightX = this.upperLeft.getX() + this.width;
        double downLeftY = this.upperLeft.getY() + height;
        double downRightX = upperRightX;
        double downRightY = downLeftY;
        Point upperRight = new Point(upperRightX, this.upperLeft.getY());
        Point downRight = new Point(downRightX, downRightY);
        Point downLeft = new Point(this.upperLeft.getX(), downLeftY);
        Line upperLine = new Line(this.upperLeft, upperRight);
        Line downLine = new Line(downRight, downLeft);
        Line leftLine = new Line(this.upperLeft, downLeft);
        Line rightLine = new Line(upperRight, downRight);
        List<Point> interPoint = new ArrayList<Point>();

        //check if the point is on one of the lines and add it to the list
        if (line.isIntersecting(upperLine)) {
            interPoint.add(line.intersectionWith(upperLine));
        }
        if (line.isIntersecting(downLine)) {
            interPoint.add(line.intersectionWith(downLine));
        }
        if (line.isIntersecting(leftLine)) {
            interPoint.add(line.intersectionWith(leftLine));
        }
        if (line.isIntersecting(rightLine)) {
            interPoint.add(line.intersectionWith(rightLine));
        }
        return interPoint;
    }

    /**
     * Gets width.
     *
     * @return the width
     */
    public double getWidth() {
        return this.width;
    }

    /**
     * Gets height.
     *
     * @return the height
     */
    public double getHeight() {
        return this.height;
    }

    /**
     * Gets upper left.
     *
     * @return the upper left
     */
    public Point getUpperLeft() {
        return this.upperLeft;
    }

    /**
     * Sets upper left.
     *
     * @param x the x
     * @param y the y
     */
    public void setUpperLeft(double x, double y) {
        this.upperLeft.setX(x);
        this.upperLeft.setY(y);
    }
}