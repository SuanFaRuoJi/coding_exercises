import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class jcy_lc1235_2 {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n = startTime.length;
        int[][] jobs = new int[n][3];
        for (int i = 0; i < n; i++)
            jobs[i] = new int[]{startTime[i], endTime[i], profit[i]};
        Arrays.sort(jobs, (a, b) -> a[1] - b[1]);
        List<Integer> dpEndTime = new ArrayList<>(), dpProfit = new ArrayList<>();
        dpEndTime.add(0); dpProfit.add(0);
        for (int[] job : jobs) {
            int prevIdx = binarySearch(dpEndTime, job[0]);
            int profit1 = dpProfit.get(dpProfit.size() - 1);
            int profit2 = dpProfit.get(prevIdx) + job[2];
            if (profit1 < profit2) {
                dpEndTime.add(job[1]);
                dpProfit.add(profit2);
            }
        }
        return dpProfit.get(dpProfit.size() - 1);
    }

    private int binarySearch(List<Integer> list, int target) {
        int left = 0, right = list.size();
        while (left + 1< right) {
            int mid = left + (right - left) / 2;
            if (list.get(mid) <= target) left = mid;
            else right = mid;
        }
        return left;
    }
}