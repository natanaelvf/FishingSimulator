import java.util.Set;

public class FishingBoat implements FishingBoatInterface {

    private Set<Pair> fishLocations;

    private Pair boatLocation;

    private FishBucket fishBucket;

    /* "revelar" esta variável e a condição no método nextMove()
     * para obter uma contagem dos peixes que faltam apanhar 
     * private int fishCount = 0; 
     */


    public FishingBoat(Set<Pair> fishLocations, Pair boatLocation) {
        this.fishLocations = fishLocations;
        this.boatLocation = boatLocation;
        this.fishBucket = new FishBucket();
    }

    public BoatAction nextMove() {
        // Precisamos de uma ação default
        BoatAction result = BoatAction.END_TRIP;

        /* Precisamos de guardar a localização do barco numa nova variável
         * para não a alterarmos
         */
        Pair boatL = new Pair(boatLocation.getX(), boatLocation.getY());

        /* Se houver peixes, procuramos o peixe mais próximo
         * e nadamos até lá
         */
        if (!fishLocations.isEmpty()) {
            Pair nearestFish = findNearestFish(boatL);
            result = swimThere(nearestFish);
        }

        /* if (result == BoatAction.FISH) count++;
         * System.out.println(fishCount + " of " + fishLocations.size());
         */ 

        return result;
    }
    
    /*
     * Distancia de Manhattan
     */

    /* Procura o peixe, utilizando a distância euclidiana
     * (raiz quadrada da soma do quadrado da distância do barco ao peixe)
     */
    private Pair findNearestFish(Pair boatL) {
        double lowestDistance = Integer.MAX_VALUE;
        Pair result = new Pair(0,0);

        for (Pair pair: fishLocations) {
            double absDistanceX = Math.abs(pair.getX() - boatL.getX());
            double absDistanceY = Math.abs(pair.getY() - boatL.getY());

            double currentDistance = Math.sqrt(absDistanceX*absDistanceX + 
                    absDistanceY*absDistanceY);

            if (lowestDistance > currentDistance) {
                lowestDistance = currentDistance;
                result.setX(pair.getX());
                result.setY(pair.getY());
            }
        }

        return result;
    }

    /* Aqui é que se encontra o algoritmo que dá "inteligência"
     * ao pescador. primeiro vemos a distância absoluta a que
     * o pescador se encontra do peixe, depois escolhemos a
     * direção em que ele tem de se deslocar, com base na
     * distância que tem de percorrer em cada eixo. A ordem
     * do eixo em que ele se desloca não importa.
     * 
     * NOTA IMPORTANTE: Foram utilizados vários returns
     * porque não é possível utilizar um switch com um boolean
     * do tipo que eu pretendo usar para tornar o barco inteligente
     * case distanceX > 0
     * case distanceY > 0
     */
    private BoatAction swimThere(Pair nearestFish) {

        int actualDistanceX = nearestFish.getX() - boatLocation.getX();
        int actualDistanceY = nearestFish.getY() - boatLocation.getY();

        int distanceX = Math.abs(actualDistanceX);
        int distanceY = Math.abs(actualDistanceY);

        // O Default é FISH, assim, se distanceX e distanceY == 0, pesca-se
        BoatAction result = BoatAction.FISH;

        if(actualDistanceX == 0 && actualDistanceY == 0) return result;

        if (distanceX > 0) {
            if (actualDistanceX < 0) {
                return BoatAction.LEFT;
            }
            if (actualDistanceY < 0) {
                return BoatAction.UP;
            }
            return BoatAction.RIGHT;
        }

        if (distanceY > 0) {
            if (actualDistanceX < 0) {
                return BoatAction.LEFT;
            }
            if (actualDistanceY < 0) {
                return BoatAction.UP;
            }
            return BoatAction.DOWN;
        }

        return result;
    }

    public void addFish(Fish f) {
        this.fishBucket.addFish(f);
    }

    public FishBucket getBucket() {
        return this.fishBucket;
    }
}
