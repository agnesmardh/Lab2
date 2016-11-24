package geometri;

import java.awt.*;

public class Circle extends GeometricalObject {
    private int diameter;

    /**
     * Creates a circle
     *
     * @param x        start point, x direction
     * @param y        start point, y direction
     * @param diameter diameter of circle
     * @param c        color of circle
     * @throws IllegalPositionException if negative values
     */
    public Circle(int x, int y, int diameter, Color c) throws IllegalPositionException {
        super(x, y, c);
        if (x < 0 || y < 0 || diameter < 0) {
            throw new IllegalPositionException("Negative values");
        }
        this.diameter = diameter;
        area = (int) (Math.PI * Math.pow((diameter / 2), 2));
        perimeter = (int) Math.PI * diameter;
    }

    /**
     * Creates a circle
     *
     * @param f        start point
     * @param diameter diameter of circle
     * @param c        color of circle
     */
    public Circle(GeometricalForm f, int diameter, Color c) {
        super(f, c);
        this.diameter = diameter;
        area = (int) (Math.PI * Math.pow((diameter / 2), 2));
        perimeter = (int) Math.PI * diameter;
    }


    /**
     * Gets the diameter
     *
     * @return the diameter of the circle
     */
    public int getDiameter() {
        return diameter;
    }

    /**
     * {@inheritDoc}
     */
    public void fill(Graphics g) {
        g.setColor(c);
        g.fillOval(x, y, diameter, diameter);
    }

    /**
     * Indicates whether some other object is equal to this one.
     *
     * @param o The object with which to compare.
     * @return true if equal, false otherwise
     */
    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Circle)) {
            return false;
        } else if (this.diameter != ((Circle) o).diameter) {
            return false;
        }
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int hashCode() {
        return 3 * diameter;
    }

}
