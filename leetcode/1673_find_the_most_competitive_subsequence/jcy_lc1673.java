import java.util.Stack;

public class jcy_lc1673 {
    public int[] mostCompetitive(int[] nums, int k) {
        int[] res = new int[k];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < nums.length; i++) {
            while (!stack.empty() && nums[stack.peek()] > nums[i] && nums.length - i + stack.size() > k)
                stack.pop();
            if (stack.size() < k) stack.push(i);
        }
        for (int i = k - 1; i >= 0; i--) res[i] = nums[stack.pop()];
        return res;
    }
}