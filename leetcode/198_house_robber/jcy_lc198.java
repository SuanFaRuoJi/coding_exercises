public class jcy_lc198 {
    public int rob(int[] nums) {
        int prev = 0, curr = 0;
        for (int n : nums) {
            int temp = curr;
            curr = Math.max(prev + n, curr);
            prev = temp;
        }
        return curr;
    }
}