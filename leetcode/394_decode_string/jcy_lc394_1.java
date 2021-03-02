import java.util.Stack;

public class jcy_lc394_1 {
    public String decodeString(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ']') {
                StringBuilder sb = new StringBuilder();
                while (stack.peek() != '[') sb.append(stack.pop());
                stack.pop();
                int num = 1, k = 0;
                while (!stack.empty() && Character.isDigit(stack.peek())) {
                    k += (stack.pop() - '0') * num;
                    num *= 10;
                }
                while (k != 0) {
                    for (int j = sb.length() - 1; j >= 0; j--)
                        stack.push(sb.charAt(j));
                    k -= 1;
                }
            } else stack.push(s.charAt(i));
        }
        char[] res = new char[stack.size()];
        for (int i = res.length - 1; i >= 0; i--) res[i] = stack.pop();
        return new String(res);
    }
}