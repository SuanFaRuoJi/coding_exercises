import java.util.HashMap;
import java.util.Map;

public class jcy_lc1640 {
    public boolean canFormArray(int[] arr, int[][] pieces) {
        Map<Integer, int[]> map = new HashMap<>();
        for (int[] p : pieces) map.put(p[0], p);
        int idx = 0;
        while (idx < arr.length) {
            if (!map.containsKey(arr[idx])) return false;
            int[] curr = map.get(arr[idx]);
            for (int n : curr) {
                if (idx == arr.length || n != arr[idx]) return false;
                idx += 1;
            }
        }
        return true;
    }
}