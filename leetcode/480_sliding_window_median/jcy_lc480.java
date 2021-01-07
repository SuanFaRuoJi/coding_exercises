import java.util.Collections;
import java.util.PriorityQueue;

public class jcy_lc480 {
    public double[] medianSlidingWindow(int[] nums, int k) {
        double[] res = new double[nums.length - k + 1];
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(Collections.reverseOrder());
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
        int idx = 0;
        for (int i = 0; i < nums.length; i++) {
            if (maxHeap.isEmpty() || nums[i] < maxHeap.peek()) maxHeap.add(nums[i]);
            else minHeap.add(nums[i]);
            if (minHeap.size() > maxHeap.size()) maxHeap.add(minHeap.poll());
            if (maxHeap.size() > minHeap.size() + 1) minHeap.add(maxHeap.poll());
            if (i >= k - 1) {
                if (k % 2 == 1) res[idx] = 1.0 * maxHeap.peek();
                else res[idx] = maxHeap.peek() / 2.0 + minHeap.peek() / 2.0;
                idx += 1;
                int prev = nums[i - k + 1];
                if (prev <= maxHeap.peek()) maxHeap.remove(prev);
                else minHeap.remove(prev);
                if (minHeap.size() > maxHeap.size()) maxHeap.add(minHeap.poll());
                if (maxHeap.size() > minHeap.size() + 1) minHeap.add(maxHeap.poll());
            }
        }
        return res;
    }
}