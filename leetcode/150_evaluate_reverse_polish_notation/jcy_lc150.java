import java.util.Stack;

public class jcy_lc150 {
    public int evalRPN(String[] tokens) {
        int first, second = 0;
        Stack<Integer> stack = new Stack<>();
        for (String s : tokens) {
            if (s.equals("+")) {
                second = stack.pop();
                first = stack.pop();
                stack.add(first + second);
            } else if (s.equals("-")) {
                second = stack.pop();
                first = stack.pop();
                stack.add(first - second);
            } else if (s.equals("*")) {
                second = stack.pop();
                first = stack.pop();
                stack.add(first * second);
            } else if (s.equals("/")) {
                second = stack.pop();
                first = stack.pop();
                stack.add(first / second);
            } else stack.add(Integer.parseInt(s));
        }
        return stack.pop();
    }
}