import java.util.*;

public class jcy_lc1136 {
    public int minimumSemesters(int N, int[][] relations) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        int[] dp = new int[N + 1];
        for (int[] r : relations) {
            map.putIfAbsent(r[0], new ArrayList<>());
            map.get(r[0]).add(r[1]);
            dp[r[1]] += 1;
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= N; i++)
            if (dp[i] == 0) queue.add(i);
        int res = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int cur = queue.poll();
                N -= 1;
                if (!map.containsKey(cur)) continue;
                for (int course : map.remove(cur)) {
                    dp[course] -= 1;
                    if (dp[course] == 0) queue.add(course);
                }
            }
            res += 1;
        }
        return N == 0 ? res : -1;
    }
}