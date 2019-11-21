public class lc_410 {
    public int splitArray(int[] nums, int m) {
        int l = nums.length, sum = 0, max = Integer.MIN_VALUE;
        for (int i=0; i<l; i++) {
            if (nums[i] > max) {
                max = nums[i];
            }
            sum += nums[i];
        }
        if (m == 1) {
            return sum;
        }
        int minimum = max, maximum = sum;
        while (minimum+1 < maximum) {
            int mid = (minimum + maximum) / 2;
            if (check(nums, m, mid)) {
                minimum = mid;
            }else {
                maximum = mid;
            }
        }
        return minimum;
    }

    private boolean check(int[] nums, int m, int K) {
        int l = nums.length, sum = 0, count = 1;
        for (int i=0; i<l; i++) {
            if (sum + nums[i] > K){
                sum = 0;
                count += 1;
            }
            sum += nums[i];
            if (count > m) {
                return false;
            }
        }
        return true;
    }
}
