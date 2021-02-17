public class jcy_lc351 {
    public int numberOfPatterns(int m, int n) {
        int skip[][] = new int[10][10];
        skip[1][3] = skip[3][1] = 2;
        skip[1][7] = skip[7][1] = 4;
        skip[3][9] = skip[9][3] = 6;
        skip[7][9] = skip[9][7] = 8;
        skip[1][9] = skip[9][1] = skip[2][8] = skip[8][2] = skip[3][7] = skip[7][3] = skip[4][6] = skip[6][4] = 5;
        boolean visited[] = new boolean[10];
        int res = 0;
        res += helper(visited, m, n, skip, 1, 1) * 4;
        res += helper(visited, m, n, skip, 2, 1) * 4;
        res += helper(visited, m, n, skip, 5, 1);
        return res;
    }

    private int helper(boolean[] visited, int m, int n, int[][] skip, int cur, int level) {
        if (level > n) return 0;
        visited[cur] = true;
        int res = 0;
        for (int i = 1; i <= 9; i++)
            if (!visited[i] && (skip[cur][i] == 0 || (visited[skip[cur][i]])))
                res += helper(visited, m, n, skip, i, level + 1);
        visited[cur] = false;
        if (level >= m) res += 1;
        return res;
    }
}