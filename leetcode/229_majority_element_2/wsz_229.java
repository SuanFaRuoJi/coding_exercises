import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class wsz_229 {
    public List<Integer> majorityElement(int[] nums) {
        int[] candidates = {0, 0}, votes = {0, 0};
        for (int cur : nums) {
            if ((votes[0] == 0 && candidates[1] != cur) || candidates[0] == cur) {
                candidates[0] = cur;
                votes[0] += 1;
                continue;
            }
            if ((votes[1] == 0 && candidates[0] != cur) || candidates[1] == cur) {
                candidates[1] = cur;
                votes[1] += 1;
                continue;
            }
            votes[0] --;
            votes[1] --;
        }
        Set<Integer> result = new HashSet<>();
        int[] actual_votes = {0, 0};
        for (int cur : nums) {
            if (cur == candidates[0]) {
                actual_votes[0] ++;
            }
            if (cur == candidates[1]) {
                actual_votes[1] ++;
            }
        }
        if (actual_votes[0] > nums.length / 3) {
            result.add(candidates[0]);
        }
        if (actual_votes[1] > nums.length / 3) {
            result.add(candidates[1]);
        }
        return result.stream().collect(Collectors.toList());
    }
}
