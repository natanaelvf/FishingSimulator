/**
 * A fish bucket is a device used to store fish, which organizes it by fish
 * name. It can store any number of different fish.
 * 
 * @author fc
 *
 */
public interface FishBucketInterface {
    /**
     * Add the fish to the bucket
     *
     * @param f the fish to be added to the bucket
     */
    void addFish(Fish f);

    /**
     * Returns the weight of a fish in the bucket
     * 
     * @param f the fish whose weight is to be returned
     * @return the weight of f in the bucket
     */
    double getFishWeight(Fish f);

    /**
     * Returns the total weight of fish in the bucket
     * 
     * @return the total weight of fish in the bucket
     */
    double totalWeight();

    /**
     * Removes all fish f from the bucket
     * 
     * @param f
     */
    void removeFish(Fish f);

    /**
     * Computes the total value of the bucket given prices per unit of weight
     * 
     * @param prices
     * @return
     */
    double bucketValue(FishPrices prices);

    @Override
    String toString();
}
