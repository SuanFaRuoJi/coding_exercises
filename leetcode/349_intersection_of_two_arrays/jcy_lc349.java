import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class jcy_lc349 {
    public int[] intersection(int[] nums1, int[] nums2) {
        List<Integer> list = new ArrayList<>();
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i = 0, j = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] == nums2[j]) {
                if (!list.contains(nums1[i])) list.add(nums1[i]);
                i += 1; j += 1;
            } else if (nums1[i] < nums2[j]) {
                i += 1;
            } else {
                j += 1;
            }
        }
        int[] res = new int[list.size()];
        for (int k = 0; k < list.size(); k++)
            res[k] = list.get(k);
        return res;
    }
}