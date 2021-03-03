import java.util.Stack;

public class jcy_lc439 {
    public String parseTernary(String expression) {
        Stack<Character> stack = new Stack<>();
        int len = expression.length();
        stack.push(expression.charAt(len - 1));
        for (int i = len - 3; i >= 0; i -= 2) {
            if (expression.charAt(i + 1) == '?') {
                char t = stack.pop(), f = stack.pop();
                stack.push(expression.charAt(i) == 'T' ? t : f);
            } else stack.push(expression.charAt(i));
        }
        return String.valueOf(stack.peek());
    }
}