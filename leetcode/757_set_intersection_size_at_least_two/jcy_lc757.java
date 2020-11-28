import java.util.Arrays;

public class jcy_lc757 {
    public int intersectionSizeTwo(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[1] - b[1]);
        int max = -1, secMax = -1, res = 0;
        for (int[] interval : intervals) {
            int start = interval[0], end = interval[1];
            if (start > max) {
                res += 2;
                max = end;
                secMax = end - 1;
            } else if (start > secMax) {
                res += 1;
                secMax = max == end ? max - 1 : max;
                max = end;
            }
        }
        return res;
    }
}
