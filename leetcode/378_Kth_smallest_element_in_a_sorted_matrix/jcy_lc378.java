public class jcy_lc378 {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int left = matrix[0][0], right = matrix[n - 1][n - 1];
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (countLessOrEqual(matrix, mid) < k) left = mid + 1;
            else right = mid - 1;
        }
        return left;
    }

    private int countLessOrEqual(int[][] matrix, int target) {
        int res = 0, n = matrix.length, i = n - 1, j = 0;
        while (i >= 0 && j < n) {
            if (matrix[i][j] <= target) {
                res += i + 1;
                j += 1;
            } else i -= 1;
        }
        return res;
    }
}