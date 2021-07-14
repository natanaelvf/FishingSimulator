import java.util.Scanner;
import java.util.concurrent.TimeUnit;

/**
 * This simulator is able to simulate both human controlers providing input via
 * the stdin, or a self-driving fishing boat. The boat is placed in a random map
 * and either the boat or the human controler should attempt to fish all the
 * fish in the map in the least amount of steps.
 * 
 * @author fc
 *
 */
public class Simulator {

    private int mapSize;
    private Scanner sc;
    private SeaMap map;
    private FishingBoat boat;
    private FishPrices prices;
    private boolean isHuman;

    public Simulator(boolean isHuman, int mapSize, int numFish) {
        if (isHuman) {
            sc = new Scanner(System.in);
        }
        this.isHuman = isHuman;
        this.mapSize = mapSize;
        map = new SeaMap(mapSize, numFish);
        boat = new FishingBoat(map.getFishLocations(), map.getBoatLocation());
        prices = new FishPrices();

        // add a gourmet price to codfish
        Fish codFish = new Fish("COD", 1);
        prices.addFishPrice(codFish, 3.0);
    }

    /**
     * Simulates a fishing trip. At each turn, ask for a decision from the
     * boat/human controler, and perform the required action. When the boat/human
     * controler decide that the trip has ended, prints the total amount obtained
     * from the fishing trip, as well as the number of actions made.
     * 
     * @return number of performed actions
     * @throws InterruptedException
     */
    public int simulate() throws InterruptedException {
        BoatAction action = null;
        int actionsCount = 0;
        while (action != BoatAction.END_TRIP) {
            // sleep 50 ms to slow down and be able to visualize the simulation
            TimeUnit.MILLISECONDS.sleep(50);
            printWorld(map, boat);
            System.out.println("Chose one: [U]p, [D]own, [R]ight, [L]eft, [F]ish, [E]nd Trip");
            if (isHuman) {
                action = BoatAction.fromString(sc.nextLine());
            } else {
                action = boat.nextMove();
            }
            switch (action) {
            case UP:
                map.moveBoat(0, -1);
                break;
            case DOWN:
                map.moveBoat(0, 1);
                break;
            case RIGHT:
                map.moveBoat(1, 0);
                break;
            case LEFT:
                map.moveBoat(-1, 0);
                break;
            case FISH:
                Fish f = map.goFish();
                if (f != null) {
                    System.out.println("Caught " + f);
                    boat.addFish(f);
                } else {
                    System.out.println("Unlucky...");
                }
                break;
            case END_TRIP:
                break;
            default:
                System.out.println("Unknown option.");
                break;
            }
            // align text
            if (action != BoatAction.FISH) {
                System.out.println();
            }
            actionsCount++;
        }

        System.out.println("You got " + (boat.getBucket().bucketValue(prices)
                * 100d) / 100d + "$ worth of fish!");
        System.out.println("Used " + actionsCount + " actions.");

        return actionsCount;
    }

    /**
     * Prints the map, the boat and the fish currently on the map, as well as the
     * contents of the bucket on the boat.
     * 
     * @param map  the map to be displayed
     * @param boat the boat being used
     */
    public void printWorld(SeaMap map, FishingBoat boat) {
        StringBuilder sb = new StringBuilder();
        Pair boatLocation = map.getBoatLocation();
        StringBuilder separator = new StringBuilder("=");
        for (int y = 0; y < mapSize; y++) {
            for (int x = 0; x < mapSize; x++) {
                if (boatLocation.getX() == x && boatLocation.getY() == y) {
                    // boat emoji
                    sb.append("B");
                } else if (map.hasFish(x, y)) {
                    // fish emoji
                    sb.append("F");
                } else {
                    sb.append("  ");
                }
            }
            sb.append('\n');
            separator.append("==");
        }
        System.out.println(separator.toString());
        System.out.println(sb.toString());
        System.out.println("Current bucket:" + boat.getBucket());
    }
}
