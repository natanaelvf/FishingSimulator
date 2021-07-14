import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class FishingSimulatorTests {

    @Test
    void test1() {
        FishBucket bucket = new FishBucket();
        Fish sardinha = new Fish("sardinha", 0.5);
        bucket.addFish(sardinha);
        double delta = 0.01;
        assertEquals(0.5, bucket.getFishWeight(sardinha), delta);
    }

    @Test
    void test2() {
        FishBucket bucket = new FishBucket();
        Fish sardinha = new Fish("sardinha", 0.5);
        bucket.addFish(sardinha);
        bucket.addFish(sardinha);
        double delta = 0.01;
        assertEquals(1, bucket.getFishWeight(sardinha), delta);
    }

    @Test
    void test3() {
        FishBucket bucket = new FishBucket();
        Fish sardinha = new Fish("sardinha", 0.5);
        bucket.addFish(sardinha);
        bucket.removeFish(sardinha);
        double delta = 0.01;
        assertEquals(0.0, bucket.getFishWeight(sardinha), delta);
    }

    @Test
    void test4() {
        FishBucket bucket = new FishBucket();
        Fish sardinha = new Fish("sardinha", 0.5);
        bucket.removeFish(sardinha);
        double delta = 0.01;
        assertEquals(0.0, bucket.getFishWeight(sardinha), delta);
        assertEquals(0.0, bucket.totalWeight(), delta);
    }

    @Test
    void test5() {
        FishBucket bucket = new FishBucket();
        Fish sardinha = new Fish("sardinha", 0.5);
        Fish carapau = new Fish("carapau", 1);
        bucket.addFish(sardinha);
        bucket.addFish(carapau);
        double delta = 0.01;
        assertEquals(1.5, bucket.totalWeight(), delta);
    }

    @Test
    void test6() {
        FishBucket bucket = new FishBucket();
        FishPrices prices = new FishPrices();
        Fish sardinha = new Fish("sardinha", 0.5);
        Fish carapau = new Fish("carapau", 1);
        bucket.addFish(sardinha);
        bucket.addFish(carapau);
        double delta = 0.01;
        assertEquals(1.5, bucket.bucketValue(prices), delta);

        prices.addFishPrice(carapau, 2);
        assertEquals(2.5, bucket.bucketValue(prices), delta);
    }

    @Test
    void test7() {
        Simulator sim = new Simulator(false, 3, 9);
        try {
            assertEquals(true, sim.simulate() < 25);
        } catch (InterruptedException e) {
        }
    }

}
