package geometri;

import java.awt.*;


public class Oval extends GeometricalObject {
    private int width;
    private int height;

    /**
     * Creates an oval
     *
     * @param x start value, x direction
     * @param y start value, y direction
     * @param width width of oval
     * @param height height of oval
     * @param c The color of the oval
     * @throws IllegalPositionException if values are negative
     */
    public Oval(int x, int y, int width, int height, Color c) throws IllegalPositionException {
        if(x < 0 || y < 0 || width < 0 || height < 0) {
            throw new IllegalPositionException("Negative values");
        }
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.c = c;
        area = (int) (Math.PI * width * height)/4;
        perimeter = (int) (Math.PI * Math.sqrt((2 * Math.pow(width, 2) + (2 * Math.pow(height, 2)))));
    }

    /**
     * Creates an oval
     *
     * @param f starting point
     * @param width width of the oval
     * @param height height of the oval
     * @param c the color of the oval
     */
    public Oval(GeometricalForm f, int width, int height, Color c) {
        this.x = f.getX();
        this.y = f.getY();
        this.width = width;
        this.height = height;
        this.c = c;
        area = (int) (Math.PI * width * height)/4;
        perimeter = (int) (Math.PI * Math.sqrt((2 * Math.pow(width, 2) + (2 * Math.pow(height, 2)))));
    }

    /**
     * {@inheritDoc}
     */
    public void fill(Graphics g) {
        g.setColor(c);
        g.fillOval(this.getX(), this.getY(), width, height);
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
        if(!(o instanceof Oval)) {
            return false;
        } else if(this.width != ((Oval) o).getWidth() || this.height != ((Oval) o).getHeight()) {
            return false;
        }
        return true;
    }

}
