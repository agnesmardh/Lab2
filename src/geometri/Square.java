package geometri;

import java.awt.*;


public class Square extends GeometricalObject {
    private int side;

    /**
     * Creates a square
     *
     * @param x starting point, x direction
     * @param y starting point, y direction
     * @param side side of the square
     * @param c color of the square
     * @throws IllegalPositionException if values are negative
     */
    public Square(int x, int y, int side, Color c) throws IllegalPositionException {
        if(x < 0 || y < 0 || side < 0) {
            throw new IllegalPositionException("Negative values");
        }
        this.x = x;
        this.y = y;
        this.side = side;
        this.c = c;
        area = side * side;
        perimeter = 4 * side;
    }

    /**
     * Creates a square
     *
     * @param f starting point
     * @param side side of the square
     * @param c color of the square
     */
    public Square(GeometricalForm f, int side, Color c) {
        this.x = f.getX();
        this.y = f.getY();
        this.side = side;
        this.c = c;
        area = side * side;
        perimeter = 4 * side;
    }

    /**
     * {@inheritDoc}
     */
    public void fill(Graphics g) {
        g.setColor(c);
        g.fillRect(this.getX(), this.getY(), side, side);
    }

    /**
     * Gets the side of the square
     *
     * @return the side of the square
     */
    public int getSide() {
        return side;
    }

    /**
     * Indicates whether some other object is equal to this one.
     *
     * @param o The object with which to compare.
     * @return true if equal, false otherwise
     */
    @Override
    public boolean equals(Object o) {
        if(!(o instanceof Square)) {
            return false;
        } else if(this.side != ((Square) o).getSide()) {
            return false;
        }
        return true;
    }
}
