
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 * Represents a map of the sea, which includes the locations of the fish, the
 * location of the boat, and ways to move the boat and to catch the fish.
 * 
 * @author fc
 *
 */
public class SeaMap {
    private HashSet<Pair> fishSet;
    private int mapSize;
    private Pair boatLocation;
    private Random rng;

    /**
     * Creates a random map with a number of fish in random positions, and the boat
     * in a random position on the map.
     * 
     * @param mapSize      the size of the square map
     * @param numberOfFish the number of fish on the map
     */
    public SeaMap(int mapSize, int numberOfFish) {
        this.mapSize = mapSize;
        rng = new Random();
        fishSet = new HashSet<>();
        while (fishSet.size() != Math.min(mapSize * mapSize, numberOfFish)) {
            fishSet.add(new Pair(rng.nextInt(mapSize), rng.nextInt(mapSize)));
        }
        boatLocation = new Pair(rng.nextInt(mapSize), rng.nextInt(mapSize));
    }

    /**
     * Returns true iff there is a fish on a given position
     * 
     * @param x the x coordinate
     * @param y the y coordinate
     * @return true if there is a fish on the (x,y) position of the map.
     */
    public boolean hasFish(int x, int y) {
        return fishSet.contains(new Pair(x, y));
    }

    /**
     * Returns the size of the current map
     * 
     * @return the size of the current map
     */
    public int getMapSize() {
        return mapSize;
    }

    /**
     * Returns a set with the locations of the fish
     * 
     * @return the locations of the fish
     */
    public Set<Pair> getFishLocations() {
        return fishSet;
    }

    /**
     * Returns the boat location
     * 
     * @return the boat location
     */
    public Pair getBoatLocation() {
        return boatLocation;
    }

    /**
     * Attempts to fish on the current boat location. It will suceed if there are
     * fish on these coordinates, returning a fish. If there are no fish at those
     * coordinates, returns null.
     * 
     * @return a fish if there are fish on the current boat coordinates, null
     *         otherwise
     */
    public Fish goFish() {
        Fish f = null;
        if (fishSet.contains(boatLocation)) {
            f = FishInterface.randomFish(rng);
            fishSet.remove(boatLocation);
        }
        return f;
    }

    /**
     * Moves the boat dx units in the x axis, and dy units in the y axis. When the
     * boat moves against the edge of the map, it will appear on the opposite side
     * (like in a game of snake).
     * 
     * @param dx units to move in the x axis
     * @param dy units to move in the y axis
     */
    public void moveBoat(int dx, int dy) {
        boatLocation.setX(Math.floorMod(boatLocation.getX() + dx, mapSize));
        boatLocation.setY(Math.floorMod(boatLocation.getY() + dy, mapSize));
    }

}
