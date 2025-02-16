/**
 * The Point class represents a point in a 2D coordinate system with non-negative coordinates.
 * This class provides functionality for creating, manipulating, and comparing points in
 * a two-dimensional space. All coordinates are restricted to non-negative values.
 * 
 * The class includes methods for:
 * - Creating points with specific coordinates
 * - Comparing positions of points (above, below, left, right)
 * - Calculating distances and midpoints
 * - Moving points in the coordinate system
 * - String representation of points
 * 
 * All coordinates are maintained as non-negative integers. Any attempt to set
 * negative coordinates (either through construction or mutation) will result
 * in the coordinates being set to 0 or the operation being ignored.
 * 
 * @author Shimon Esterkin (SemionVlad)
 * @version 2023B
 */
public class Point {
    
    // Instance variables for x and y coordinates
    private int _x;  // x-coordinate (must be non-negative)
    private int _y;  // y-coordinate (must be non-negative)

    /**
     * Constructs a new Point with specified coordinates.
     * If negative coordinates are provided, they are set to 0.
     *
     * @param _x the x-coordinate
     * @param _y the y-coordinate
     */
    public Point(int x, int y) {
        this._x = (x < 0) ? 0 : x;
        this._y = (y < 0) ? 0 : y;
    }

    /**
     * Copy constructor - creates a new Point with the same coordinates as another Point.
     *
     * @param other the Point to copy
     */
    public Point(Point other) {
        this._x = other._x;
        this._y = other._y;
    }

    // Getters and Setters
    
    /**
     * @return the x-coordinate
     */
    public int getX() {
        return this._x;
    }

    /**
     * @return the y-coordinate
     */
    public int getY() {
        return this._y;
    }

    /**
     * Sets the x-coordinate if the provided value is non-negative.
     *
     * @param num the new x-coordinate
     */
    public void setX(int num) {
        if (num >= 0) {
            this._x = num;
        }
    }

    /**
     * Sets the y-coordinate if the provided value is non-negative.
     *
     * @param num the new y-coordinate
     */
    public void setY(int num) {
        if (num >= 0) {
            this._y = num;
        }
    }

    // Positional Comparison Methods

    /**
     * Checks if two points are equal to each other.
     *
     * @param other the point to compare with
     * @return true if this points are equal to each other.
     */
    public boolean equals(Point other) {
        return (this._x == other.getX() ) && (this._x == other.getX());
    }
    
    /**
     * Checks if this point is above another point.
     *
     * @param other the point to compare with
     * @return true if this point is above the other point
     */
    public boolean isAbove(Point other) {
        return this._y > other.getY();
    }

    /**
     * Checks if this point is below another point.
     *
     * @param other the point to compare with
     * @return true if this point is below the other point
     */
    public boolean isUnder(Point other) {
        return this._y < other.getY();
    }

    /**
     * Checks if this point is to the left of another point.
     *
     * @param other the point to compare with
     * @return true if this point is left of the other point
     */
    public boolean isLeft(Point other) {
        return this._x < other.getX();
    }

    /**
     * Checks if this point is to the right of another point.
     *
     * @param other the point to compare with
     * @return true if this point is right of the other point
     */
    public boolean isRight(Point other) {
        return this._x > other.getX();
    }

    // Utility Methods
    
    /**
     * Returns a string representation of the point in the format "(x,y)".
     *
     * @return formatted string representation of the point
     */
    @Override
    public String toString() {
        return String.format("(%d,%d)", this._x, this._y);
    }

    /**
     * Moves the point by the specified deltas if the resulting position would remain non-negative.
     *
     * @param deltaX the change in x-coordinate
     * @param deltaY the change in y-coordinate
     */
    public void move(int deltaX, int deltaY) {
        if ((this._x + deltaX >= 0) && (this._y + deltaY >= 0)) {
            this._x += deltaX;
            this._y += deltaY;
        }
    }

    /**
     * Calculates the midpoint between this point and another point.
     *
     * @param p the other point
     * @return a new Point representing the midpoint
     */
    public Point middle(Point p) {
        return new Point((this._x + p.getX()) / 2, (this._y + p.getY()) / 2);
    }

    /**
     * Calculates the Euclidean distance between this point and another point.
     *
     * @param p the other point
     * @return the distance between the two points
     */
    public double distance(Point p) {
        return Math.sqrt(Math.pow(this._x - p.getX(), 2) + Math.pow(this._y - p.getY(), 2));
    }
}
