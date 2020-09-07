import java.util.*;

public class jcy_lc349_set {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>(), set2 = new HashSet<>();
        for (int n : nums1) set1.add(n);
        for (int n : nums2) set2.add(n);
        List<Integer> list = new ArrayList<>();
        for (int n : set1)
            if (set2.contains(n) && !list.contains(n)) list.add(n);
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++)
            res[i] = list.get(i);
        return res;
    }
}