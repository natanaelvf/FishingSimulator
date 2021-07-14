public class Main {

    public static void main(String[] args) throws InterruptedException {

        // length of the size of the map
        int mapSize = 10;
        // number of fish to put on the map
        int numFish = 15;

        // self driving boat simulation
        Simulator sBot = new Simulator(false, mapSize, numFish);
        sBot.simulate();

        // this simulation is controled via standard input commands
        // Simulator sHuman = new Simulator(true, mapSize, numFish);
        // sHuman.simulate();
    }

}
