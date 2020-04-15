import java.util.ArrayList;
import java.util.List;

public class wsz_228 {
    public List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<>();
        int l = nums.length, left = 0, right = 0;
        while (right < l) {
            int next = right + 1;
            if (next >= l) {
                result.add(left == right ? nums[left] + "" : String.format("%s->%s", nums[left], nums[right]));
                return result;
            }
            if (nums[next] != nums[right] + 1) {
                result.add(left == right ? nums[left] + "" : String.format("%s->%s", nums[left], nums[right]));
                left = next;
            }
            right = next;
        }
        return result;
    }
}
