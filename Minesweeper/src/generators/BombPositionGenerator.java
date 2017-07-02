package generators;

import java.util.Random;

public class BombPositionGenerator {
    public static int[] getRandomFrom64() {
        int[] bombs = new Random().ints(20, 1, 64).distinct().limit(10).toArray();
        for (int i = 0; i < bombs.length; i++) {
            System.out.println(bombs[i]);
        }
        return bombs;
    }
}
