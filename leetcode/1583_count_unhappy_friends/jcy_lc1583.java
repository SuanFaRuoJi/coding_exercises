import java.util.HashMap;
import java.util.Map;

public class jcy_lc1583 {
    public int unhappyFriends(int n, int[][] preferences, int[][] pairs) {
        int res = 0;
        int[] map = new int[n];
        for (int[] pair : pairs) {
            map[pair[0]] = pair[1];
            map[pair[1]] = pair[0];
        }
        Map<Integer, Integer>[] record = new Map[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - 1; j++) {
                if (record[i] == null) record[i] = new HashMap<>();
                record[i].put(preferences[i][j], j);
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j : preferences[i]) {
                if (record[i].get(j) < record[i].get(map[i]) &&
                        record[j].get(i) < record[j].get(map[j])) {
                    res += 1;
                    break;
                }
            }
        }
        return res;
    }
}