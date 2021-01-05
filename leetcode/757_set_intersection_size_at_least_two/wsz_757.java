import java.util.*;

public class wsz_757 {
    public int intersectionSizeTwo(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(arr -> arr[0]));
        int[] count = new int[intervals.length];
        HashSet<Integer> ans = new HashSet<>();
        int reach = -1, min = -1, min_arg = -1;

        for (int i=0; i<intervals.length; i++) {
            if (min_arg == -1) {
                min_arg = i;
                min = intervals[i][1];
            } else {
                if (intervals[i][0] >= min) {
                    ans.add(intervals[i-1][0]);
                    ans.add(intervals[min_arg][1]);
                } else {
                    if (count[min_arg] == 1) {
                        // SOMETHING MISSING HERE
                        // min_arg =
                    }
                }
            }
        }
        return ans.size();
    }
}
