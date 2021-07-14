/**
 * A class that represents a pair (x,y) of plane coordinates
 *
 * @author LabP
 */
public class Pair {

    private int x;
    private int y;

    /**
     * Constructor
     *
     * @param x The x coordinate
     * @param y The y coordinate
     */
    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Get the x coordinate
     * 
     * @return the x coordinate
     */
    public int getX() {
        return x;
    }

    /**
     * Get the y coordinate
     * 
     * @return the y coordinate
     */
    public int getY() {
        return y;
    }

    /**
     * Set the x coordinate
     * 
     * @param x the new x coordinate
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * Set the y coordinate
     * 
     * @param y the new y coordinate
     */
    public void setY(int y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return "Coords{" + "x=" + x + ", y=" + y + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        Pair pair = (Pair) o;

        return x == pair.x && y == pair.y;
    }

    @Override
    public int hashCode() {
        int result = x;
        result = 31 * result + y;
        return result;
    }
}
