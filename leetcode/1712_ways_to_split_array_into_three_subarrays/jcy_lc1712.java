public class jcy_lc1712 {
    public int waysToSplit(int[] nums) {
        int n = nums.length, res = 0, j = 0, k = 0;
        for (int i = 1; i < n; i++) nums[i] += nums[i - 1];
        for (int i = 0; i < n - 2; i++) {
            while (j <= i || (j < n - 1 && nums[j] < nums[i] * 2)) j += 1;
            while (k < j || (k < n - 1 && nums[k] - nums[i] <= nums[n - 1] - nums[k])) k += 1;
            res = (res + k - j) % 1000000007;
        }
        return res;
    }
}
