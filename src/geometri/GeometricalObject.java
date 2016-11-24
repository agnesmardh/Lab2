package geometri;

import java.awt.*;

/**
 * Super class for the geometrical objects such as Point or Rectangle.
 * Contains methods and fields in common for the geometrical objects.
 */

public abstract class GeometricalObject implements GeometricalForm {

    /**
     * initial position, x direction
     */
    protected int x;

    /**
     * initial position, y direction
     */
    protected int y;

    /**
     * the color of the object
     */
    protected Color c;

    /**
     * the area of the object, zero if Point or Line
     */
    protected int area;

    /**
     * the perimeter of the object, zero if Point, length if Line
     */
    protected int perimeter;

    /**
     * {@inheritDoc}
     */
    public abstract void fill(Graphics g);

    /**
     * {@inheritDoc}
     */
    public Color getColor() {
        return c;
    }

    /**
     * {@inheritDoc}
     */
    public int getArea() {
        return area;
    }

    /**
     * Sets the area of the object
     *
     * @param area the area of the object
     */
    public void setArea(int area) {
        this.area = area;
    }

    /**
     * {@inheritDoc}
     */
    //??
    public int getHeight() {
        return 0;
    }

    /**
     * {@inheritDoc}
     */
    public int getPerimeter() {
        return perimeter;
    }

    /**
     * {@inheritDoc}
     */
    //??
    public int getWidth() {
        return 0;
    }

    /**
     * {@inheritDoc}
     */
    public int getX() {
        return x;
    }

    /**
     * {@inheritDoc}
     */
    public int getY() {
        return y;
    }

    /**
     * {@inheritDoc}
     */
    public void move(int dx, int dy) throws IllegalPositionException {
        if (dx < 0 || dy < 0) {
            throw new IllegalPositionException("Negative values");
        }
        this.x = dx;
        this.y = dy;
    }

    /**
     * {@inheritDoc}
     */
    public void place(int x, int y) throws IllegalPositionException {
        if (x < 0 || y < 0) {
            throw new IllegalPositionException("Negative values");
        }
        this.x = x;
        this.y = y;
    }

    /**
     * Compares two objects.
     *
     * @param f The geometrical form to compare with.
     * @return a negative integer, zero, or a positive integer as this object is less than, equal to,
     * greater than the specified object.
     */
    @Override
    public int compareTo(GeometricalForm f) {
        if (this.area != f.getArea()) {
            if (this.area > f.getArea()) {
                return 1;
            } else {
                return -1;
            }
        } else {
            if (this.perimeter != f.getPerimeter()) {
                if (perimeter > f.getPerimeter()) {
                    return 1;
                } else {
                    return -1;
                }
            }
        }
        return 0;
    }


    /**
     * Indicates whether some other object is equal to this one.
     *
     * @param o The object with which to compare.
     * @return true if equal, false otherwise
     */
    @Override
    public abstract boolean equals(Object o);

    /**
     * Returns a hash code value for this object.
     *
     * @return a hash code value for this object
     */
    @Override
    public abstract int hashCode();

}
