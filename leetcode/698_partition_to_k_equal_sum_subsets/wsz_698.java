public class wsz_698 {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        boolean[] visit = new boolean[nums.length];
        int sum = 0;
        for (int i=0; i<nums.length; i++) {
            sum += nums[i];
        }
        if (sum % k != 0) {
            return false;
        }
        return backtrack(sum/k, k, 0, 0, visit, nums);
    }

    private boolean backtrack(int sum, int k, int cur, int start, boolean[] visit, int[] nums) {
        if (k == 1) {
            return true;
        }

        for (int i=start; i<nums.length; i++) {
            int new_sum = cur + nums[i];
            if (visit[i] || new_sum > sum) {
                continue;
            }
            visit[i] = true;
            boolean satisfy = new_sum % sum == 0;
            if (backtrack(sum, satisfy ? k-1 : k, new_sum % sum, satisfy ? 0 : i+1, visit, nums)) {
                return true;
            }
            visit[i] = false;
        }
        return false;
    }
}
