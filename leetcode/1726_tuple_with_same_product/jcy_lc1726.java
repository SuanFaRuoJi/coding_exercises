import java.util.HashMap;
import java.util.Map;

public class jcy_lc1726 {
    public int tupleSameProduct(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int prod = nums[i] * nums[j];
                map.put(prod, map.getOrDefault(prod, 0) + 1);
            }
        }
        int res = 0;
        for (int key : map.keySet()) {
            int val = map.get(key);
            res += val * (val - 1) * 4;
        }
        return res;
    }
}