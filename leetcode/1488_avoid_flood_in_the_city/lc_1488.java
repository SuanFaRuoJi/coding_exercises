import java.util.HashMap;
import java.util.TreeSet;

public class lc_1488 {
    public int[] avoidFlood(int[] rains) {
        int[] result = new int[rains.length];
        TreeSet<Integer> store = new TreeSet<>();
        HashMap<Integer, Integer> water = new HashMap<>();
        for (int i=0; i<rains.length; i++) {
            int cur = rains[i];
            if (cur == 0) {
                store.add(i);
            } else {
                result[i] = -1;
                if (water.containsKey(cur)) {
                    Integer next = store.ceiling(water.get(cur));
                    if (next == null) {
                        return new int[]{};
                    }
                    result[next] = cur;
                    store.remove(next);
                }
                water.put(cur, i);
            }
        }
        return result;
    }
}
