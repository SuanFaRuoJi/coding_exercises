public class jcy_lc1582 {
    public int numSpecial(int[][] mat) {
        int m = mat.length, n = mat[0].length, res = 0;
        int[] row = new int[m], col = new int[n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 1) {
                    row[i] += 1;
                    col[j] += 1;
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 1)
                    if (row[i] == 1 && col[j] == 1)
                        res += 1;
            }
        }
        return res;
    }
}