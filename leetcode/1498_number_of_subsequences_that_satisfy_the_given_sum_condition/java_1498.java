import java.util.Arrays;

public class java_1498 {
    private static final int mod = 1000000007;

    public int numSubseq(int[] nums, int target) {
        Arrays.sort(nums);
        int[] pows = new int[nums.length];
        pows[0] = 1;
        for (int i=1; i<pows.length; i++) {
            pows[i] = pows[i-1] * 2 % mod;
        }
        int result = 0;
        int j = nums.length-1;
        for (int i=0; i<nums.length; i++) {
            while (j >= i && nums[i] + nums[j] > target) {
                j--;
            }
            if (j>=i) {
                result = (result + pows[j-i]) % mod;
            } else {
                break;
            }
        }
        return result;
    }
}
