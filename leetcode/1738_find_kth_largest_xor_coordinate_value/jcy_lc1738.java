import java.util.PriorityQueue;

public class jcy_lc1738 {
    public int kthLargestValue(int[][] matrix, int k) {
        int m = matrix.length, n = matrix[0].length;
        int[][] dp = new int[m][n];
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int x = (i - 1 < 0 ? 0 : dp[i - 1][j]);
                int y = (j - 1 < 0 ? 0 : dp[i][j - 1]);
                int z = (i - 1 < 0 || j - 1 < 0 ? 0 : dp[i - 1][j - 1]);
                dp[i][j] = (x ^ y ^ z ^ matrix[i][j]);
                pq.add(dp[i][j]);
                if (pq.size() > k) pq.poll();
            }
        }
        return pq.poll();
    }
}