public class jcy_lc1752 {
    public boolean check(int[] nums) {
        int n = nums.length;
        if (n == 1 || n == 2) return true;
        int breakIdx = -1, cnt = 0;
        for (int i = 0; i < n - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                if (cnt != 0) return false;
                else {
                    breakIdx = i;
                    cnt += 1;
                }
            }
        }
        if (breakIdx == -1) return true;
        else if (nums[n - 1] > nums[0]) return false;
        return true;
    }
}