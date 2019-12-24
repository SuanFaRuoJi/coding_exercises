import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class wsz_java_164 {
    private int maximumGapNoDupe(int[] nums) {
        if (nums.length < 2) {
            return 0;
        }
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int i=0; i<nums.length; i++) {
            int cur = nums[i];
            max = Math.max(cur, max);
            min = Math.min(cur, min);
        }
        int range = max - min, bucket_size = (int)Math.ceil(range / (double)(nums.length-1));
        if (bucket_size <= 0) {
            return 0;
        }

        int[][] buckets = new int[nums.length+1][2];
        for (int i=0; i<nums.length+1; i++) {
            buckets[i][0] = -1;
            buckets[i][1] = -1;
        }

        for (int i=0; i<nums.length+1; i++) {
            int cur = nums[i], index = (cur-min) / bucket_size;
            if (buckets[index][0] == -1) {
                buckets[index][0] = cur;
            } else {
                buckets[index][0] = Math.max(buckets[index][0], cur);
            }

            if (buckets[index][1] == -1) {
                buckets[index][1] = cur;
            } else {
                buckets[index][1] = Math.min(buckets[index][1], cur);
            }
        }

        int cur_min = buckets[0][1], cur_max = buckets[0][0], max_gap = cur_max - cur_min;
        for (int i=1; i<nums.length+1; i++) {
            if (buckets[i][0] != -1) {
                max_gap = Math.max(max_gap, buckets[i][0] - cur_min);
                cur_max = buckets[i][0];
                cur_min = buckets[i][1];
            }
        }
        return max_gap;
    }

    public int maximumGap(int[] nums) {
        Set<Integer> dedupe = new HashSet<>();
        List<Integer> no_dupe = new ArrayList<>();
        for (int i=0; i<nums.length; i++) {
            if (!dedupe.contains(nums[i])) {
                no_dupe.add(nums[i]);
                dedupe.add(nums[i]);
            }
        }
        int[] result = new int[no_dupe.size()];
        int i = 0;
        for (Integer cur : no_dupe) {
            result[i++] = cur;
        }
        return maximumGapNoDupe(result);
    }
}
