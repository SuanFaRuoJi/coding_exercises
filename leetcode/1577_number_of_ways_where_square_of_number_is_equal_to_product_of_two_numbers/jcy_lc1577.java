import java.util.HashMap;
import java.util.Map;

public class jcy_lc1577 {
    public int numTriplets(int[] nums1, int[] nums2) {
        long res = 0;
        for (long n : nums1) res += twoProduct(n * n, nums2);
        for (long n : nums2) res += twoProduct(n * n, nums1);
        return (int)res;
    }

    private long twoProduct(long n, int[] nums) {
        Map<Long, Long> map = new HashMap<>();
        long count = 0;
        for (long v : nums) {
            if (n % v == 0)
                count += map.getOrDefault(n / v, 0l);
            map.put(v, map.getOrDefault(v, 0l) + 1);
        }
        return count;
    }
}