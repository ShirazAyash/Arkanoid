// ID: 314987926
package geometric;

import java.util.List;

/**
 * The type geometric.Line.
 */
public class Line {
    // Fields
    private Point start;
    private Point end;

    /**
     * Instantiates a new geometric.Line.
     *
     * @param start the start point of the line
     * @param end   the end point of the line
     */
// constructors
    public Line(Point start, Point end) {
        this.start = start;
        this.end = end;
    }

    /**
     * Instantiates a new geometric.Line.
     *
     * @param x1 the x 1 the x value of the start point
     * @param y1 the y 1 the y value of the start point
     * @param x2 the x 2 the x value of the end point
     * @param y2 the y 2 the y value of the start point
     */
    public Line(double x1, double y1, double x2, double y2) {

        this.start = new Point(x1, y1);
        this.end = new Point(x2, y2);
    }

    /**
     * Return the length of the line.
     *
     * @return the length
     */
    public double length() {
        return start.distance(end);
    }

    /**
     * Returns the middle point of the line.
     *
     * @return the middle point
     */
    public Point middle() {
        double x = (start.getX() + end.getX()) / 2;
        double y = (start.getY() + end.getY()) / 2;
        Point middle = new Point(x, y);
        return middle;
    }

    /**
     * Returns the start point of the line.
     *
     * @return the point
     */
    public Point start() {
        return this.start;
    }

    /**
     * Returns the end point of the line.
     *
     * @return the point
     */
    public Point end() {
        return this.end;
    }

    /**
     * Returns true if the lines intersect, false otherwise.
     *
     * @param other the other line
     * @return the boolean
     */
    public boolean isIntersecting(Line other) {
        Point thePoint = this.intersectionWith(other);
        return thePoint != null;
    }

    /**
     * Returns true if x is a number between edge1 and edge2.
     *
     * @param x     the number we want to check
     * @param edge1 the first edge
     * @param edge2 the other edge
     * @return the boolean
     */
    private boolean isBetween(double x, double edge1, double edge2) {
        boolean between = ((x <= edge1 && x >= edge2) || (x <= edge2 && x >= edge1));
        return between;
    }

    /**
     * Returns the slope of the line.
     *
     * @return the slope of the line
     */
    public double slope() {
        return ((this.start.getY() - this.end.getY()) / (this.start.getX() - this.end.getX()));
    }

    /**
     * Return the intercept of the line.
     *
     * @return the intercept of the line
     */
    public double intercept() {
        return (this.start.getY() - (this.slope() * this.start.getX()));
    }

    /**
     * Returns the intersection point if the lines intersect,
     * Otherwise returns null.
     *
     * @param other the other line
     * @return the point
     */
    public Point intersectionWith(Line other) {
        double thisSlope, otherSlope, thisIntercept, otherIntercept, theY, theX;
        Point thePoint;
        //if both of the lines dont have a slope
        if (this.end.getX() == this.start.getX() && other.end.getX() == other.start.getX()) {
            // if they on the same line check if one of them continue the other
            //check if they intersecting in one point returns this point
            if (this.start.getX() == other.start.getX()) {
                if (Math.max(this.start.getY(), this.end.getY())
                        == Math.min(other.start.getY(), other.end.getY())) {
                    thePoint = new Point(this.start.getX(), Math.max(this.start.getY(), this.end.getY()));
                    return thePoint;
                } else if (Math.max(other.start.getY(), other.end.getY())
                        == Math.min(this.start.getY(), this.end.getY())) {
                    thePoint = new Point(this.start.getX(), Math.max(other.start.getY(), other.end.getY()));
                    return thePoint;
                }
            }
            //if only one of the lines doesnt have a slope
        } else if (this.end.getX() == this.start.getX() && other.end.getX() != other.start.getX()) {
            //find the other slope and intercept
            otherSlope = other.slope();
            otherIntercept = other.intercept();
            //fine the y value in the other line according to the x of this line
            theY = (otherSlope * this.start.getX()) + otherIntercept;
            //if this x is between the other x values and the y is between this y values
            //returns the point of the intercepting
            if (isBetween(this.start.getX(), other.end.getX(), other.start.getX())
                    && isBetween(theY, this.start.getY(), this.end.getY())) {
                thePoint = new Point(this.start.getX(), theY);
                return thePoint;
            }
            //the same check but on the other line
        } else if (this.end.getX() != this.start.getX() && other.end.getX() == other.start.getX()) {
            thisSlope = this.slope();
            thisIntercept = this.intercept();
            theY = (thisSlope * other.start.getX()) + thisIntercept;
            if (isBetween(other.start.getX(), this.end.getX(), this.start.getX())
                    && isBetween(theY, other.start.getY(), other.end.getY())) {
                thePoint = new Point(other.start.getX(), theY);
                return thePoint;
            }
            //if they both have a slope
        } else {
            //find the lines slopes and intercepts
            thisSlope = this.slope();
            thisIntercept = this.intercept();
            otherSlope = other.slope();
            otherIntercept = other.intercept();
            //if they have the same slope and the same intercept check if they have only one intersection point
            //and returns this point
            if (thisSlope == otherSlope) {
                if (thisIntercept == otherIntercept) {
                    if (Math.max(this.start.getX(), this.end.getX())
                            == Math.min(other.start.getX(), other.end.getX())) {
                        theX = Math.max(this.start.getX(), this.end.getX());
                        thePoint = new Point(theX, this.slope() * theX + thisIntercept);
                        return thePoint;
                    } else if (Math.min(this.start.getX(), this.end.getX())
                            == Math.max(other.start.getX(), other.end.getX())) {
                        theX = Math.min(this.start.getX(), this.end.getX());
                        thePoint = new Point(theX, this.slope() * theX + thisIntercept);
                        return thePoint;
                    }
                }
                //if they dont have the same slope
            } else {
                //find the x and y of the interception point and if this point is one both lines returns it
                theX = (otherIntercept - thisIntercept) / (thisSlope - otherSlope);
                theY = (thisSlope * theX) + thisIntercept;
                if (isBetween(theX, this.start.getX(), this.end.getX())
                        && isBetween(theX, other.start.getX(), other.end.getX())) {
                    thePoint = new Point(theX, theY);
                    return thePoint;

                }
            }
        }
        // if there is no interception point then returns null
        return null;
    }

    /**
     * Return true is the lines are equal, false otherwise.
     *
     * @param other the other
     * @return the boolean
     */
    public boolean equals(Line other) {
        return (this.start.equals(other.start) && this.end.equals(other.end));
    }

    /**
     * If this line does not intersect with the rectangle, return null.
     * Otherwise, return the closest intersection point to the
     * start of the line.
     *
     * @param rect the rect
     * @return the point
     */
    public Point closestIntersectionToStartOfLine(Rectangle rect) {
        List<Point> interPoint = rect.intersectionPoints(this);
        if (interPoint.isEmpty()) {
            return null;
        } else {
            double theMinDis = -1;
            double currentDis;
            Point theMinPoint = null;
            for (int i = 0; i < interPoint.size(); i++) {
                currentDis = interPoint.get(i).distance(this.start);
                if (currentDis < theMinDis || theMinDis == -1) {
                    theMinDis = currentDis;
                    theMinPoint = interPoint.get(i);
                }
            }
            return theMinPoint;
        }
    }
}
