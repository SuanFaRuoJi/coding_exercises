public class chengyou_lc74 {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) return false;
        int m = matrix.length, n = matrix[0].length;
        int left = 0, right = m - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (matrix[mid][n - 1] < target) left = mid + 1;
            else right = mid - 1;
        }
        if (left == m) return false;
        int curRow = left;
        left = 0; right = n - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (matrix[curRow][mid] == target) return true;
            else if (matrix[curRow][mid] < target) left = mid + 1;
            else right = mid - 1;
        }
        return false;
    }
}
