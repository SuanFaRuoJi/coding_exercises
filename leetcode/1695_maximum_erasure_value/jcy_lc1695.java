import java.util.HashSet;
import java.util.Set;

public class jcy_lc1695 {
    public int maximumUniqueSubarray(int[] nums) {
        int i = 0, j = 0, res = 0, cur = 0;
        Set<Integer> set = new HashSet<>();
        while (j < nums.length) {
            if (!set.contains(nums[j])) {
                cur += nums[j];
                set.add(nums[j]);
                res = Math.max(res, cur);
                j += 1;
            } else {
                cur -= nums[i];
                set.remove(nums[i]);
                i += 1;
            }
        }
        return res;
    }
}