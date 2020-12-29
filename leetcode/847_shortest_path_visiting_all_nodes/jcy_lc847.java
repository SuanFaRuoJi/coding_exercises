import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class jcy_lc847 {
    public int shortestPathLength(int[][] graph) {
        int n = graph.length;
        int[][] dp = new int[n][1 << n];
        Queue<State> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
            dp[i][1 << i] = 0;
            queue.add(new State(1 << i, i));
        }
        while (!queue.isEmpty()) {
            State cur = queue.poll();
            for (int next : graph[cur.source]) {
                int nextMask = cur.mask | 1 << next;
                if (dp[next][nextMask] > dp[cur.source][cur.mask] + 1) {
                    dp[next][nextMask] = dp[cur.source][cur.mask] + 1;
                    queue.add(new State(nextMask, next));
                }
            }
        }
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++)
            res = Math.min(res, dp[i][(1 << n) - 1]);
        return res;
    }

    class State {
        int mask, source;
        public State(int m, int s) {
            mask = m;
            source = s;
        }
    }
}