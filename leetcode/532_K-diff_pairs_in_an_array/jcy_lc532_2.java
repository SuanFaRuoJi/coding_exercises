import java.util.Arrays;

public class jcy_lc532_2 {
    public int findPairs(int[] nums, int k) {
        Arrays.sort(nums);
        int res = 0, i = 0, j = 1, n = nums.length;
        while (i < n && j < n) {
            if (i == j || nums[j] - nums[i] < k) {
                j += 1;
            } else if (nums[j] - nums[i] > k) {
                i += 1;
            } else {
                i += 1;
                res += 1;
                while (i < n && nums[i] == nums[i - 1])
                    i += 1;
            }
        }
        return res;
    }
}