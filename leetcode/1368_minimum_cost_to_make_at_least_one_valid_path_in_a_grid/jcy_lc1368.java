import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class jcy_lc1368 {
    int[][] dir = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public int minCost(int[][] grid) {
        int m = grid.length, n = grid[0].length, cost = 0;
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) Arrays.fill(dp[i], Integer.MAX_VALUE);
        Queue<int[]> queue = new LinkedList<>();
        helper(grid, 0, 0, dp, cost, queue);
        while (!queue.isEmpty()) {
            cost += 1;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] curr = queue.poll();
                int r = curr[0], c = curr[1];
                for (int j = 0; j < 4; j++)
                    helper(grid, r + dir[j][0], c + dir[j][1], dp, cost, queue);
            }
        }
        return dp[m - 1][n - 1];
    }

    private void helper(int[][] grid, int r, int c, int[][] dp, int cost, Queue<int[]> queue) {
        int m = grid.length, n = grid[0].length;
        if (r < 0 || r >= m || c < 0 || c >= n || dp[r][c] != Integer.MAX_VALUE) return;
        dp[r][c] = cost;
        queue.add(new int[]{r, c});
        int next = grid[r][c] - 1;
        helper(grid, r + dir[next][0], c + dir[next][1], dp, cost, queue);
    }
}