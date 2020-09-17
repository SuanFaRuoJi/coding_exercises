import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class jcy_lc632 {
    public int[] smallestRange(List<List<Integer>> nums) {
        TreeMap<Integer, List<Integer>> map = new TreeMap<>();
        for (int i = 0; i < nums.size(); i++) {
            for (int n : nums.get(i)) {
                if (!map.containsKey(n)) map.put(n, new ArrayList<>());
                map.get(n).add(i);
            }
        }
        List<Integer> list = new ArrayList<>(map.keySet());
        int i = 0, j = 0;
        int[] res = new int[]{list.get(0), list.get(list.size() - 1)};
        // check if the range includes at least one number from each list
        int[] count = new int[nums.size()];
        while (i < list.size()) {
            while (j < list.size() && !allIn(count)) {
                for (int idx : map.get(list.get(j))) count[idx] += 1;
                j += 1;
            }
            if (allIn(count) && (list.get(j - 1) - list.get(i)) < res[1] - res[0])
                res = new int[]{list.get(i), list.get(j - 1)};
            for (int idx : map.get(list.get(i))) count[idx] -= 1;
            i += 1;
        }
        return res;
    }

    private boolean allIn(int[] count) {
        for (int c : count)
            if (c == 0) return false;
        return true;
    }
}
