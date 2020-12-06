import java.util.ArrayList;
import java.util.List;

public class jcy_lc78 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(res, new ArrayList<>(), 0, nums);
        return res;
    }

    private void backtrack(List<List<Integer>> res, List<Integer> temp, int start, int[] nums) {
        res.add(new ArrayList<>(temp));
        for (int i = start; i < nums.length; i++) {
            temp.add(nums[i]);
            backtrack(res, temp, i + 1, nums);
            temp.remove(temp.size() - 1);
        }
    }
}