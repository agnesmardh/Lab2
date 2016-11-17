package geometri;

import java.awt.*;


public class Point extends GeometricalObject {

    /**
     * Creates a point
     *
     * @param x position, x direction
     * @param y position, y direction
     * @param c the color of the point
     * @throws IllegalPositionException
     */
    public Point(int x, int y, Color c) throws IllegalPositionException {
        if(x < 0 || y < 0) {
            throw new IllegalPositionException("Negative values");
        }
        this.x = x;
        this.y = y;
        this.c = c;
        area = 0;
        perimeter = 0;
    }

    /**
     * Creates a point
     *
     * @param f the position
     * @param c the color of the point
     */
    public Point(GeometricalForm f, Color c) {
        this.x = f.getX();
        this.y = f.getY();
        area = 0;
        perimeter = 0;
    }

    /**
     * {@inheritDoc}
     */
    public void fill(Graphics g) {
        g.setColor(c);
        g.drawOval(x, y, 1, 1);
    }

    /**
     * Indicates whether some other object is equal to this one.
     *
     * @param o The object with which to compare.
     * @return true if equal, false otherwise
     */
    @Override
    public boolean equals(Object o) {
        if(!(o instanceof Point)) {
            return false;
        }
        return true;
    }

}
