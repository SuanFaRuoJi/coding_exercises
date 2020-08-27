public class chengyou_lc169 {
    public int majorityElement(int[] nums) {
        int count = 1, candidate = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (count == 0) {
                candidate = nums[i];
                count += 1;
            } else if (candidate == nums[i]) {
                count += 1;
            } else {
                count -= 1;
            }
        }
        return candidate;
    }
}