package generators;

import java.util.Random;

public class BombPositionGenerator {
    public static int[] getRandomFrom64() {
        return new Random().ints(10, 1, 64).distinct().toArray();
    }
}
