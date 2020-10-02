public class jcy_lc329 {
    public int longestIncreasingPath(int[][] matrix) {
        if (matrix.length == 0) return 0;
        int m = matrix.length, n = matrix[0].length, res = 0;
        int[][] cache = new int[m][n];
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                res = Math.max(res, dfs(matrix, i, j, cache));
        return res;
    }

    private int dfs(int[][] matrix, int i, int j, int[][] cache) {
        int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int m = matrix.length, n = matrix[0].length;
        if (cache[i][j] != 0) return cache[i][j];
        for (int[] d : dirs) {
            int x = i + d[0], y = j + d[1];
            if (0 <= x && x < m && 0 <= y && y < n && matrix[x][y] > matrix[i][j])
                cache[i][j] = Math.max(cache[i][j], dfs(matrix, x, y, cache));
        }
        cache[i][j] += 1;
        return cache[i][j];
    }
}