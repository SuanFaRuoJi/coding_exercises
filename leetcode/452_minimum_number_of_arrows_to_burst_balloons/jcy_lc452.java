import java.util.Arrays;

public class jcy_lc452 {
    public int findMinArrowShots(int[][] points) {
        if (points.length == 0) return 0;
        Arrays.sort(points, (a, b) -> Integer.compare(a[1], b[1]));
        int res = 1, curEnd = points[0][1];
        for (int[] p : points) {
            if (curEnd < p[0]) {
                res += 1;
                curEnd = p[1];
            }
        }
        return res;
    }
}