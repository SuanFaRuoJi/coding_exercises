public class jcy_lc487 {
    public int findMaxConsecutiveOnes(int[] nums) {
        int res = 0, count = 0, i = 0, j = 0;
        while (j < nums.length) {
            if (nums[j] == 0) count += 1;
            while (count > 1) {
                if (nums[i] == 0) count -= 1;
                i += 1;
            }
            res = Math.max(res, j - i + 1);
            j += 1;
        }
        return res;
    }
}