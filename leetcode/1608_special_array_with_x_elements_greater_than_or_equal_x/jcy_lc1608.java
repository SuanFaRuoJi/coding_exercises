import java.util.Arrays;

public class jcy_lc1608 {
    public int specialArray(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int x = n - i;
            if (nums[i] >= x && (i == 0 || nums[i - 1] < x))
                return x;
        }
        return -1;
    }
}