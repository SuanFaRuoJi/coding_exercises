import java.util.HashSet;
import java.util.Set;

public class jcy_lc349_optimized {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        for (int n : nums1) set.add(n);
        Set<Integer> intersection = new HashSet<>();
        for (int n : nums2)
            if (set.contains(n)) intersection.add(n);
        int[] res = new int[intersection.size()];
        int index = 0;
        for (int num : intersection) res[index++] = num;
        return res;
    }
}
