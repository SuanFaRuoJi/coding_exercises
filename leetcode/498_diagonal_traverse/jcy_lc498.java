public class jcy_lc498 {
    public int[] findDiagonalOrder(int[][] matrix) {
        if (matrix.length == 0) return new int[0];
        int m = matrix.length, n = matrix[0].length, idx = 0, numLines = 0;
        int[] res = new int[m * n];
        if (m == 1 || n == 1) numLines = Math.max(m, n);
        else numLines = m + n - 1;
        for (int sumOfCoord = 0; sumOfCoord < numLines; sumOfCoord++) {
            if (sumOfCoord % 2 == 1) {
                for (int i = 0; i < m; i++) {
                    int j = sumOfCoord - i;
                    if (j < n && j >= 0) res[idx++] = matrix[i][j];
                }
            } else {
                for (int i = m - 1; i >= 0; i--) {
                    int j = sumOfCoord - i;
                    if (j < n && j >= 0) res[idx++] = matrix[i][j];
                }
            }
        }
        return res;
    }
}