import java.util.ArrayList;
import java.util.List;

public class jcy_lc254 {
    public List<List<Integer>> getFactors(int n) {
        List<List<Integer>> res = new ArrayList<>();
        helper(res, new ArrayList<>(), n, 2);
        return res;
    }

    private void helper(List<List<Integer>> res, List<Integer> curr, int n, int start) {
        for (int i = start; i * i <= n; i++) {
            if (n % i == 0) {
                curr.add(i);
                curr.add(n / i);
                res.add(new ArrayList<>(curr));
                curr.remove(curr.size() - 1);
                helper(res, curr, n / i, i);
                curr.remove(curr.size() - 1);
            }
        }
    }
}