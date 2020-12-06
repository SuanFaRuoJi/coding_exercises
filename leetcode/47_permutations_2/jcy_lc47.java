import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class jcy_lc47 {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        boolean[] visited = new boolean[nums.length];
        backtrack(res, new ArrayList<>(), nums, visited);
        return res;
    }

    private void backtrack(List<List<Integer>> res, List<Integer> temp, int[] nums, boolean[] visited) {
        if (temp.size() == nums.length) res.add(new ArrayList<>(temp));
        else {
            for (int i = 0; i < nums.length; i++) {
                if (visited[i] || i > 0 && nums[i] == nums[i - 1] && !visited[i - 1]) continue;
                visited[i] = true;
                temp.add(nums[i]);
                backtrack(res, temp, nums, visited);
                visited[i] = false;
                temp.remove(temp.size() - 1);
            }
        }
    }
}