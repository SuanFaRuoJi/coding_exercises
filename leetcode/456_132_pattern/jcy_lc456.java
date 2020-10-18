import java.util.Stack;

public class jcy_lc456 {
    public boolean find132pattern(int[] nums) {
        int n = nums.length;
        if (n < 3) return false;
        Stack<Integer> stack = new Stack<>();
        int[] min = new int[n];
        min[0] = nums[0];
        for (int i = 1; i < n; i++)
            min[i] = Math.min(min[i - 1], nums[i]);
        for (int i = n - 1; i >= 0; i--) {
            if (nums[i] > min[i]) {
                while (!stack.empty() && stack.peek() <= min[i])
                    stack.pop();
                if (!stack.empty() && stack.peek() < nums[i])
                    return true;
                stack.push(nums[i]);
            }
        }
        return false;
    }
}