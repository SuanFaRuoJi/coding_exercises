public class jcy_lc1658 {
    public int minOperations(int[] nums, int x) {
        int sum = 0;
        for (int n : nums) sum += n;
        int left = 0, right = 0, curr = 0, max = -1;
        while (right < nums.length) {
            curr += nums[right];
            while (curr > sum - x && left <= right) {
                curr -= nums[left];
                left += 1;
            }
            if (curr == sum - x) max = Math.max(max, right - left + 1);
            right += 1;
        }
        return max != -1 ? nums.length - max : -1;
    }
}