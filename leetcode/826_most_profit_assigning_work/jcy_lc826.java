import java.util.TreeMap;

public class jcy_lc826 {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        int res = 0, best = 0; // Stores the best profit less than or equal to current difficulty
        TreeMap<Integer, Integer> map = new TreeMap<>();
        map.put(0, 0); // Avoid NullPointerException if a worker cannot complete any job
        for (int i = 0; i < difficulty.length; i++)
            map.put(difficulty[i], Math.max(profit[i], map.getOrDefault(difficulty[i], 0)));
        for (int key : map.keySet()) {
            best = Math.max(map.get(key), best);
            map.put(key, best);
        }
        for (int i = 0; i < worker.length; i++)
            res += map.floorEntry(worker[i]).getValue();
        return res;
    }
}