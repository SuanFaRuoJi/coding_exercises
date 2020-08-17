import java.util.ArrayDeque;
import java.util.Deque;

public class java_1499 {
    public int findMaxValueOfEquation(int[][] points, int k) {
        int[] pre_calc = new int[points.length];
        int max = Integer.MIN_VALUE;
        for (int i=0; i<points.length; i++) {
            pre_calc[i] = points[i][1] - points[i][0];
        }
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i=0; i<points.length; i++) {
            System.out.println(i);
            int cur = points[i][1] + points[i][0];
            int cur_val = pre_calc[i];

            while (!deque.isEmpty() && points[i][0] - points[deque.peekFirst()][0] > k) {
                deque.pollFirst();
            }

            if (!deque.isEmpty()) {
                int local = cur + pre_calc[deque.peekFirst()];
                if (local > max) {
                    max = local;
                }
            }

            while (!deque.isEmpty() && pre_calc[deque.peekLast()] < cur_val) {
                deque.pollLast();
            }
            deque.offerLast(i);
        }
        return max;
    }
}
