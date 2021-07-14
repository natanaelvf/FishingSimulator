/**
 * A fishing boat should have a FishingBucket to store the fish caught during
 * the fishing trip, as well as be able to decide where to go, or decide to fish
 * at any given point.
 * 
 * @author fc
 *
 */
public interface FishingBoatInterface {

    /**
     * Returns the bucket on the boat
     * 
     * @return the bucket on the boat
     */
    FishBucket getBucket();

    /**
     * Decides which action to do at a certain moment. The action could be to move
     * UP, DOWN, LEFT or RIGHT, to FISH, or to end your trip.
     * 
     * @return the next action the boat decides to make
     */
    BoatAction nextMove();

    /**
     * Adds a fish to the bucket on the boat
     * 
     * @param f the fish to be added to the bucket
     */
    void addFish(Fish f);
}
