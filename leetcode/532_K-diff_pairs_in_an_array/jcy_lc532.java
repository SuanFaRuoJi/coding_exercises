import java.util.HashMap;
import java.util.Map;

public class jcy_lc532 {
    public int findPairs(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int res = 0;
        for (int n : nums) map.put(n, map.getOrDefault(n, 0) + 1);
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (k == 0) {
                if (entry.getValue() >= 2) res += 1;
            } else {
                if (map.containsKey(entry.getKey() + k)) res += 1;
            }
        }
        return res;
    }
}