import java.util.HashMap;
import java.util.Map;

public class lc_1197 {
    public int minKnightMoves(int x, int y) {
        Map<Integer, Integer> memory = new HashMap<>();
        return backtrack(x, y, memory);
    }

    private int backtrack(int x, int y, Map<Integer, Integer> memory) {
        if (x == 0 && y == 0) {
            return 0;
        }
        if (memory.containsKey(hash(x, y))) {
            return memory.get(hash(x, y));
        }
        int distance = x*x + y*y;
        if (distance <= 5) {
            int manhattan = Math.abs(x) + Math.abs(y);
            if (manhattan == 3) {
                memory.put(hash(x, y), 1);
                return 1;
            } else {
                if (manhattan == 2) {
                    memory.put(hash(x, y), 2);
                    return 2;
                } else {
                    memory.put(hash(x, y), 3);
                    return 3;
                }
            }
        }
        int minimum = Integer.MAX_VALUE;
        for (int i=-1; i<=1; i+=2) {
            for (int j=-1; j<=1; j+=2) {
                int new_x = x + 1 * i, new_y = y + 2 * j;
                int new_distance = new_x * new_x + new_y * new_y;
                if (new_distance <= distance) {
                    int step = 1 + backtrack(new_x, new_y, memory);
                    minimum = Math.min(minimum, step);
                }
                new_x = x + 2 * i; new_y = y + 1 * j;
                new_distance = new_x * new_x + new_y * new_y;
                if (new_distance <= distance) {
                    int step = 1 + backtrack(new_x, new_y, memory);
                    minimum = Math.min(minimum, step);
                }
            }
        }
        memory.put(hash(x, y), minimum);
        return minimum;
    }

    int hash(int x, int y) {
        return x * 1000 + y;
    }
}
