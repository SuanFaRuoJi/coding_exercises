public class java_1499 {
    public int findMaxValueOfEquation(int[][] points, int k) {
        int[] pre_calc = new int[points.length];
        int[] deque = new int[points.length];
        int left = 0, right = 0;
        int max = Integer.MIN_VALUE;
        for (int i=0; i<points.length; i++) {
            pre_calc[i] = points[i][1] - points[i][0];
        }
        for (int i=0; i<points.length; i++) {
            // pop all unusable elements
            while (left < right && points[i][0] - points[deque[left]][0] > k) {
                left ++;
            }

            // if there is an eligible option, try it with max
            if (left < right) {
                max = Math.max(max, points[i][0] + points[i][1] + pre_calc[deque[left]]);
            }

            while (left < right && pre_calc[i] > pre_calc[deque[right-1]]) {
                right --;
            }
            deque[right++] = i;
        }
        return max;
    }
}
