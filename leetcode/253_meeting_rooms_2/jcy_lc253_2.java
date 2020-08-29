import java.util.Arrays;

public class jcy_lc253_2 {
    public int minMeetingRooms(int[][] intervals) {
        int n = intervals.length;
        int[] start = new int[n], end = new int[n];
        for (int i = 0; i < n; i++) {
            start[i] = intervals[i][0];
            end[i] = intervals[i][1];
        }
        Arrays.sort(start);
        Arrays.sort(end);
        int i = 0, j = 0;
        int res = 0;
        while (i < n) {
            if (start[i] >= end[j]) {
                res -= 1;
                j += 1;
            }
            res += 1;
            i += 1;
        }
        return res;
    }
}