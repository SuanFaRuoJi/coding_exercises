public class jcy_lc213 {
    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0];
        return Math.max(rob1(nums), rob2(nums));
    }

    private int rob1(int[] nums){
        int prev = 0, curr = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            int temp = curr;
            curr = Math.max(prev + nums[i], curr);
            prev = temp;
        }
        return curr;
    }

    private int rob2(int[] nums){
        int prev = 0, curr = 0;
        for (int i = 1; i < nums.length; i++) {
            int temp = curr;
            curr = Math.max(prev + nums[i], curr);
            prev = temp;
        }
        return curr;
    }
}