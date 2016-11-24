package geometri;

import java.awt.*;
import java.awt.image.RenderedImage;

public class Rectangle extends GeometricalObject {
    private int width;
    private int height;

    /**
     * Creates a rectangle
     *
     * @param x      starting point, x direction
     * @param y      starting point, y direction
     * @param width  width of the rectangle
     * @param height height of the rectangle
     * @param c      the color of the rectangle
     * @throws IllegalPositionException if values are negative
     */
    public Rectangle(int x, int y, int width, int height, Color c) throws IllegalPositionException {
        if (x < 0 || y < 0 || width < 0 || height < 0) {
            throw new IllegalPositionException("Negative values");
        }
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.c = c;
        area = height * width;
        perimeter = 2 * height + 2 * width;
    }

    /**
     * Creates a rectangle
     *
     * @param f      starting point
     * @param width  width of rectangle
     * @param height height of rectangle
     * @param c      the color of the rectangle
     */
    public Rectangle(GeometricalForm f, int width, int height, Color c) {
        this.x = f.getX();
        this.y = f.getY();
        this.width = width;
        this.height = height;
        this.c = c;
        area = height * width;
        perimeter = 2 * (height) + 2 * (width);
    }

    /**
     * {@inheritDoc}
     */
    public void fill(Graphics g) {
        g.setColor(c);
        g.fillRect(x, y, width, height);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getHeight() {
        return height;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getWidth() {
        return width;
    }

    /**
     * Indicates whether some other object is equal to this one.
     *
     * @param o The object with which to compare.
     * @return true if equal, false otherwise
     */
    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Rectangle)) {
            return false;
        } else if (this.width != ((Rectangle) o).getWidth() || this.height != ((Rectangle) o).getHeight()) {
            return false;
        }
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int hashCode() {
        return 13 * width + height;
    }
}

