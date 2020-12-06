import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class jcy_lc90_iterative {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>()); // Empty set
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            int count = 1;
            while (i + 1 < nums.length && nums[i] == nums[i + 1]) {
                count += 1;
                i += 1;
            }
            int prev = res.size();
            for (int j = 0; j < prev; j++) {
                List<Integer> temp = new ArrayList<Integer>(res.get(j));
                for (int t = 0; t < count; t++) {
                    temp.add(nums[i]);
                    res.add(new ArrayList<Integer>(temp));
                }
            }
        }
        return res;
    }
}