public class jcy_lc1646 {
    public int getMaximumGenerated(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        int[] nums = new int[n + 1];
        nums[1] = 1;
        int res = 1;
        for (int i = 1; i <= n / 2; i++) {
            nums[i * 2] = nums[i];
            if (i * 2 + 1 <= n) {
                nums[i * 2 + 1] = nums[i] + nums[i + 1];
                res = Math.max(res, nums[i * 2 + 1]);
            }
        }
        return res;
    }
}