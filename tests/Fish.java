import java.util.Random;

public class Fish implements FishInterface{
    
    // The name of the fish
    private String name;
    // The weight of the fish
    private double weight;

    public Fish(String name, double weight) {
        this.name = name;
        this.weight = weight;
    }
    
    public Fish randomFish(Random rng) {
        String[] fishNames = { "SARDINE", "MACKEREL", "COD", "SEABASS", "SALMON" };
        String designation = fishNames[rng.nextInt(fishNames.length)];
        return new Fish(designation, (double) ((int) (rng.nextDouble() * 1000)) / 100);
    }

    @Override
    public String getDesignation() {
        return this.name;
    }

    @Override
    public double getWeight() {
        return this.weight;
    }

    @Override
    public boolean equals(Object fish) {
        if (fish == null || this.getClass() != fish.getClass()) {
            return false;
        }
        return ((Fish) fish).hashCode() == this.name.hashCode();
    }
    
    @Override
    public int hashCode() {
        return this.name.hashCode();
    }
    
    @Override
    public String toString() {
     // É usado Math.round para arredondar o resultado para 2 casas decimais
        return (Math.round((this.weight * 100d) / 100d)) + "kg of " + this.name;
    }
}
