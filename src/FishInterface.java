import java.util.Random;

public interface FishInterface {
    /**
     * Creates a random fish
     * 
     * @param rng randomness source
     * @return a randomly created fish
     */
    static Fish randomFish(Random rng) {
        String[] fishNames = { "SARDINE", "MACKEREL", "COD", "SEABASS", "SALMON" };
        String designation = fishNames[rng.nextInt(fishNames.length)];
        return new Fish(designation, (double) ((int) (rng.nextDouble() * 1000)) / 100);
    }

    /**
     * Get the fish designation
     * 
     * @return the fish designation
     */
    String getDesignation();

    /**
     * Get the fish weight
     * 
     * @return the fish weight
     */
    double getWeight();

    /**
     * Two fish are considered equal when their designation is equal.
     * 
     * @param o
     * @return
     */
    @Override
    boolean equals(Object o);

    @Override
    int hashCode();

    @Override
    String toString();
}
