class Solution {
    public int missingElement(int[] nums, int k) {
        int l = 0, r = nums.length-1;
        int init_diff = diff(nums, r);
        if (init_diff < k) {
            return nums[r] + (k - init_diff);
        }

        while (l+1 < r) {
            int mid = (l+r) / 2;
            int cur_diff = diff(nums, mid);
            if (cur_diff >= k) {
                r = mid;
            } else {
                l = mid;
            }
        }

        return nums[l] + k - diff(nums, l);
    }

    private int diff(int[] nums, int r) {
        return nums[r] - nums[0] - (r - 0);
    }
}