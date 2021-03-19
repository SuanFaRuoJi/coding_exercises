import java.util.Stack;

public class jcy_lc32_2 {
    public int longestValidParentheses(String s) {
        int res = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') stack.push(i);
            else {
                stack.pop();
                if (stack.empty()) stack.push(i);
                else res = Math.max(res, i - stack.peek());
            }
        }
        return res;
    }
}
