import java.util.PriorityQueue;

public class jcy_lc871 {
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        int res = 0, tank = startFuel;
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        for (int[] station : stations) {
            while (tank < station[0]) {
                if (pq.isEmpty()) return -1;
                tank += pq.poll();
                res += 1;
            }
            pq.offer(station[1]);
        }
        while (tank < target) {
            if (pq.isEmpty()) return -1;
            tank += pq.poll();
            res += 1;
        }
        return res;
    }
}