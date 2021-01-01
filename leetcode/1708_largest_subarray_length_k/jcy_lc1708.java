public class jcy_lc1708 {
    public int[] largestSubarray(int[] nums, int k) {
        int[] res = new int[k];
        int maxIdx = -1, curMax = 0;
        for (int i = 0; i <= nums.length - k; i++) {
            if (nums[i] > curMax) {
                curMax = nums[i];
                maxIdx = i;
            }
        }
        for (int i = 0; i < k; i++) res[i] = nums[maxIdx++];
        return res;
    }
}