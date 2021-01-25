import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class jcy_lc1733 {
    public int minimumTeachings(int n, int[][] languages, int[][] friendships) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int i = 0; i < languages.length; i++) {
            map.put(i + 1, new HashSet<>());
            for (int language : languages[i]) map.get(i + 1).add(language);
        }
        boolean[] visited = new boolean[friendships.length];
        for (int i = 0; i < friendships.length; i++) {
            for (int j : map.get(friendships[i][0])) {
                if (map.get(friendships[i][1]).contains(j)) {
                    visited[i] = true;
                    break;
                }
            }
        }
        int res = Integer.MAX_VALUE;
        for (int i = 1; i <= n; i++) {
            Set<Integer> set = new HashSet<>();
            for (int j = 0; j < friendships.length; j++) {
                if (visited[j]) continue;
                if (!map.get(friendships[j][0]).contains(i)) set.add(friendships[j][0]);
                if (!map.get(friendships[j][1]).contains(i)) set.add(friendships[j][1]);
            }
            res = Math.min(set.size(), res);
        }
        return res;
    }
}
