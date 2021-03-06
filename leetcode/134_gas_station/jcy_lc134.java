public class jcy_lc134 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length, total = 0, cur = 0, start = 0;
        for (int i = 0; i < n; i++) {
            total += gas[i] - cost[i];
            cur += gas[i] - cost[i];
            if (cur < 0) {
                start = i + 1;
                cur = 0;
            }
        }
        return total >= 0 ? start : -1;
    }
}