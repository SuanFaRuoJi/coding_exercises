public class jcy_lc410_optimal {
    public int splitArray(int[] nums, int m) {
        int max = 0, sum = 0;
        for (int n : nums) {
            max = Math.max(max, n);
            sum += n;
        }
        if (m == 1) return sum;
        int left = max - 1, right = sum;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (countSplits(nums, mid) > m) left = mid;
            else right = mid;
        }
        return right;
    }

    private int countSplits(int[] nums, int maxSum) {
        int res = 1, curSum = 0;
        for (int i = 0; i < nums.length; i++) {
            curSum += nums[i];
            if (curSum > maxSum) {
                res += 1;
                curSum = nums[i];
            }
        }
        return res;
    }
}