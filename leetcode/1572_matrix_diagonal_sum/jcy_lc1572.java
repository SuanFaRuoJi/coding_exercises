public class jcy_lc1572 {
    public int diagonalSum(int[][] mat) {
        int n = mat.length, res = 0;
        for (int i = 0; i < n; i++) {
            if (i == n - 1 - i) res += mat[i][i];
            else res += mat[i][i] + mat[i][n - 1 - i];
        }
        return res;
    }
}