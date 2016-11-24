package geometri;

import java.awt.*;


public class Line extends GeometricalObject {
    private int width;
    private int height;
    private boolean isCorner;

    /**
     * Creates a line and tells which way it goes
     *
     * @param x1 initial value, x direction
     * @param y1 initial value, y direction
     * @param x2 end value, x direction
     * @param y2 end value, y direction
     * @param c  The color of the line
     * @throws IllegalPositionException if the values are negative.
     */
    public Line(int x1, int y1, int x2, int y2, Color c) throws IllegalPositionException {
        if (x1 < 0 || x2 < 0 || y1 < 0 || y2 < 0) {
            throw new IllegalPositionException("Negative values");
        }
        this.x = Math.min(x1, x2);
        this.y = Math.min(y1, y2);
        if (x1 > x2) {
            width = x1 - x2;
        } else {
            width = x2 - x1;
        }
        if (y1 > y2) {
            height = y1 - y2;
        } else {
            height = y2 - y1;
        }
        if (x == x1 && y == y1 || x == x2 && y == y2) {
            isCorner = true;
        }
        this.c = c;
        area = 0;
        perimeter = (int) Math.sqrt(Math.pow((x2 - x), 2) + Math.pow((y2 - y), 2));
    }

    /**
     * Creates a line and tells which way it goes
     *
     * @param f1 starting point
     * @param f2 end point
     * @param c  The color of the line
     */
    public Line(GeometricalForm f1, GeometricalForm f2, Color c) {
        this.x = Math.min(f1.getX(), f2.getX());
        this.y = Math.min(f1.getY(), f2.getY());
        if (f2.getX() > f1.getX()) {
            width = f2.getX() - f1.getX();
        } else {
            width = f1.getX() - f2.getX();
        }
        if (f2.getY() > f1.getY()) {
            height = f2.getY() - f1.getY();
        } else {
            height = f1.getY() - f2.getY();
        }

        if (x == f1.getX() && y == f1.getY() || x == f2.getX() && y == f2.getY()) {
            isCorner = true;
        }

        this.c = c;
        area = 0;
        perimeter = (int) Math.sqrt(Math.pow((width), 2) + Math.pow((height), 2));
    }

    /**
     * {@inheritDoc}
     */
    public void fill(Graphics g) {
        g.setColor(c);
        if (isCorner) {
            g.drawLine(x, y, x + width, y + height);
        } else {
            g.drawLine(x, y + height, x + width, y);
        }
    }

    /**
     * Indicates whether some other object is equal to this one.
     *
     * @param o The object with which to compare.
     * @return true if equal, false otherwise
     */
    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Line)) {
            return false;
        } else if (this.perimeter != ((Line) o).perimeter) {
            return false;
        }
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int hashCode() {
        return 5 * perimeter;
    }

}
