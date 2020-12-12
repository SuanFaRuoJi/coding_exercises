import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class jcy_lc15 {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i] > 0) break;
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int j = i + 1, k = nums.length - 1;
            int target = 0 - nums[i];
            while (j < k) {
                if (nums[j] + nums[k] == target) {
                    res.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    j += 1;
                    k -= 1;
                    while (j < k && nums[j] == nums[j - 1]) j += 1;
                    while (j < k && nums[k] == nums[k + 1]) k -= 1;
                } else if (nums[j] + nums[k] < target) {
                    j += 1;
                } else {
                    k -= 1;
                }
            }
        }
        return res;
    }
}