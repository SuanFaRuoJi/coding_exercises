import java.util.HashMap;
import java.util.Map;

public class lc_1066 {
    public int assignBikes(int[][] workers, int[][] bikes) {
        Map<Integer, Integer> memory = new HashMap<>();
        return backtrack(workers, bikes, 0, memory, 0, Integer.MAX_VALUE);
    }

    private int backtrack(int[][] workers, int[][] bikes, int bitmask, Map<Integer, Integer> memory, int cur_sum, int global_min) {
        int cur = -1;
        if (cur_sum < global_min) {
            return cur_sum;
        }
        if (memory.containsKey(bitmask)) {
            return memory.get(bitmask);
        }
        for (int i=0; i<workers.length; i++) {
            int mask = 1 << i;
            if ((mask & bitmask) == 0) { // not assigned
                bitmask |= mask;
                cur = i;
                break;
            }
        }
        if (cur == -1) { // all assigned
            return 0;
        }
        int min = Integer.MAX_VALUE;
        for (int i=0; i<bikes.length; i++) {
            int mask = 1 << (i+10);
            if ((mask & bitmask) == 0) { // can use this bike
                bitmask |= mask;
                int dis = distance(workers[cur], bikes[i]);
                global_min = Math.min(global_min, min);
                    int cur_min = backtrack(workers, bikes, bitmask, memory, cur_sum + dis, global_min) + dis;
                    if (cur_min < min) {
                        min = cur_min;
                    }
                bitmask &= ~(mask);
            }
        }
        memory.put(bitmask, min);
        return min;
    }

    private int distance(int[] a, int [] b) {
        return Math.abs(a[0]-b[0]) + Math.abs(a[1]-b[1]);
    }
}
