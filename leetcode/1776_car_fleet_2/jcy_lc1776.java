import java.util.Stack;

public class jcy_lc1776 {
    public double[] getCollisionTimes(int[][] cars) {
        int n = cars.length;
        double[] res = new double[n];
        Stack<Integer> stack = new Stack<>();
        for (int i = n - 1; i >= 0; i--) {
            res[i] = - 1.0;
            int curP = cars[i][0], curS = cars[i][1];
            while (!stack.empty()) {
                int j = stack.peek(), prevP = cars[j][0], prevS = cars[j][1];
                if (curS <= prevS || 1.0 * (prevP - curP) / (curS - prevS) >= res[j] && res[j] > 0)
                    stack.pop();
                else break;
            }
            if (!stack.empty()) {
                int j = stack.peek(), prevP = cars[j][0], prevS = cars[j][1];
                res[i] = 1.0 * (prevP - curP) / (curS - prevS);
            }
            stack.add(i);
        }
        return res;
    }
}