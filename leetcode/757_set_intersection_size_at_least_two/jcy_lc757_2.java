import java.util.Arrays;

public class jcy_lc757_2 {
    public int intersectionSizeTwo(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[1] != b[1] ? a[1] - b[1] : b[0] - a[0]);
        int left = intervals[0][1] - 1, right = intervals[0][1], res = 2;
        for (int i = 1; i < intervals.length; i++) {
            int[] cur = intervals[i];
            if (left < cur[0] && cur[0] <= right) {
                res += 1;
                left = right;
                right = cur[1];
            } else if (cur[0] > right) {
                res += 2;
                left = cur[1] - 1;
                right = cur[1];
            }
        }
        return res;
    }
}