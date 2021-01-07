import java.util.TreeSet;

public class jcy_lc480_2 {
    public double[] medianSlidingWindow(int[] nums, int k) {
        int n = nums.length, idx = 0;
        double[] res = new double[n - k + 1];
        TreeSet<Integer> lo = new TreeSet<>((a, b) -> (nums[a] == nums[b] ? (a - b) : Integer.compare(nums[a], nums[b])));
        TreeSet<Integer> hi = new TreeSet<>((a, b) -> (nums[a] == nums[b] ? (a - b) : Integer.compare(nums[a], nums[b])));
        for (int i = 0; i < n; i++) {
            lo.add(i);
            hi.add(lo.pollLast());
            if (lo.size() < hi.size()) lo.add(hi.pollFirst());
            if (lo.size() + hi.size() == k) {
                res[idx] = lo.size() == hi.size() ? nums[lo.last()] / 2.0 + nums[hi.first()] / 2.0 : nums[lo.last()] * 1.0;
                if (!lo.remove(idx)) hi.remove(idx);
                idx += 1;
            }
        }
        return res;
    }
}