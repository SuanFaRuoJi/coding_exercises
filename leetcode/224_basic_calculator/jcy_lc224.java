import java.util.Stack;

public class jcy_lc224 {
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        int num = 0, res = 0, sign = 1;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c))
                num = num * 10 + Integer.parseInt(String.valueOf(c));
            else if (c == '+') {
                res += sign * num;
                sign = 1;
                num = 0;
            } else if (c == '-') {
                res += sign * num;
                sign = -1;
                num = 0;
            } else if (c == '(') {
                stack.push(res);
                stack.push(sign);
                sign = 1;
                res = 0;
            } else if (c == ')') {
                res += sign * num;
                res *= stack.pop();
                res += stack.pop();
                num = 0;
            }
        }
        return res + (sign * num);
    }
}