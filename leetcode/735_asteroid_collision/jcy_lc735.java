import java.util.Stack;

public class jcy_lc735 {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        for (int cur : asteroids) {
            while (!stack.empty() && stack.peek() > 0 && cur < 0 && Math.abs(cur) > stack.peek())
                stack.pop();
            if (stack.empty() || cur > 0 || stack.peek() < 0) stack.push(cur);
            else if (cur < 0 && stack.peek() == Math.abs(cur)) stack.pop();
        }
        int[] res = new int[stack.size()];
        for (int i = res.length - 1; i >= 0; i--) res[i] = stack.pop();
        return res;
    }
}