import java.util.HashMap;
import java.util.Map;

public class wsz_220 {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        int length = nums.length;
        int min = Integer.MAX_VALUE;
        Map<Long, Long> buckets = new HashMap<>();
        for (int i = 0; i < length; i++) {
            if (nums[i] < min) {
                min = nums[i];
            }
        }
        for (int i = 0; i < length; i++) {
            long offset = nums[i] - min;
            long bucket = offset / (t+1);
            if (buckets.containsKey(bucket) ||
                    (buckets.containsKey(bucket - 1) && Math.abs(buckets.get(bucket - 1) - offset) <= t) ||
                    (buckets.containsKey(bucket + 1) && Math.abs(buckets.get(bucket + 1) - offset) <= t)) {
                return true;
            }
            buckets.put(bucket, offset);
            if (i >= t) {
                int remove_index = i - t;
                long remove_offset = nums[remove_index] - min;
                long remove_bucket = remove_offset / (t+1);
                buckets.remove(remove_bucket);
            }
        }
        return false;
    }
}
