import java.util.Stack;

public class jcy_lc255 {
    public boolean verifyPreorder(int[] preorder) {
        int lowBound = Integer.MIN_VALUE;
        Stack<Integer> stack = new Stack<>();
        for (int num : preorder) {
            if (num < lowBound) return false;
            while (!stack.empty() && num > stack.peek())
                lowBound = stack.pop();
            stack.push(num);
        }
        return true;
    }
}