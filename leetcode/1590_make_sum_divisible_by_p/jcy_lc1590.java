import java.util.HashMap;
import java.util.Map;

public class jcy_lc1590 {
    public int minSubarray(int[] nums, int p) {
        int n = nums.length, res = n, mod = 0, cur = 0;
        for (int num : nums) mod = (mod + num) % p;
        if (mod == 0) return 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        for (int i = 0; i < n; ++i) {
            cur = (cur + nums[i]) % p;
            map.put(cur, i);
            int target = (cur - mod + p) % p;
            if (map.containsKey(target))
                res = Math.min(res, i - map.get(target));
        }
        return res < n ? res : -1;
    }
}