import java.util.PriorityQueue;

public class jcy_lc1167 {
    public int connectSticks(int[] sticks) {
        int res = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int len : sticks) pq.offer(len);
        while (pq.size() > 1) {
            int first = pq.poll(), second = pq.poll();
            res += first + second;
            pq.offer(first + second);
        }
        return res;
    }
}