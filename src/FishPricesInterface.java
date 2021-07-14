/**
 * Fish prices is able to store a fish with its price. It is also possible to
 * consult the price of any fish.
 * 
 * @author fc
 *
 */
public interface FishPricesInterface {
    /**
     * Adds a fish with a certain value to the FishPrices
     * 
     * @param f     the fish
     * @param price the price of the fish per weight
     */
    void addFishPrice(Fish f, double price);

    /**
     * Get the price of a certain fish. If this fish does not exist on the "menu",
     * the default price should be 1.0
     * 
     * @param f the fish to know the price of
     * @return the price of the fish f if it exists, 1.0 otherwise
     */
    double getFishPrice(Fish f);
}
