public class chengyou_lc547_dfs {
    public int findCircleNum(int[][] M) {
        int N = M.length, res = 0;
        int[] visited = new int[N];
        for (int i = 0; i < N; i++) {
            if (visited[i] == 0) {
                dfs(M, visited, i);
                res += 1;
            }
        }
        return res;
    }

    private void dfs(int[][] M, int[] visited, int idx) {
        for (int j = 0; j < M.length; j++) {
            if (M[idx][j] == 1 && visited[j] == 0) {
                visited[j] = 1;
                dfs(M, visited, j);
            }
        }
    }
}
