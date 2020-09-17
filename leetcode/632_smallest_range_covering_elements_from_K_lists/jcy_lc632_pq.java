import java.util.List;
import java.util.PriorityQueue;

public class jcy_lc632_pq {
    public int[] smallestRange(List<List<Integer>> nums) {
        PriorityQueue<int[]> pq
                = new PriorityQueue<>((a, b) -> nums.get(a[0]).get(a[1]) - nums.get(b[0]).get(b[1]));
        int max = Integer.MIN_VALUE, start = 0, end = Integer.MAX_VALUE;
        for (int i = 0; i < nums.size(); i++) {
            pq.offer(new int[]{i, 0});
            max = Math.max(max, nums.get(i).get(0));
        }
        while (pq.size() == nums.size()) {
            int curr[] = pq.poll(), listIdx = curr[0], numIdx = curr[1];
            if (end - start > max - nums.get(listIdx).get(numIdx)) {
                start = nums.get(listIdx).get(numIdx);
                end = max;
            }
            if (numIdx + 1 < nums.get(listIdx).size()) {
                pq.offer(new int[]{listIdx, numIdx + 1});
                max = Math.max(max, nums.get(listIdx).get(numIdx + 1));
            }
        }
        return new int[]{start, end};
    }
}