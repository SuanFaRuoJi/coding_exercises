public class jcy_lc485 {
    public int findMaxConsecutiveOnes(int[] nums) {
        int res = 0, cur = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                cur += 1;
                res = Math.max(res, cur);
            } else cur = 0;
        }
        return res;
    }
}