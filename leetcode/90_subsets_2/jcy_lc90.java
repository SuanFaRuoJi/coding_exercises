import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class jcy_lc90 {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(res, new ArrayList<>(), 0, nums);
        return res;
    }

    private void backtrack(List<List<Integer>> res, List<Integer> temp, int start, int[] nums) {
        res.add(new ArrayList<>(temp));
        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i - 1]) continue;
            temp.add(nums[i]);
            backtrack(res, temp, i + 1, nums);
            temp.remove(temp.size() - 1);
        }
    }
}