import java.util.Arrays;

public class jcy_lc719 {
    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length, left = 0, right = nums[n - 1] - nums[0];
        while (left < right) {
            int mid = left + (right - left) / 2;
            int count = 0, i = 0;
            for (int j = 0; j < n; j++) {
                while (nums[j] - nums[i] > mid) i += 1;
                count += j - i;
            }
            if (count < k) left = mid + 1;
            else right = mid;
        }
        return left;
    }
}