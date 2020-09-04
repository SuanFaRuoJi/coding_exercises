import java.util.HashMap;
import java.util.Map;

public class SparseVector {
    Map<Integer, Integer> map = new HashMap<>();

    SparseVector(int[] nums) {
        for (int i = 0; i < nums.length; i++)
            if (nums[i] != 0) map.put(i, nums[i]);
    }

    public int dotProduct(SparseVector vec) {
        if (map.size() == 0 || vec.map.size() == 0) return 0;
        int res = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int index = entry.getKey();
            if (!vec.map.containsKey(index)) continue;
            else res += entry.getValue() * vec.map.get(index);
        }
        return res;
    }
}
