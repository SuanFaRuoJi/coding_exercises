import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class jcy_lc1636 {
    public int[] frequencySort(int[] nums) {
        int[] freq = new int[201];
        for (int n : nums)
            freq[n + 100] += 1;
        TreeMap<Integer, List<Integer>> map = new TreeMap<>();
        for (int i = 200; i >= 0; i--) {
            if (freq[i] > 0) {
                map.putIfAbsent(freq[i], new ArrayList<>());
                map.get(freq[i]).add(i - 100);
            }
        }
        int[] res = new int[nums.length];
        int idx = 0;
        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            int curFreq = entry.getKey();
            for (int n : entry.getValue()) {
                for (int i = 0; i < curFreq; i++) {
                    res[idx] = n;
                    idx += 1;
                }
            }
        }
        return res;
    }
}