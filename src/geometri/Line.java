package geometri;

import java.awt.*;


public class Line extends GeometricalObject {
    private int x2;
    private int y2;

    /**
     * Creates a line
     *
     * @param x1 initial value, x direction
     * @param y1 initial value, y direction
     * @param x2 end value, x direction
     * @param y2 end value, y direction
     * @param c The color of the line
     * @throws IllegalPositionException if the values are negative.
     */
    public Line(int x1, int y1, int x2, int y2, Color c) throws IllegalPositionException {
        if(x1 < 0 || x2 < 0 || y1 < 0 || y2 < 0) {
            throw new IllegalPositionException("Negative values");
        }
        this.x = x1;
        this.x2 = x2;
        this.y = y1;
        this.y2 = y2;
        this.c = c;
        area = 0;
        perimeter = (int) Math.sqrt(Math.pow((x2-x),2) + Math.pow((y2-y),2));
    }

    /**
     * Creates a line
     *
     * @param f1 starting point
     * @param f2 end point
     * @param c The color of the line
     */
    public Line(GeometricalForm f1, GeometricalForm f2, Color c) {
        this.x = f1.getX();
        this.x2 = f2.getX();
        this.y = f1.getY();
        this.y2 = f2.getY();
        this.c = c;
        area = 0;
        perimeter = (int) Math.sqrt(Math.pow((x2-x),2) + Math.pow((y2-y),2));
    }

    /**
     * {@inheritDoc}
     *
     */
    public void fill(Graphics g) {
        g.setColor(c);
        g.drawLine(x, y, x2, y2);
    }

    /**
     * Indicates whether some other object is equal to this one.
     *
     * @param o The object with which to compare.
     * @return true if equal, false otherwise
     */
    @Override
    public boolean equals(Object o) {
        if(!(o instanceof Line)) {
            return false;
        } else if(this.perimeter != ((Line) o).perimeter) {
            return false;
        }
        return true;
    }

}
