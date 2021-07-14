import java.util.HashMap;
import java.util.Map.Entry;

public class FishBucket implements FishBucketInterface {

    // Um balde é um HashMap com as espécies de peixe e o seu peso
    HashMap<Fish, Double> bucket;

    public FishBucket() {
        this.bucket = new HashMap<>();
    }
    
    /* Se já há peixes da mesma espécie no balde, 
     * adicionamos o seu peso ao peso da espécie,
     * senão, o peso da espécie no balde passa a ser
     * o valor do peso do peixe adicionado.
     */
    public void addFish(Fish sardinha) {
        Double previousValue;

        if(!bucket.containsKey(sardinha)) {
            previousValue = 0.0;
        } else {
            previousValue = bucket.get(sardinha);
        }
        
        double result = previousValue + sardinha.getWeight();
        bucket.put(sardinha, result);
    }

    public void removeFish(Fish sardinha) {
        this.bucket.remove(sardinha);
    }

    public double getFishWeight(Fish sardinha) {
        if (!bucket.containsKey(sardinha)) {
            return 0;
        }
        return bucket.get(sardinha);
    }

    /* Para obter o peso dos peixes, temos que somar o peso
     * de todas as espécies.
     */
    public double totalWeight() {
        double result = 0;

        for (Entry<Fish, Double> pair: bucket.entrySet()) {
            result += pair.getKey().getWeight();
        }
        return result;
    }
    
    /* Para calcular o valor de uma espécie de peixe no balde,
     * multiplicamos o seu preço pelo seu peso. Para calcular
     * o valor do balde, adicionamos o valor de todas as espécies.
     */
    public double bucketValue(FishPrices prices) {
        double price = 0;
        double weight = 0;
        double result = 0;

        for (Entry<Fish, Double> pair: bucket.entrySet()) {
            price = prices.getFishPrice(pair.getKey());
            weight = pair.getValue();
            result += price * weight;
        }
     // É usado Math.round para arredondar o resultado para 2 casas decimais
        return (Math.abs(result * 100d / 100d));
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("\n");
        for (Entry<Fish, Double> pair: bucket.entrySet()) {
         // É usado Math.round para arredondar o resultado para 2 casas decimais
            sb.append((double)Math.round(pair.getValue() * 100d) 
                        / 100d + "kg of " 
        + pair.getKey().getDesignation() + "\n");
        }
        return sb.append("\n").toString();
    }

}
