import java.util.PriorityQueue;

public class jcy_lc295 {
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> (b - a));
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();

    /** initialize your data structure here. */
    public jcy_lc295() {}

    public void addNum(int num) {
        maxHeap.add(num);
        minHeap.add(maxHeap.poll());
        if (minHeap.size() > maxHeap.size()) maxHeap.add(minHeap.poll());
    }

    public double findMedian() {
        if (maxHeap.size() == minHeap.size())
            return (maxHeap.peek() + minHeap.peek()) / 2.0;
        else return maxHeap.peek();
    }
}