import java.util.HashMap;

public class FishPrices implements FishPricesInterface {
    private HashMap<Fish, Double> prices;
    public FishPrices(){
        prices = new HashMap<>();
    }
    @Override
    public void addFishPrice(Fish f, double price) {
        prices.put(f, price);
    }
    @Override
    public double getFishPrice(Fish f) {
        return prices.getOrDefault(f, 1.0);
    }
}
