import java.util.Stack;

public class jcy_lc1544 {
    public String makeGood(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = s.length() - 1; i >= 0; i--) {
            if (!stack.empty() && Math.abs(s.charAt(i) - stack.peek()) == 32) stack.pop();
            else stack.push(s.charAt(i));
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.empty()) sb.append(stack.pop());
        return sb.toString();
    }
}