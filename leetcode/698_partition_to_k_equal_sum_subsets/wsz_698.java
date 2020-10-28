public class wsz_698 {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0;
        for(int num: nums) sum+=num;
        if (nums.length<k || sum%k!=0) return false;
        boolean[] visit = new boolean[nums.length];
        return backtrack(nums, sum/k, 0, visit, 0, k);
    }

    public boolean backtrack(int[] nums, int t, int sum, boolean[] visit, int s, int k) {
        if (k==1) {
            return true;
        }

        if (sum>t) {
            return false;
        }

        if (sum==t) {
            return backtrack(nums, t, 0, visit, 0, k-1);
        }

        for(int i=s; i<nums.length; i++) {
            if (!visit[i]) {
                visit[i] = true;
                if (backtrack(nums, t, sum+nums[i], visit, i+1, k)){
                    return true;
                }
                visit[i] = false;
            }
        }

        return false;
    }
}
